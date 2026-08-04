package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.client.gui.GuiScreen;

public class GuiRenderEvent extends Event {

    public final GuiScreen screen;
    public final int mouseX;
    public final int mouseY;
    public final float partialTicks;

    public GuiRenderEvent(GuiScreen screen, int mouseX, int mouseY, float partialTicks) {
        this.screen = screen;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.partialTicks = partialTicks;
    }
}
