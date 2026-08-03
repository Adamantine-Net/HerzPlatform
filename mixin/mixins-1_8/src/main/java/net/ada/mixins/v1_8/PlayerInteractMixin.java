package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PlayerInteractEvent;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@Mixin(PlayerControllerMP.class)
public class PlayerInteractMixin {

    @Inject(method = "interactWithEntitySendPacket", at = At.TAIL)
    private void herz$onInteract(EntityPlayer playerIn, Entity targetEntity) {
        EventBus.INSTANCE.post(new PlayerInteractEvent(playerIn, targetEntity));
    }
}
