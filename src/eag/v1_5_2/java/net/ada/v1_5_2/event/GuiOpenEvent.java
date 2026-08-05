package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.GuiScreen;
public class GuiOpenEvent extends Event {
    public final GuiScreen screen;
    public GuiOpenEvent(GuiScreen screen) {
        this.screen = screen;
    }
}
