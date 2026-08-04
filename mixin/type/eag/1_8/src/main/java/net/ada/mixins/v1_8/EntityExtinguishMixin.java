package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityExtinguishEvent;
import net.minecraft.entity.Entity;
@Mixin(Entity.class)
public class EntityExtinguishMixin {
    @Inject(method = "extinguish", at = At.HEAD)
    private void herz$extinguish() {
        EventBus.INSTANCE.post(new EntityExtinguishEvent((Entity) (Object) this));
    }
}
