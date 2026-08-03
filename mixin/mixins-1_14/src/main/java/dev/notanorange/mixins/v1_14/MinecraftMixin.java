package dev.notanorange.mixins.v1_14;

import dev.notanorange.mixin.annotation.At;
import dev.notanorange.mixin.annotation.Inject;
import dev.notanorange.mixin.annotation.Mixin;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "runTick", at = At.HEAD)
    private void herz$onRunTick() {
    }
}
