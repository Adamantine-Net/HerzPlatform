package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityStruckByLightningEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
@Mixin(Entity.class)
public class EntityStruckByLightningMixin {
    @Inject(method = "onStruckByLightning", at = At.HEAD)
    private void herz$onStruckByLightning(EntityLightningBolt bolt) {
        EventBus.INSTANCE.post(new EntityStruckByLightningEvent((Entity) (Object) this, bolt));
    }
}
