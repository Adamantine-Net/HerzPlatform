package net.ada.mixins.v1_8;

import net.ada.api.event.ClientTickEvent;
import net.ada.api.event.EventBus;
import net.ada.api.mod.ModLoader;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "runTick", at = At.HEAD)
    private void herz$onRunTick() {
        ModLoader.initAll(); // modloader guards it internally <3
        EventBus.INSTANCE.post(new ClientTickEvent());
    }
}
