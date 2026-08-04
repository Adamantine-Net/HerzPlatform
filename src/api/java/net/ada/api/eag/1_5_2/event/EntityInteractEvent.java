package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
public class EntityInteractEvent extends Event {
    public final Entity entity;
    public final EntityPlayer player;
    public EntityInteractEvent(Entity entity, EntityPlayer player) {
        this.entity = entity;
        this.player = player;
    }
}
