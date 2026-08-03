package net.ada.v1_8.worldgen;

import net.minecraft.world.gen.structure.MapGenStructure;

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
