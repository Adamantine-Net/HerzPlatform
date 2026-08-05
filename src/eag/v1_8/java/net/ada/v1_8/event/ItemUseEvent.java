package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUseEvent extends Event {

    public final ItemStack stack;
    public final World world;
    public final EntityPlayer player;

    public ItemUseEvent(ItemStack stack, World world, EntityPlayer player) {
        this.stack = stack;
        this.world = world;
        this.player = player;
    }
}
