package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.GuiOpenEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

@Mixin(Minecraft.class)
public class GuiOpenMixin {

    @Inject(method = "displayGuiScreen", at = At.HEAD)
    private void herz$displayGuiScreen(GuiScreen guiScreenIn) {
        EventBus.INSTANCE.post(new GuiOpenEvent(guiScreenIn));
    }
}
