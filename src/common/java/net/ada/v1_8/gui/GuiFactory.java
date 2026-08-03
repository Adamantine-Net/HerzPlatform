package net.ada.v1_8.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.IInteractionObject;

public interface GuiFactory {
    GuiScreen create(IInteractionObject owner);
}
