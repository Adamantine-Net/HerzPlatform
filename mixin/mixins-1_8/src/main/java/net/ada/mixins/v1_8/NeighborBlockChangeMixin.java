package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.NeighborBlockChangeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
@Mixin(Block.class)
public class NeighborBlockChangeMixin {
    @Inject(method = "onNeighborBlockChange", at = At.HEAD)
    private void herz$onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
        EventBus.INSTANCE.post(new NeighborBlockChangeEvent(world, pos, state, neighborBlock));
    }
}
