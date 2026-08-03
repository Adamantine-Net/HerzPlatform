package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ItemPickupEvent;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

@Mixin(EntityItem.class)
public class ItemPickupMixin {

    @Inject(method = "onCollideWithPlayer", at = At.HEAD)
    private void herz$onCollideWithPlayer(EntityPlayer entityplayer) {
        EventBus.INSTANCE.post(new ItemPickupEvent(entityplayer, (EntityItem) (Object) this));
    }
}
