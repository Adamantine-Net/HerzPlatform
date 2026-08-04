package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
public class PlayerDropItemEvent extends Event {
    public final EntityPlayer player;
    public final ItemStack stack;
    public PlayerDropItemEvent(EntityPlayer player, ItemStack stack) {
        this.player = player;
        this.stack = stack;
    }
}
