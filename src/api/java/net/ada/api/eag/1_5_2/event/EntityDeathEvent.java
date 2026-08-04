package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
public class EntityDeathEvent extends Event {
    public final EntityLiving entity;
    public final DamageSource source;
    public EntityDeathEvent(EntityLiving entity, DamageSource source) {
        this.entity = entity;
        this.source = source;
    }
}
