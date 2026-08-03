package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityInteractEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
@Mixin(Entity.class)
public class EntityInteractMixin {
    @Inject(method = "interactFirst", at = At.HEAD)
    private void herz$interactFirst(EntityPlayer playerIn) {
        EventBus.INSTANCE.post(new EntityInteractEvent((Entity) (Object) this, playerIn));
    }
}
