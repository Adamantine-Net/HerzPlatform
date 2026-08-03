package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.util.BlockPos;

public class BlockBreakEvent extends Event {

    public final BlockPos pos;

    public BlockBreakEvent(BlockPos pos) {
        this.pos = pos;
    }
}
