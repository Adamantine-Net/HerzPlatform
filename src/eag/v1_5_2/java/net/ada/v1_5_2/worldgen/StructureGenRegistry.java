package net.ada.v1_5_2.worldgen;

import net.minecraft.src.MapGenStructure;

import java.util.ArrayList;
import java.util.List;

public final class StructureGenRegistry {

    private static final List<MapGenStructure> generators = new ArrayList<>();

    public static void register(MapGenStructure generator) {
        generators.add(generator);
    }

    public static List<MapGenStructure> getAll() {
        return generators;
    }

    private StructureGenRegistry() {
    }
}
