package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.BlockChangeEvent;
import net.minecraft.src.World;
@Mixin(World.class)
public class BlockChangeMixin {
    @Inject(method = "setBlock(IIIIII)Z", at = At.HEAD)//IIIIII is for the 6 int params wait fuck z not v
    private void herz$setBlock(int x, int y, int z, int blockId, int metadata, int flags) {
        EventBus.INSTANCE.post(new BlockChangeEvent((World) (Object) this, x, y, z));
    }
}
