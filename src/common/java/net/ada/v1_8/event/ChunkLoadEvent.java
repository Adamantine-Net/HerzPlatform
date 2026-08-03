package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.world.chunk.Chunk;

public class ChunkLoadEvent extends Event {

    public final Chunk chunk;

    public ChunkLoadEvent(Chunk chunk) {
        this.chunk = chunk;
    }
}
