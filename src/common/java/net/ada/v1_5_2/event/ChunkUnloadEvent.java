package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Chunk;
public class ChunkUnloadEvent extends Event {
    public final Chunk chunk;
    public ChunkUnloadEvent(Chunk chunk) {
        this.chunk = chunk;
    }
}
