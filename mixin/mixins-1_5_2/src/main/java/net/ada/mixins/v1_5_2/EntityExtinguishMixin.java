package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntityExtinguishEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class EntityExtinguishMixin {
    @Inject(method = "extinguish", at = At.HEAD)
    private void herz$extinguish() {
        EventBus.INSTANCE.post(new EntityExtinguishEvent((Entity) (Object) this));
    }
}
