package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.capability.BlockCapabilityRegistry;
import net.ada.v1_8.event.BlockAddedEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
@Mixin(Block.class)
public class BlockAddedMixin {
    @Inject(method = "onBlockAdded", at = At.HEAD)
    private void herz$onBlockAdded(World world, BlockPos pos, IBlockState state) {
        BlockCapabilityRegistry.attachAll(world, pos, state);
        EventBus.INSTANCE.post(new BlockAddedEvent(world, pos, state));
    }
}
