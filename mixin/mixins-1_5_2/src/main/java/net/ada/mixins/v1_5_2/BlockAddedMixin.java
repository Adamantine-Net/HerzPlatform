package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.capability.BlockCapabilityRegistry;
import net.ada.v1_5_2.event.BlockAddedEvent;
import net.minecraft.src.Block;
import net.minecraft.src.World;
@Mixin(Block.class)
public class BlockAddedMixin {
    @Inject(method = "onBlockAdded", at = At.HEAD)
    private void herz$onBlockAdded(World world, int x, int y, int z) {
        BlockCapabilityRegistry.attachAll(world, x, y, z);
        EventBus.INSTANCE.post(new BlockAddedEvent(world, x, y, z));
    }
}
