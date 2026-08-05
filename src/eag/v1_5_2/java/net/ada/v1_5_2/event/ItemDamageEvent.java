package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;
public class ItemDamageEvent extends Event {
    public final ItemStack stack;
    public final int amount;
    public final EntityLiving entity;
    public ItemDamageEvent(ItemStack stack, int amount, EntityLiving entity) {
        this.stack = stack;
        this.amount = amount;
        this.entity = entity;
    }
}
