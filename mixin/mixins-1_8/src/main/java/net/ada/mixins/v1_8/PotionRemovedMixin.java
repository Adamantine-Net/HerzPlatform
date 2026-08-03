package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PotionRemovedEvent;
import net.minecraft.entity.EntityLivingBase;
@Mixin(EntityLivingBase.class)
public class PotionRemovedMixin {
    @Inject(method = "removePotionEffect", at = At.HEAD)
    private void herz$removePotionEffect(int potionId) {
        EventBus.INSTANCE.post(new PotionRemovedEvent((EntityLivingBase) (Object) this, potionId));
    }
}
