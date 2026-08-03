package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
public class ContainerSlotClickEvent extends Event {
    public final Container container;
    public final int slotId;
    public final int clickedButton;
    public final EntityPlayer player;
    public ContainerSlotClickEvent(Container container, int slotId, int clickedButton, EntityPlayer player) {
        this.container = container;
        this.slotId = slotId;
        this.clickedButton = clickedButton;
        this.player = player;
    }
}
