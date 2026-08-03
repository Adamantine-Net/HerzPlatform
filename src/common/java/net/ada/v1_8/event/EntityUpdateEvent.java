package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
public class EntityUpdateEvent extends Event {
    public final Entity entity;
    public EntityUpdateEvent(Entity entity) {
        this.entity = entity;
    }
}
