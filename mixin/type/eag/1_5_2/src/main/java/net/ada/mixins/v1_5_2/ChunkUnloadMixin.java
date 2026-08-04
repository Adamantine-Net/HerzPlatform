package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ChunkUnloadEvent;
import net.minecraft.src.Chunk;
@Mixin(Chunk.class)
public class ChunkUnloadMixin {
    @Inject(method = "onChunkUnload", at = At.HEAD)
    private void herz$onChunkUnload() {
        EventBus.INSTANCE.post(new ChunkUnloadEvent((Chunk) (Object) this));
    }
}
