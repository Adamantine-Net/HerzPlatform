package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ItemDamageEvent;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;
@Mixin(ItemStack.class)
public class ItemDamageMixin {
    @Inject(method = "damageItem", at = At.HEAD)
    private void herz$damageItem(int amount, EntityLiving entityIn) {
        EventBus.INSTANCE.post(new ItemDamageEvent((ItemStack) (Object) this, amount, entityIn));
    }
}
