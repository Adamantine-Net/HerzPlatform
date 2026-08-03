package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerInteractEvent extends Event {

    public final EntityPlayer player;
    public final Entity target;

    public PlayerInteractEvent(EntityPlayer player, Entity target) {
        this.player = player;
        this.target = target;
    }
}
