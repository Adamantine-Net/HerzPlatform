package net.ada.mixin.weaver;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.ModifyConstant;
import net.ada.mixin.annotation.Overwrite;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.MethodRemapper;
import org.objectweb.asm.commons.SimpleRemapper;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.net.URLClassLoader;
//import java.nio.file.Comparator; // wrong package lol, its in java.util
import java.util.Comparator;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
//import java.util.ArrayList;
import java.util.stream.Collectors;

public final class MixinWeaver {

    //fake mixin loader <3

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("usage: mixinweaver <mixins> <vanilla> <out>");
            System.exit(1);
            return;
        }

        Path mixinDir = Paths.get(args[0]);
        Path vanillaDir = Paths.get(args[1]);
        Path outDir = Paths.get(args[2]);

        //nuke wtver was left over from the last run and start completelly fresh off the vanilla classes every time otherwise you get usless fucked up double injected slop
        deleteRecursive(outDir);
        copyRecursive(vanillaDir, outDir);

        if (!Files.exists(mixinDir)) {
            System.out.println("no mixins found, skipping");
            return;
        }

        List<Path> mixinClassFiles;
        try (java.util.stream.Stream<Path> walk = Files.walk(mixinDir)) {
            mixinClassFiles = walk.filter(p -> p.toString().endsWith(".class"))
                    .collect(Collectors.toList());
        }

        if (mixinClassFiles.isEmpty()) {
            System.out.println("no mixins found, skipping");
            return;
        }

        //need both dirs on the classpath here so reflection can actually load the mixin classes themselves + reslove whtver eagler types they referejce
        URLClassLoader loader = new URLClassLoader(
                new URL[]{mixinDir.toUri().toURL(), vanillaDir.toUri().toURL()},
                MixinWeaver.class.getClassLoader()
        );

        int mixinCount = 0;
        int injectCount = 0;
        int overwriteCount = 0;
        int modifyCount = 0;

        for (Path classFile : mixinClassFiles) {
            byte[] bytes = Files.readAllBytes(classFile);
            ClassNode mixinNode = new ClassNode();
            new ClassReader(bytes).accept(mixinNode, ClassReader.EXPAND_FRAMES);

            String binaryName = mixinNode.name.replace('/', '.');
            Class<?> mixinClass;
            try {
                mixinClass = Class.forName(binaryName, false, loader);
            } catch (ClassNotFoundException e) {
                // not actually loadable for w/e reason just skip instead of dying
                continue;
            }

            Mixin mixinAnnotation = mixinClass.getAnnotation(Mixin.class);
            if (mixinAnnotation == null) {
                Path dest = outDir.resolve(mixinNode.name + ".class");
                Files.createDirectories(dest.getParent());
                Files.write(dest, bytes);
                continue;
            }

            String targetInternalName = Type.getInternalName(mixinAnnotation.value());
            Path targetClassFile = outDir.resolve(targetInternalName + ".class");
            if (!Files.exists(targetClassFile)) {
                // this usually means either a typo in the target class or the vanilla calsses dir is straight up stale/didnt get recomped b4 hand
                throw new IllegalStateException(binaryName + " targets " + mixinAnnotation.value().getName()
                        + " but it's not under " + outDir);
            }

            ClassNode targetNode = new ClassNode();
            new ClassReader(Files.readAllBytes(targetClassFile)).accept(targetNode, ClassReader.EXPAND_FRAMES);

            //remaps mixinclass -> targetclass on everything we copy over
            SimpleRemapper remapper = new SimpleRemapper(mixinNode.name, targetNode.name);
            int injectIndex = 0;

            for (java.lang.reflect.Method reflectMethod : mixinClass.getDeclaredMethods()) {
                Inject inject = reflectMethod.getAnnotation(Inject.class);
                Overwrite overwrite = reflectMethod.getAnnotation(Overwrite.class);
                ModifyConstant modifyConstant = reflectMethod.getAnnotation(ModifyConstant.class);
                if (inject == null && overwrite == null && modifyConstant == null) {
                    continue; //plain helper method on the mixin class, not a real mixin op
                }

                if (modifyConstant != null) {
                    MethodNode targetMethod = findMethod(targetNode, modifyConstant.method());
                    if (targetMethod == null) {
                        throw new IllegalStateException("@ModifyConstant " + binaryName + " method '"
                                + modifyConstant.method() + "' not found on " + mixinAnnotation.value().getName());
                    }
                    patchConstant(targetMethod, modifyConstant.constant(), modifyConstant.replacement(), binaryName);
                    modifyCount++;
                    continue;
                }

                String desc = Type.getMethodDescriptor(reflectMethod);
                MethodNode mixinMethod = findMethodNode(mixinNode, reflectMethod.getName(), desc);
                if (mixinMethod == null) {
                    continue;
                }

                if (inject != null) {
                    MethodNode targetMethod = findMethod(targetNode, inject.method());
                    if (targetMethod == null) {
                        throw new IllegalStateException("@Inject " + binaryName + " method '"
                                + inject.method() + "' not found on " + mixinAnnotation.value().getName());
                    }

                    boolean targetIsStatic = (targetMethod.access & Opcodes.ACC_STATIC) != 0;
                    boolean handlerIsStatic = (mixinMethod.access & Opcodes.ACC_STATIC) != 0;
                    if (targetIsStatic != handlerIsStatic) {
                        throw new IllegalStateException(binaryName + "#" + mixinMethod.name + " needs to be "
                                + (targetIsStatic ? "static" : "non-static") + " to match its target");
                    }

                    // copy the handler body in as its own new private method first, THEN hook the og method to call it
                    String handlerName = "mixin$" + mixinMethod.name + "$" + (injectIndex++);
                    int handlerAccess = Opcodes.ACC_PRIVATE | (handlerIsStatic ? Opcodes.ACC_STATIC : 0);
                    MethodNode handlerMethod = copyRemapped(mixinMethod, remapper, handlerName, handlerAccess);
                    targetNode.methods.add(handlerMethod);

                    weaveAdvice(targetNode, targetMethod, handlerName, mixinMethod.desc, inject.at(), targetIsStatic);
                    injectCount++;
                } else {
                    MethodNode targetMethod = findMethodNode(targetNode, mixinMethod.name, mixinMethod.desc);
                    if (targetMethod == null) {
                        throw new IllegalStateException("@Overwrite " + mixinMethod.name + mixinMethod.desc
                                + " in " + binaryName + " doesn't match anything on " + mixinAnnotation.value().getName());
                    }
                    // @Overwrite is just a straight up swap no advice/wrapping needed at all jst replace the whole method body w/ the mixins vers
                    MethodNode replaced = copyRemapped(mixinMethod, remapper, targetMethod.name, targetMethod.access);
                    targetNode.methods.remove(targetMethod);
                    targetNode.methods.add(replaced);
                    overwriteCount++;
                }
            }

            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            targetNode.accept(cw);
            Files.write(targetClassFile, cw.toByteArray());
            mixinCount++;
        }

        loader.close();
        System.out.println("wove " + mixinCount + " mixin(s), " + injectCount + " inject, " + overwriteCount + " overwrite, " + modifyCount + " modify");
    }

    private static void patchConstant(MethodNode method, int constant, int replacement, String binaryName) {
        AbstractInsnNode match = null;
        for (AbstractInsnNode insn : method.instructions.toArray()) {
            Integer value = getPushedInt(insn);
            if (value != null && value == constant) {
                if (match != null) {
                    throw new IllegalStateException("@ModifyConstant " + binaryName + " found more than one "
                            + constant + " in " + method.name + ", cant tell which one you meant");
                }
                match = insn;
            }
        }
        if (match == null) {
            throw new IllegalStateException("@ModifyConstant " + binaryName + " didnt find " + constant
                    + " anywhere in " + method.name);
        }
        method.instructions.set(match, pushInt(replacement));
    }

    private static Integer getPushedInt(AbstractInsnNode insn) {
        int opcode = insn.getOpcode();
        if (opcode >= Opcodes.ICONST_M1 && opcode <= Opcodes.ICONST_5) {
            return opcode - Opcodes.ICONST_0;
        }
        if (opcode == Opcodes.BIPUSH || opcode == Opcodes.SIPUSH) {
            return ((IntInsnNode) insn).operand;
        }
        if (opcode == Opcodes.LDC) {
            Object cst = ((LdcInsnNode) insn).cst;
            if (cst instanceof Integer) {
                return (Integer) cst;
            }
        }
        return null;
    }

    private static AbstractInsnNode pushInt(int value) {
        if (value >= -1 && value <= 5) {
            return new InsnNode(Opcodes.ICONST_0 + value);
        }
        if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
            return new IntInsnNode(Opcodes.BIPUSH, value);
        }
        if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
            return new IntInsnNode(Opcodes.SIPUSH, value);
        }
        return new LdcInsnNode(value);
    }

    private static MethodNode copyRemapped(MethodNode original, SimpleRemapper remapper, String newName, int newAccess) {
        MethodNode copy = new MethodNode(
                newAccess,
                newName,
                original.desc,
                original.signature,
                original.exceptions == null ? null : original.exceptions.toArray(new String[0])
        );
        original.accept(new MethodRemapper(copy, remapper));
        return copy;
    }

    private static void weaveAdvice(ClassNode targetNode, MethodNode targetMethod, String handlerName,
                                    String handlerDesc, At at, boolean isStatic) {
        MethodNode woven = new MethodNode(
                targetMethod.access,
                targetMethod.name,
                targetMethod.desc,
                targetMethod.signature,
                targetMethod.exceptions == null ? null : targetMethod.exceptions.toArray(new String[0])
        );

        AdviceAdapter advice = new AdviceAdapter(Opcodes.ASM9, woven, targetMethod.access, targetMethod.name, targetMethod.desc) {
            @Override
            protected void onMethodEnter() {
                if (at == At.HEAD) {
                    emitHandlerCall();
                }
            }

            @Override
            protected void onMethodExit(int opcode) {
                if (at == At.TAIL && opcode != Opcodes.ATHROW) {
                    emitHandlerCall();
                }
            }

            private void emitHandlerCall() {
                if (!isStatic) {
                    loadThis();
                }
                loadArgs();
                // private methods HAVE to be called w/ invokespecial, invokevirtual or it will litterally just blow up at verify time :soB:
                int invokeOpcode = isStatic ? Opcodes.INVOKESTATIC : Opcodes.INVOKESPECIAL;
                visitMethodInsn(invokeOpcode, targetNode.name, handlerName, handlerDesc, false);
            }
        };

        targetMethod.accept(advice);
        targetNode.methods.remove(targetMethod);
        targetNode.methods.add(woven);
    }
    private static MethodNode findMethod(ClassNode node, String spec) {
        int paren = spec.indexOf('(');
        if (paren >= 0) {
            String name = spec.substring(0, paren);
            String desc = spec.substring(paren);
            return findMethodNode(node, name, desc);
        }

        MethodNode match = null;
        for (MethodNode m : node.methods) {
            if (m.name.equals(spec)) {
                if (match != null) {
                    throw new IllegalStateException("'" + spec + "' is amgibous on " + node.name
                            + ", add a descriptor: " + spec + "(...)");
                }
                match = m;
            }
        }
        return match;
    }

    private static MethodNode findMethodNode(ClassNode node, String name, String desc) {
        for (MethodNode m : node.methods) {
            if (m.name.equals(name) && m.desc.equals(desc)) {
                return m;
            }
        }
        return null;
    }

    private static void copyRecursive(Path src, Path dst) throws IOException {
        try (java.util.stream.Stream<Path> walk = Files.walk(src)) {
            walk.forEach(source -> {
                try {
                    Path target = dst.resolve(src.relativize(source));
                    if (Files.isDirectory(source)) {
                        Files.createDirectories(target);
                    } else {
                        Files.createDirectories(target.getParent());
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }

    private static void deleteRecursive(Path dir) throws IOException {
        if (!Files.exists(dir)) {
            return; // nothing to ddel
        }
        try (java.util.stream.Stream<Path> walk = Files.walk(dir)) {
            walk.sorted(Comparator.reverseOrder()).forEach(p -> {
                try {
                    Files.delete(p);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }

    private MixinWeaver() {
        // no instances of ths its just a static main() basically
    }
}