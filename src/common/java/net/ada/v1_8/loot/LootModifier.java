package net.ada.v1_8.loot;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface LootModifier {
    void drop(World world, BlockPos pos, IBlockState state, float chance, int fortune);
}
