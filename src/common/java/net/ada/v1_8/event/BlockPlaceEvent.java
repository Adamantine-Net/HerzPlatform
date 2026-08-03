package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;

public class BlockPlaceEvent extends Event {

    public final EntityPlayer player;
    public final ItemStack stack;
    public final BlockPos pos;

    public BlockPlaceEvent(EntityPlayer player, ItemStack stack, BlockPos pos) {
        this.player = player;
        this.stack = stack;
        this.pos = pos;
    }
}
