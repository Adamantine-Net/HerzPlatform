package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.BlockChangeEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

@Mixin(World.class)
public class BlockChangeMixin {

    //and after allllll that will it work

    @Inject(method = "setBlockState(Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z", at = At.HEAD)
    private void herz$setBlockState(BlockPos pos, IBlockState newState, int flags) {
        EventBus.INSTANCE.post(new BlockChangeEvent((World) (Object) this, pos, newState));
    }
}