package net.ada.mixins.v1_5_2;
import net.ada.api.capability.CapabilityProvider;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntityRemoveEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class EntityRemoveMixin {
    @Inject(method = "setDead", at = At.HEAD)
    private void herz$setDead() {
        EventBus.INSTANCE.post(new EntityRemoveEvent((Entity) (Object) this));
        CapabilityProvider.clear((Entity) (Object) this);
    }
}
