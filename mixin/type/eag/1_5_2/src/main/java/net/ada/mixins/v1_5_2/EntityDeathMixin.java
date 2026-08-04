package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntityDeathEvent;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
@Mixin(EntityLiving.class)
public class EntityDeathMixin {
    @Inject(method = "onDeath", at = At.HEAD)
    private void herz$onDeath(DamageSource damagesource) {
        EventBus.INSTANCE.post(new EntityDeathEvent((EntityLiving) (Object) this, damagesource));
    }
}
