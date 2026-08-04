package net.ada.v1_8.worldgen;

import java.util.ArrayList;
import java.util.List;

public final class WorldGenRegistry {

    private static final List<OreGenEntry> entries = new ArrayList<>();

    public static void register(OreGenEntry entry) {
        entries.add(entry);
    }

    public static List<OreGenEntry> getAll() {
        return entries;
    }

    private WorldGenRegistry() {
    }
}
