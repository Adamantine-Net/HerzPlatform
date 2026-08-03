package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.PlayerSneakEvent;
import net.minecraft.src.Entity;
@Mixin(Entity.class)
public class PlayerSneakMixin {
    @Inject(method = "setSneaking", at = At.HEAD)
    private void herz$setSneaking(boolean sneaking) {
        EventBus.INSTANCE.post(new PlayerSneakEvent((Entity) (Object) this, sneaking));
    }
}
