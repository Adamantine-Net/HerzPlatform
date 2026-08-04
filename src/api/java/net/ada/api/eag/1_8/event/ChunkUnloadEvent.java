package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.world.chunk.Chunk;

public class ChunkUnloadEvent extends Event {

    public final Chunk chunk;

    public ChunkUnloadEvent(Chunk chunk) {
        this.chunk = chunk;
    }
}
