package net.ada.v1_8.worldgen;

import net.minecraft.world.gen.feature.WorldGenerator;

public final class OreGenEntry {

    public final WorldGenerator generator;
    public final int attemptsPerChunk;
    public final int minHeight;
    public final int maxHeight;

    public OreGenEntry(WorldGenerator generator, int attemptsPerChunk, int minHeight, int maxHeight) {
        this.generator = generator;
        this.attemptsPerChunk = attemptsPerChunk;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
}
