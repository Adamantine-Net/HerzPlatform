package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
public class EntityExtinguishEvent extends Event {
    public final Entity entity;
    public EntityExtinguishEvent(Entity entity) {
        this.entity = entity;
    }
}
