package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ItemDamageEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
@Mixin(ItemStack.class)
public class ItemDamageMixin {
    @Inject(method = "damageItem", at = At.HEAD)
    private void herz$damageItem(int amount, EntityLivingBase entityIn) {
        EventBus.INSTANCE.post(new ItemDamageEvent((ItemStack) (Object) this, amount, entityIn));
    }
}
