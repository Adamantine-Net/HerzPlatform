package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
public class EntityMountEvent extends Event {
    public final Entity entity;
    public final Entity mounted;
    public EntityMountEvent(Entity entity, Entity mounted) {
        this.entity = entity;
        this.mounted = mounted;
    }
}
