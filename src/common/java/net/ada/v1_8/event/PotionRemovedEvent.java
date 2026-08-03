package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.EntityLivingBase;
public class PotionRemovedEvent extends Event {
    public final EntityLivingBase entity;
    public final int potionId;
    public PotionRemovedEvent(EntityLivingBase entity, int potionId) {
        this.entity = entity;
        this.potionId = potionId;
    }
}
