package net.ada.v1_5_2.capability;

import net.minecraft.src.World;

import java.util.ArrayList;
import java.util.List;

public final class BlockCapabilityRegistry {

    public interface Attacher {
        void attach(World world, int x, int y, int z);
    }

    private static final List<Attacher> attachers = new ArrayList<>();

    public static void register(Attacher attacher) {
        attachers.add(attacher);
    }

    public static void attachAll(World world, int x, int y, int z) {
        for (Attacher attacher : attachers) {
            attacher.attach(world, x, y, z);
        }
    }

    private BlockCapabilityRegistry() {
    }
}
