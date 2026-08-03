package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
public class PlayerDropItemEvent extends Event {
    public final EntityPlayer player;
    public final ItemStack stack;
    public PlayerDropItemEvent(EntityPlayer player, ItemStack stack) {
        this.player = player;
        this.stack = stack;
    }
}
