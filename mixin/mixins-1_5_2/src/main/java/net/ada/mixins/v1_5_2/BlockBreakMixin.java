package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.capability.BlockCapabilityProvider;
import net.ada.v1_5_2.event.BlockBreakEvent;
import net.minecraft.src.World;
@Mixin(World.class)
public class BlockBreakMixin {
    @Inject(method = "destroyBlock", at = At.TAIL)
    private void herz$destroyBlock(int x, int y, int z, boolean dropBlock) {
        EventBus.INSTANCE.post(new BlockBreakEvent(x, y, z));
        BlockCapabilityProvider.clear((World) (Object) this, x, y, z);
    }
}
