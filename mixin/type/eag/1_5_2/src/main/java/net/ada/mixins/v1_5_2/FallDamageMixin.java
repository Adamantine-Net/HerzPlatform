package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.FallDamageEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class FallDamageMixin {
    @Inject(method = "fall", at = At.HEAD)
    private void herz$fall(float distance) {
        EventBus.INSTANCE.post(new FallDamageEvent((Entity) (Object) this, distance));
    }
}
