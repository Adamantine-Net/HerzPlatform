package net.ada.v1_5_2.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class EntityRegistry {

    private static int nextId = 300;
    private static final List<Pending> pending = new ArrayList<>();

    public static void register(String name, Class<? extends Entity> entityClass, Function<World, Entity> constructor) {
        pending.add(new Pending(name, entityClass, constructor));
    }

    public static List<Pending> flush() {
        List<Pending> resolved = new ArrayList<>();
        for (Pending p : pending) {
            resolved.add(new Pending(p.name, p.entityClass, p.constructor, nextId++));
        }
        pending.clear();
        return resolved;
    }

    public static final class Pending {
        public final String name;
        public final Class<? extends Entity> entityClass;
        public final Function<World, Entity> constructor;
        public final int id;

        Pending(String name, Class<? extends Entity> entityClass, Function<World, Entity> constructor) {
            this(name, entityClass, constructor, 0);
        }

        Pending(String name, Class<? extends Entity> entityClass, Function<World, Entity> constructor, int id) {
            this.name = name;
            this.entityClass = entityClass;
            this.constructor = constructor;
            this.id = id;
        }
    }

    private EntityRegistry() {
    }
}
