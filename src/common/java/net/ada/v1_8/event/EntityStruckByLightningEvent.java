package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
public class EntityStruckByLightningEvent extends Event {
    public final Entity entity;
    public final EntityLightningBolt bolt;
    public EntityStruckByLightningEvent(Entity entity, EntityLightningBolt bolt) {
        this.entity = entity;
        this.bolt = bolt;
    }
}
