package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.AttackEntityEvent;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
@Mixin(EntityPlayer.class)
public class AttackEntityMixin {
    @Inject(method = "attackTargetEntityWithCurrentItem", at = At.HEAD)
    private void herz$attackTargetEntityWithCurrentItem(Entity entity) {
        EventBus.INSTANCE.post(new AttackEntityEvent((EntityPlayer) (Object) this, entity));
    }
}
