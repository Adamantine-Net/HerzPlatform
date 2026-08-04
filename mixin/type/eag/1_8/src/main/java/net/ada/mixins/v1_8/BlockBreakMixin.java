package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.capability.BlockCapabilityProvider;
import net.ada.v1_8.event.BlockBreakEvent;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

@Mixin(World.class)
public class BlockBreakMixin {

    @Inject(method = "destroyBlock", at = At.TAIL)
    private void herz$onDestroyBlock(BlockPos pos, boolean dropBlock) {
        EventBus.INSTANCE.post(new BlockBreakEvent(pos));
        BlockCapabilityProvider.clear((World) (Object) this, pos);
    }
}
