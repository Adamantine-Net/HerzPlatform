package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
public class XpOrbPickupEvent extends Event {
    public final EntityPlayer player;
    public final EntityXPOrb orb;
    public XpOrbPickupEvent(EntityPlayer player, EntityXPOrb orb) {
        this.player = player;
        this.orb = orb;
    }
}
