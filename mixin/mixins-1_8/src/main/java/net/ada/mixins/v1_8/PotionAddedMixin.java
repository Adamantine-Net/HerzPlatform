package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PotionAddedEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
@Mixin(EntityLivingBase.class)
public class PotionAddedMixin {
    @Inject(method = "addPotionEffect", at = At.HEAD)
    private void herz$addPotionEffect(PotionEffect potioneffectIn) {
        EventBus.INSTANCE.post(new PotionAddedEvent((EntityLivingBase) (Object) this, potioneffectIn));
    }
}
