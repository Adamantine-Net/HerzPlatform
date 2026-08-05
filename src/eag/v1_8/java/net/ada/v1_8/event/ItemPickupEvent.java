package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class ItemPickupEvent extends Event {

    public final EntityPlayer player;
    public final EntityItem item;

    public ItemPickupEvent(EntityPlayer player, EntityItem item) {
        this.player = player;
        this.item = item;
    }
}
