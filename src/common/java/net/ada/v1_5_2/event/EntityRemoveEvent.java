package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
public class EntityRemoveEvent extends Event {
    public final Entity entity;
    public EntityRemoveEvent(Entity entity) {
        this.entity = entity;
    }
}
