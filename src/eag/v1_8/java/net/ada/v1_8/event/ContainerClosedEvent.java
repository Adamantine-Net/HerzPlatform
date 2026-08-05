package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
public class ContainerClosedEvent extends Event {
    public final Container container;
    public final EntityPlayer player;
    public ContainerClosedEvent(Container container, EntityPlayer player) {
        this.container = container;
        this.player = player;
    }
}
