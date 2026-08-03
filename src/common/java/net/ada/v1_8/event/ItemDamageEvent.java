package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
public class ItemDamageEvent extends Event {
    public final ItemStack stack;
    public final int amount;
    public final EntityLivingBase entity;
    public ItemDamageEvent(ItemStack stack, int amount, EntityLivingBase entity) {
        this.stack = stack;
        this.amount = amount;
        this.entity = entity;
    }
}
