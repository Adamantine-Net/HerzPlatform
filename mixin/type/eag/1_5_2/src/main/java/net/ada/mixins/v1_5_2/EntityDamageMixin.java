package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntityDamageEvent;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class EntityDamageMixin {
    @Inject(method = "attackEntityFrom", at = At.HEAD)
    private void herz$attackEntityFrom(DamageSource damagesource, int amount) {
        EventBus.INSTANCE.post(new EntityDamageEvent((Entity) (Object) this, damagesource, amount));
    }
}
