package net.ada.v1_8.capability;

import net.minecraft.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public final class EntityCapabilityRegistry {

    public interface Attacher {
        void attach(Entity entity);
    }

    private static final List<Attacher> attachers = new ArrayList<>();

    public static void register(Attacher attacher) {
        attachers.add(attacher);
    }

    public static void attachAll(Entity entity) {
        for (Attacher attacher : attachers) {
            attacher.attach(entity);
        }
    }

    private EntityCapabilityRegistry() {
    }
}
