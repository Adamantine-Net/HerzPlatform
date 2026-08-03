package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
public class AttackEntityEvent extends Event {
    public final EntityPlayer player;
    public final Entity target;
    public AttackEntityEvent(EntityPlayer player, Entity target) {
        this.player = player;
        this.target = target;
    }
}
