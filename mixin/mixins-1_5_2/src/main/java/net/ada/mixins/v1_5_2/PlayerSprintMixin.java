package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.PlayerSprintEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class PlayerSprintMixin {
    @Inject(method = "setSprinting", at = At.HEAD)
    private void herz$setSprinting(boolean sprinting) {
        EventBus.INSTANCE.post(new PlayerSprintEvent((Entity) (Object) this, sprinting));
    }
}
