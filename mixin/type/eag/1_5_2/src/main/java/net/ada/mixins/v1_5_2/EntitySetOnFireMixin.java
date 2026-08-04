package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntitySetOnFireEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class EntitySetOnFireMixin {
    @Inject(method = "setFire", at = At.HEAD)
    private void herz$setFire(int seconds) {
        EventBus.INSTANCE.post(new EntitySetOnFireEvent((Entity) (Object) this, seconds));
    }
}
