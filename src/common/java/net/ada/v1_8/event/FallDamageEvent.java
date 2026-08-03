package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.EntityLivingBase;

public class FallDamageEvent extends Event {

    public final EntityLivingBase entity;
    public final float distance;
    public final float damageMultiplier;

    public FallDamageEvent(EntityLivingBase entity, float distance, float damageMultiplier) {
        this.entity = entity;
        this.distance = distance;
        this.damageMultiplier = damageMultiplier;
    }
}
