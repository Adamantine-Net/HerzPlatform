package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
public class FallDamageEvent extends Event {
    public final Entity entity;
    public final float distance;
    public FallDamageEvent(Entity entity, float distance) {
        this.entity = entity;
        this.distance = distance;
    }
}
