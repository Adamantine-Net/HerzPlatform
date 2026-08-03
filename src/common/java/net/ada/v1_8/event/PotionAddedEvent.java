package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
public class PotionAddedEvent extends Event {
    public final EntityLivingBase entity;
    public final PotionEffect effect;
    public PotionAddedEvent(EntityLivingBase entity, PotionEffect effect) {
        this.entity = entity;
        this.effect = effect;
    }
}
