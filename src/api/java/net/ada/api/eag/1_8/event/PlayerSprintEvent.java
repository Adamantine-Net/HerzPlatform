package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
public class PlayerSprintEvent extends Event {
    public final Entity entity;
    public final boolean sprinting;
    public PlayerSprintEvent(Entity entity, boolean sprinting) {
        this.entity = entity;
        this.sprinting = sprinting;
    }
}
