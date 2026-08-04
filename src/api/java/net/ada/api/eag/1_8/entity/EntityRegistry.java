package net.ada.v1_8.entity;

import net.ada.api.registry.IdMapping;

import net.lax1dude.eaglercraft.v1_8.minecraft.EntityConstructor;
import net.minecraft.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public final class EntityRegistry {

    public static final IdMapping IDS = new IdMapping(20000);
    private static final List<Request> pending = new ArrayList<>();

    public static void register(String name, Class<? extends Entity> entityClass,
                                 EntityConstructor<? extends Entity> constructor) {
        pending.add(new Request(name, entityClass, constructor));
    }

    public static List<Pending> flush() {
        List<Pending> resolved = new ArrayList<>();
        for (Request request : pending) {
            resolved.add(new Pending(request.name, request.entityClass, request.constructor, IDS.assign(request.name)));
        }
        pending.clear();
        return resolved;
    }

    private static final class Request {
        final String name;
        final Class<? extends Entity> entityClass;
        final EntityConstructor<? extends Entity> constructor;

        Request(String name, Class<? extends Entity> entityClass, EntityConstructor<? extends Entity> constructor) {
            this.name = name;
            this.entityClass = entityClass;
            this.constructor = constructor;
        }
    }

    public static final class Pending {
        public final String name;
        public final Class<? extends Entity> entityClass;
        public final EntityConstructor<? extends Entity> constructor;
        public final int id;

        Pending(String name, Class<? extends Entity> entityClass,
                EntityConstructor<? extends Entity> constructor, int id) {
            this.name = name;
            this.entityClass = entityClass;
            this.constructor = constructor;
            this.id = id;
        }
    }

    private EntityRegistry() {
    }
}
