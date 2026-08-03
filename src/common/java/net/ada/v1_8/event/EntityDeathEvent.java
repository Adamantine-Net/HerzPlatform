package net.ada.v1_8.event;

import net.ada.api.event.Event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class EntityDeathEvent extends Event {

    public final EntityLivingBase entity;
    public final DamageSource source;

    public EntityDeathEvent(EntityLivingBase entity, DamageSource source) {
        this.entity = entity;
        this.source = source;
    }
}
