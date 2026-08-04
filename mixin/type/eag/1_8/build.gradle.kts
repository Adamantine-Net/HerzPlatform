import java.util.zip.ZipFile

evaluationDependsOn(":mixin:mixin-loader")

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val eaglerModule = gradle.includedBuild("module-eag-1_8")
val vanillaClassesDir = rootDir.resolve("modules/module-eag-1_8/build/classes/java/main")

val modJarSourceDir = layout.buildDirectory.dir("modJarSources").get().asFile
modJarSourceDir.mkdirs()

val modJarsDirForSource = rootDir.resolve("mods/eagler/mods")
if (modJarsDirForSource.exists()) {
    modJarsDirForSource.listFiles { f -> f.isFile && f.name.endsWith(".jar") }?.forEach { jarFile ->
        ZipFile(jarFile).use { zip ->
            val entries = zip.entries()
            while (entries.hasMoreElements()) {
                val entry = entries.nextElement()
                if (!entry.isDirectory && entry.name.endsWith(".java")) {
                    val outFile = modJarSourceDir.resolve(entry.name)
                    outFile.parentFile.mkdirs()
                    zip.getInputStream(entry).use { input ->
                        outFile.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }
            }
        }
    }
}

//fixed/changed
sourceSets {
    named("main") {
        java.srcDir(rootDir.resolve("src/common/java"))
        java.exclude("net/ada/main/**") //YAY IT COMPILED
        java.exclude("net/ada/v1_14/**")
        java.exclude("net/ada/v1_5_2/**")//exclude

        java.srcDir(modJarSourceDir)

        val modsDir = rootDir.resolve("mods/eagler/mods")
        if (modsDir.exists()) {
            modsDir.listFiles { f -> f.isDirectory }?.forEach { modFolder ->
                val modSrc = modFolder.resolve("src/main/java")
                if (modSrc.exists()) {
                    java.srcDir(modSrc)
                }
            }
        }
    }
}

dependencies {
    compileOnly(files(vanillaClassesDir))
    implementation(project(":mixin:mixin-loader"))
}

tasks.named<JavaCompile>("compileJava") {
    dependsOn(eaglerModule.task(":compileJava"))
}

tasks.register("compileMixins") {
    group = "mixins"
    description = "Compiles the 1.8 mixin classes"
    dependsOn(tasks.named("compileJava"))
}

val wovenClassesDir = layout.buildDirectory.dir("full/classes")

val modJarsDir = rootDir.resolve("mods/eagler/mods")

val extractModJars = tasks.register<Copy>("extractModJars") {
    group = "mixins"
    description = "Unzips any .jar dropped in mods/eagler/mods into the compiled classes dir"

    dependsOn(tasks.named("compileJava"))

    if (modJarsDir.exists()) {
        modJarsDir.listFiles { f -> f.isFile && f.name.endsWith(".jar") }?.forEach { jarFile ->
            from(zipTree(jarFile)) {
                include("**/*.class")
            }
        }
    }

    into(tasks.named<JavaCompile>("compileJava").get().destinationDirectory)
}

val compileFull = tasks.register<JavaExec>("compileFull") {
    group = "mixins"
    description = "applies the 1.8 mixins onto the vanilla eaggler classes"

    dependsOn(tasks.named("compileMixins"))
    dependsOn(extractModJars)
    dependsOn(eaglerModule.task(":compileJava"))
    dependsOn(":mixin:mixin-loader:compileJava")

    classpath = files(
        project(":mixin:mixin-loader").sourceSets["main"].runtimeClasspath
    )
    mainClass.set("net.ada.mixin.weaver.MixinWeaver")

    doFirst {
        args = listOf(
            tasks.named<JavaCompile>("compileJava").get().destinationDirectory.get().asFile.path,
            vanillaClassesDir.path,
            wovenClassesDir.get().asFile.path
        )
    }

    outputs.dir(wovenClassesDir)
}

tasks.named("build") {
    dependsOn(compileFull)
}

tasks.register("compileWithMods") {
    group = "mixins"
    description = "Same as compileFull - anything dropped in mods/eagler/mods gets included automatically"
    dependsOn(compileFull)
}