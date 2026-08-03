package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityUpdateEvent;
import net.minecraft.entity.Entity;
@Mixin(Entity.class)
public class EntityUpdateMixin {
    @Inject(method = "onUpdate", at = At.HEAD)
    private void herz$onUpdate() {
        if (EventBus.INSTANCE.hasListeners(EntityUpdateEvent.class)) {
            EventBus.INSTANCE.post(new EntityUpdateEvent((Entity) (Object) this));
        }
    }
}
