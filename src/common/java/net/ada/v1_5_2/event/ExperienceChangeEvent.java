package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
public class ExperienceChangeEvent extends Event {
    public final EntityPlayer player;
    public final int amount;
    public ExperienceChangeEvent(EntityPlayer player, int amount) {
        this.player = player;
        this.amount = amount;
    }
}
