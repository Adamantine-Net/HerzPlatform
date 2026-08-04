package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PlayerDropItemEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
@Mixin(EntityPlayer.class)
public class PlayerDropItemMixin {
    @Inject(method = "dropItem", at = At.HEAD)
    private void herz$dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
        EventBus.INSTANCE.post(new PlayerDropItemEvent((EntityPlayer) (Object) this, droppedItem));
    }
}
