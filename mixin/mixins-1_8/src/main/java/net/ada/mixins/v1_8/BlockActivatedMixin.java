package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.BlockActivatedEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
@Mixin(Block.class)
public class BlockActivatedMixin {
    @Inject(method = "onBlockActivated", at = At.HEAD)
    private void herz$onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
                                        EnumFacing facing, float hitX, float hitY, float hitZ) {
        EventBus.INSTANCE.post(new BlockActivatedEvent(world, pos, state, player));
    }
}
