package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
public class EntityInteractEvent extends Event {
    public final Entity entity;
    public final EntityPlayer player;
    public EntityInteractEvent(Entity entity, EntityPlayer player) {
        this.entity = entity;
        this.player = player;
    }
}
