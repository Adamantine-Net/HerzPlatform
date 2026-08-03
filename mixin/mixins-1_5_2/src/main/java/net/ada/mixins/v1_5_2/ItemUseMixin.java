package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ItemUseEvent;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
@Mixin(Item.class)
public class ItemUseMixin {
    @Inject(method = "onItemRightClick", at = At.HEAD)
    private void herz$onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        EventBus.INSTANCE.post(new ItemUseEvent(itemstack, world, player));
    }
}
