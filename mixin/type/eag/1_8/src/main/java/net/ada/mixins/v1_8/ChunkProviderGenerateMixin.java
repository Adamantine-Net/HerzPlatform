package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_8.worldgen.OreGenEntry;
import net.ada.v1_8.worldgen.StructureGenRegistry;
import net.ada.v1_8.worldgen.WorldGenRegistry;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.structure.MapGenStructure;

@Mixin(ChunkProviderGenerate.class)
public class ChunkProviderGenerateMixin {

    @Shadow
    private World worldObj;
    @Shadow
    private EaglercraftRandom rand;

    //used b4 call instead because if not itll overlap with trees and shit
    @Inject(method = "populate", at = At.BEFORE_CALL, target = "decorate")
    private void herz$afterPopulate(IChunkProvider provider, int chunkX, int chunkZ) {
        ChunkCoordIntPair coords = new ChunkCoordIntPair(chunkX, chunkZ);

        for (MapGenStructure structure : StructureGenRegistry.getAll()) {
            structure.generateStructure(worldObj, rand, coords);
        }

        int baseX = chunkX * 16;
        int baseZ = chunkZ * 16;

        //random ore spots <3
        for (OreGenEntry entry : WorldGenRegistry.getAll()) {
            for (int i = 0; i < entry.attemptsPerChunk; ++i) {
                int x = baseX + rand.nextInt(16);
                int y = entry.minHeight + rand.nextInt(entry.maxHeight - entry.minHeight);
                int z = baseZ + rand.nextInt(16);
                entry.generator.generate(worldObj, rand, new BlockPos(x, y, z));
            }
        }
    }
}