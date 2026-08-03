package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.GuiCloseEvent;
import net.minecraft.src.GuiScreen;
@Mixin(GuiScreen.class)
public class GuiCloseMixin {
    @Inject(method = "onGuiClosed", at = At.HEAD)
    private void herz$onGuiClosed() {
        EventBus.INSTANCE.post(new GuiCloseEvent((GuiScreen) (Object) this));
    }
}
