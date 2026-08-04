package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.GuiCloseEvent;

import net.minecraft.client.gui.GuiScreen;

@Mixin(GuiScreen.class)
public class GuiCloseMixin {

    @Inject(method = "onGuiClosed", at = At.HEAD)
    private void herz$onGuiClosed() {
        EventBus.INSTANCE.post(new GuiCloseEvent((GuiScreen) (Object) this));
    }
}
