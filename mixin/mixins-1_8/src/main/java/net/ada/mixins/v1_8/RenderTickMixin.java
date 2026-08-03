package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.RenderTickEvent;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class RenderTickMixin {

    @Inject(method = "runGameLoop", at = At.HEAD)
    private void herz$onRenderTick() {
        EventBus.INSTANCE.post(new RenderTickEvent());
    }
}
