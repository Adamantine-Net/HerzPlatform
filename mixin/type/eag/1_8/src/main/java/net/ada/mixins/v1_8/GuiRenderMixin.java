package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.GuiRenderEvent;

import net.minecraft.client.gui.GuiScreen;

@Mixin(GuiScreen.class)
public class GuiRenderMixin {

    @Inject(method = "drawScreen", at = At.TAIL)
    private void herz$drawScreen(int mouseX, int mouseY, float partialTicks) {
        EventBus.INSTANCE.post(new GuiRenderEvent((GuiScreen) (Object) this, mouseX, mouseY, partialTicks));
    }
}
