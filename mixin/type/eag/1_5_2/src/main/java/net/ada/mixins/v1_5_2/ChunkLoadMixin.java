package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ChunkLoadEvent;
import net.minecraft.src.Chunk;
@Mixin(Chunk.class)
public class ChunkLoadMixin {
    @Inject(method = "onChunkLoad", at = At.HEAD)
    private void herz$onChunkLoad() {
        EventBus.INSTANCE.post(new ChunkLoadEvent((Chunk) (Object) this));
    }
}
