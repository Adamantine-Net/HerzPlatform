package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.PlayerDropItemEvent;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
@Mixin(EntityPlayer.class)
public class PlayerDropItemMixin {
    @Inject(method = "dropPlayerItem", at = At.HEAD)
    private void herz$dropPlayerItem(ItemStack stack) {
        EventBus.INSTANCE.post(new PlayerDropItemEvent((EntityPlayer) (Object) this, stack));
    }
}
