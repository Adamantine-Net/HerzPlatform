package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.EntityLivingBase;
public class EntityHealthSetEvent extends Event {
    public final EntityLivingBase entity;
    public final float health;
    public EntityHealthSetEvent(EntityLivingBase entity, float health) {
        this.entity = entity;
        this.health = health;
    }
}
