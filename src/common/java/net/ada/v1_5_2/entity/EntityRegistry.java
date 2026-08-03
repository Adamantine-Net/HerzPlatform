package net.ada.v1_5_2.entity;

import net.ada.api.registry.IdMapping;

import net.minecraft.src.Entity;
import net.minecraft.src.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class EntityRegistry {

    public static final IdMapping IDS = new IdMapping(300);
    private static final List<Request> pending = new ArrayList<>();

    public static void register(String name, Class<? extends Entity> entityClass, Function<World, Entity> constructor) {
        pending.add(new Request(name, entityClass, constructor));
    }

    public static List<Pending> flush() {
        List<Pending> resolved = new ArrayList<>();
        for (Request r : pending) {
            resolved.add(new Pending(r.name, r.entityClass, r.constructor, IDS.assign(r.name)));
        }
        pending.clear();
        return resolved;
    }

    private static final class Request {
        final String name;
        final Class<? extends Entity> entityClass;
        final Function<World, Entity> constructor;

        Request(String name, Class<? extends Entity> entityClass, Function<World, Entity> constructor) {
            this.name = name;
            this.entityClass = entityClass;
            this.constructor = constructor;
        }
    }

    public static final class Pending {
        public final String name;
        public final Class<? extends Entity> entityClass;
        public final Function<World, Entity> constructor;
        public final int id;

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
