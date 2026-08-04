package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
public class HarvestBlockEvent extends Event {
    public final World world;
    public final EntityPlayer player;
    public final BlockPos pos;
    public final IBlockState state;
    public HarvestBlockEvent(World world, EntityPlayer player, BlockPos pos, IBlockState state) {
        this.world = world;
        this.player = player;
        this.pos = pos;
        this.state = state;
    }
}
