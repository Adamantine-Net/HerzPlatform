package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
public class BlockActivatedEvent extends Event {
    public final World world;
    public final BlockPos pos;
    public final IBlockState state;
    public final EntityPlayer player;
    public BlockActivatedEvent(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.player = player;
    }
}
