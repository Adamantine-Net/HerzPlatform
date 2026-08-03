package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.item.ItemStack;
public class ItemStackSplitEvent extends Event {
    public final ItemStack stack;
    public final int amount;
    public ItemStackSplitEvent(ItemStack stack, int amount) {
        this.stack = stack;
        this.amount = amount;
    }
}
