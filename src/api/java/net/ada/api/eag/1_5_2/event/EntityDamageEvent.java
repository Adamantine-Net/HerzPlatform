package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
public class EntityDamageEvent extends Event {
    public final Entity entity;
    public final DamageSource source;
    public final int amount;
    public EntityDamageEvent(Entity entity, DamageSource source, int amount) {
        this.entity = entity;
        this.source = source;
        this.amount = amount;
    }
}
