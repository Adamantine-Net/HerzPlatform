package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.GuiOpenEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiScreen;
@Mixin(Minecraft.class)
public class GuiOpenMixin {
    @Inject(method = "displayGuiScreen", at = At.HEAD)
    private void herz$displayGuiScreen(GuiScreen guiScreenIn) {
        EventBus.INSTANCE.post(new GuiOpenEvent(guiScreenIn));
    }
}
