package net.ada.v1_8.event;

import net.ada.api.event.Event;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockChangeEvent extends Event {
    public final World world;
    public final BlockPos pos;
    public final IBlockState state;
    public BlockChangeEvent(World world, BlockPos pos, IBlockState state) {
        this.world = world;
        this.pos = pos;
        this.state = state;
    }
}
