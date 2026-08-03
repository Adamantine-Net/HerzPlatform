package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ChunkUnloadEvent;

import net.minecraft.world.chunk.Chunk;

@Mixin(Chunk.class)
public class ChunkUnloadMixin {

    @Inject(method = "onChunkUnload", at = At.HEAD)
    private void herz$onChunkUnload() {
        EventBus.INSTANCE.post(new ChunkUnloadEvent((Chunk) (Object) this));
    }
}
