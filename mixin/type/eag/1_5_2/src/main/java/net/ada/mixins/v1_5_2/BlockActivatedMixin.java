package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.BlockActivatedEvent;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
@Mixin(Block.class)
public class BlockActivatedMixin {
    @Inject(method = "onBlockActivated", at = At.HEAD)
    private void herz$onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                        int side, float hitX, float hitY, float hitZ) {
        EventBus.INSTANCE.post(new BlockActivatedEvent(world, x, y, z, player));
    }
}
