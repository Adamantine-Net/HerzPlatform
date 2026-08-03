package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.GuiScreen;
public class GuiCloseEvent extends Event {
    public final GuiScreen screen;
    public GuiCloseEvent(GuiScreen screen) {
        this.screen = screen;
    }
}
