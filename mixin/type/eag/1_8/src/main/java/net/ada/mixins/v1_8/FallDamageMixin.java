package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.FallDamageEvent;

import net.minecraft.entity.EntityLivingBase;

@Mixin(EntityLivingBase.class)
public class FallDamageMixin {

    @Inject(method = "fall", at = At.HEAD)
    private void herz$onFall(float distance, float damageMultiplier) {
        EventBus.INSTANCE.post(new FallDamageEvent((EntityLivingBase) (Object) this, distance, damageMultiplier));
    }
}
