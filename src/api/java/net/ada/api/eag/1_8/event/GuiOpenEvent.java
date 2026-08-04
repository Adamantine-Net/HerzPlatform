package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.client.gui.GuiScreen;

public class GuiOpenEvent extends Event {

    public final GuiScreen screen;

    public GuiOpenEvent(GuiScreen screen) {
        this.screen = screen;
    }
}
