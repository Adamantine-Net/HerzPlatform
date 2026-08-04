package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.WorldTimeChangeEvent;
import net.minecraft.world.World;
@Mixin(World.class)
public class WorldTimeChangeMixin {
    @Inject(method = "setWorldTime", at = At.HEAD)
    private void herz$setWorldTime(long time) {
        EventBus.INSTANCE.post(new WorldTimeChangeEvent((World) (Object) this, time));
    }
}
