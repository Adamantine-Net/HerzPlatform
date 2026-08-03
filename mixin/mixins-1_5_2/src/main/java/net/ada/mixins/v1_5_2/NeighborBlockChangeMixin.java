package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.NeighborBlockChangeEvent;
import net.minecraft.src.Block;
import net.minecraft.src.World;
@Mixin(Block.class)
public class NeighborBlockChangeMixin {
    @Inject(method = "onNeighborBlockChange", at = At.HEAD)
    private void herz$onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockId) {
        EventBus.INSTANCE.post(new NeighborBlockChangeEvent(world, x, y, z));
    }
}
