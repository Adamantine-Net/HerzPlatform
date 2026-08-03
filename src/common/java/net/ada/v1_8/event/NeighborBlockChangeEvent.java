package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
public class NeighborBlockChangeEvent extends Event {
    public final World world;
    public final BlockPos pos;
    public final IBlockState state;
    public final Block neighborBlock;
    public NeighborBlockChangeEvent(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.neighborBlock = neighborBlock;
    }
}
