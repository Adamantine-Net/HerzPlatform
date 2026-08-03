package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityDeathEvent;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

@Mixin(EntityLivingBase.class)
public class EntityDeathMixin {

    @Inject(method = "onDeath", at = At.HEAD)
    private void herz$onDeath(DamageSource damagesource) {
        EventBus.INSTANCE.post(new EntityDeathEvent((EntityLivingBase) (Object) this, damagesource));
    }
}
