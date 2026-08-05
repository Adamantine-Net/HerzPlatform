package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
public class ContainerClosedEvent extends Event {
    public final Container container;
    public final EntityPlayer player;
    public ContainerClosedEvent(Container container, EntityPlayer player) {
        this.container = container;
        this.player = player;
    }
}
