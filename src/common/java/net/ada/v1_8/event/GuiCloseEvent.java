package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.client.gui.GuiScreen;

public class GuiCloseEvent extends Event {

    public final GuiScreen screen;

    public GuiCloseEvent(GuiScreen screen) {
        this.screen = screen;
    }
}
