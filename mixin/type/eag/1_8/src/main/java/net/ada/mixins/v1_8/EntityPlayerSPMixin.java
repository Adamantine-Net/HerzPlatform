package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_8.gui.GuiRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.IInteractionObject;

@Mixin(EntityPlayerSP.class)
public class EntityPlayerSPMixin {

    @Shadow
    protected Minecraft mc;

    @Inject(method = "displayGui", at = At.HEAD, cancellable = true)
    private void herz$displayGui(IInteractionObject guiOwner, CallbackInfo ci) {
        GuiScreen screen = GuiRegistry.create(guiOwner.getGuiID(), guiOwner);
        if (screen != null) {
            mc.displayGuiScreen(screen);
            ci.cancel();
        }
    }
}
