package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.EntityInteractEvent;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
@Mixin(Entity.class)
public class EntityInteractMixin {
    @Inject(method = "interact", at = At.HEAD)
    private void herz$interact(EntityPlayer player) {
        EventBus.INSTANCE.post(new EntityInteractEvent((Entity) (Object) this, player));
    }
}
