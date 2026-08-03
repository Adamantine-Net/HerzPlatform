package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityHealthSetEvent;
import net.minecraft.entity.EntityLivingBase;
@Mixin(EntityLivingBase.class)
public class EntityHealthSetMixin {
    @Inject(method = "setHealth", at = At.HEAD)
    private void herz$setHealth(float health) {
        EventBus.INSTANCE.post(new EntityHealthSetEvent((EntityLivingBase) (Object) this, health));
    }
}
