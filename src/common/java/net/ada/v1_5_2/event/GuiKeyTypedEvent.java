package net.ada.v1_5_2.event;

import net.ada.api.event.Event;

import net.minecraft.src.GuiScreen;

public class GuiKeyTypedEvent extends Event {

    public final GuiScreen screen;
    public final char typedChar;
    public final int keyCode;

    public GuiKeyTypedEvent(GuiScreen screen, char typedChar, int keyCode) {
        this.screen = screen;
        this.typedChar = typedChar;
        this.keyCode = keyCode;
    }

    @Override
    public boolean isCancellable() {
        return true;
    }
}
