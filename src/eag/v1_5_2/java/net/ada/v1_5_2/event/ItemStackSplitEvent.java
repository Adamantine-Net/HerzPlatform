package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.ItemStack;
public class ItemStackSplitEvent extends Event {
    public final ItemStack stack;
    public final int amount;
    public ItemStackSplitEvent(ItemStack stack, int amount) {
        this.stack = stack;
        this.amount = amount;
    }
}
