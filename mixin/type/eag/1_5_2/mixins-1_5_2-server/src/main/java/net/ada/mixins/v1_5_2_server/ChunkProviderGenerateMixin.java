package net.ada.mixins.v1_5_2_server;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_5_2.worldgen.OreGenEntry;
import net.ada.v1_5_2.worldgen.StructureGenRegistry;
import net.ada.v1_5_2.worldgen.WorldGenRegistry;

import net.lax1dude.eaglercraft.sp.EaglercraftRandom;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.World;
import net.minecraft.src.ChunkProviderGenerate;

@Mixin(ChunkProviderGenerate.class)
public class ChunkProviderGenerateMixin {

    @Shadow
    private World worldObj;
    @Shadow
    private EaglercraftRandom rand;

    @Inject(method = "populate", at = At.BEFORE_CALL, target = "decorate")
    private void herz$beforeDecorate(IChunkProvider provider, int chunkX, int chunkZ) {
        for (MapGenStructure structure : StructureGenRegistry.getAll()) {
            structure.generateStructuresInChunk(worldObj, rand, chunkX, chunkZ);
        }

        int baseX = chunkX * 16;
        int baseZ = chunkZ * 16;
        for (OreGenEntry entry : WorldGenRegistry.getAll()) {
            for (int i = 0; i < entry.attemptsPerChunk; ++i) {
                int x = baseX + rand.nextInt(16);
                int y = entry.minHeight + rand.nextInt(entry.maxHeight - entry.minHeight);
                int z = baseZ + rand.nextInt(16);
                entry.generator.generate(worldObj, rand, x, y, z);
            }
        }
    }
}
