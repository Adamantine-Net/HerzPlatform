package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
public class EntitySetOnFireEvent extends Event {
    public final Entity entity;
    public final int seconds;
    public EntitySetOnFireEvent(Entity entity, int seconds) {
        this.entity = entity;
        this.seconds = seconds;
    }
}
