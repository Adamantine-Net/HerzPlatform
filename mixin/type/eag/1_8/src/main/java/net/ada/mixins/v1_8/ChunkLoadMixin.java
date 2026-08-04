package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ChunkLoadEvent;

import net.minecraft.world.chunk.Chunk;

@Mixin(Chunk.class)
public class ChunkLoadMixin {

    @Inject(method = "onChunkLoad", at = At.HEAD)
    private void herz$onChunkLoad() {
        EventBus.INSTANCE.post(new ChunkLoadEvent((Chunk) (Object) this));
    }
}
