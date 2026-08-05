package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
public class ContainerSlotClickEvent extends Event {
    public final Container container;
    public final int slotId;
    public final EntityPlayer player;
    public ContainerSlotClickEvent(Container container, int slotId, EntityPlayer player) {
        this.container = container;
        this.slotId = slotId;
        this.player = player;
    }
}
