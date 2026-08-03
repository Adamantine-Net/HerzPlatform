package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
public class EntitySpawnEvent extends Event {
    public final Entity entity;
    public EntitySpawnEvent(Entity entity) {
        this.entity = entity;
    }
}
