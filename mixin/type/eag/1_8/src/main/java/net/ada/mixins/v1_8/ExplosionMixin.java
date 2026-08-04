package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ExplosionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
@Mixin(World.class)
public class ExplosionMixin {
    @Inject(method = "newExplosion", at = At.HEAD)
    private void herz$newExplosion(Entity entityIn, double x, double y, double z, float strength,
                                    boolean isFlaming, boolean isSmoking) {
        EventBus.INSTANCE.post(new ExplosionEvent((World) (Object) this, entityIn, x, y, z, strength));
    }
}
