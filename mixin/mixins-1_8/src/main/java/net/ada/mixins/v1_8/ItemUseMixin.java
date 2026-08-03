package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ItemUseEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(Item.class)
public class ItemUseMixin {

    @Inject(method = "onItemRightClick", at = At.HEAD)
    private void herz$onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        EventBus.INSTANCE.post(new ItemUseEvent(itemstack, world, entityplayer));
    }
}
