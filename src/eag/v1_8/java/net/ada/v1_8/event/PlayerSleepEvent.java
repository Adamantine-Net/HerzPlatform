package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class PlayerSleepEvent extends Event {

    public final EntityPlayer player;
    public final BlockPos pos;

    public PlayerSleepEvent(EntityPlayer player, BlockPos pos) {
        this.player = player;
        this.pos = pos;
    }
}
