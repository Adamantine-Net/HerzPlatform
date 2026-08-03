package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
public class PlayerSneakEvent extends Event {
    public final Entity entity;
    public final boolean sneaking;
    public PlayerSneakEvent(Entity entity, boolean sneaking) {
        this.entity = entity;
        this.sneaking = sneaking;
    }
}
