package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.AttackEntityEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@Mixin(EntityPlayer.class)
public class AttackEntityMixin {

    @Inject(method = "attackTargetEntityWithCurrentItem", at = At.HEAD)
    private void herz$attackTargetEntityWithCurrentItem(Entity entity) {
        EventBus.INSTANCE.post(new AttackEntityEvent((EntityPlayer) (Object) this, entity));
    }
}
