package net.ada.mixins.v1_5_2;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_5_2.event.GuiKeyTypedEvent;

import net.minecraft.src.GuiScreen;

@Mixin(GuiScreen.class)
public class GuiKeyTypedMixin {

    @Inject(method = "keyTyped", at = At.HEAD, cancellable = true)
    private void herz$keyTyped(char typedChar, int keyCode, CallbackInfo ci) {
        GuiKeyTypedEvent event = new GuiKeyTypedEvent((GuiScreen) (Object) this, typedChar, keyCode);
        EventBus.INSTANCE.post(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
}
