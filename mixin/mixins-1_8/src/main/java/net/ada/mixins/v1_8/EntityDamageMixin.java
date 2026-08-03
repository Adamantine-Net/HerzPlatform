package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityDamageEvent;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

@Mixin(EntityLivingBase.class)
public class EntityDamageMixin {

    @Inject(method = "attackEntityFrom", at = At.TAIL)
    private void herz$onAttackEntityFrom(DamageSource damagesource, float f) {
        EventBus.INSTANCE.post(new EntityDamageEvent((EntityLivingBase) (Object) this, damagesource, f));
    }
}
