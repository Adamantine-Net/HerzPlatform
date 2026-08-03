package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Chunk;
public class ChunkLoadEvent extends Event {
    public final Chunk chunk;
    public ChunkLoadEvent(Chunk chunk) {
        this.chunk = chunk;
    }
}
