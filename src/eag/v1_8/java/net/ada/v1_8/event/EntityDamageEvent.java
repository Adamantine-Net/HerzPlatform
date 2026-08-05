package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class EntityDamageEvent extends Event {

    public final EntityLivingBase entity;
    public final DamageSource source;
    public final float amount;

    public EntityDamageEvent(EntityLivingBase entity, DamageSource source, float amount) {
        this.entity = entity;
        this.source = source;
        this.amount = amount;
    }
}
