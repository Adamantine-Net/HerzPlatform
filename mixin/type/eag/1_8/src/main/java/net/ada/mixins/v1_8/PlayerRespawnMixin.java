package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PlayerRespawnEvent;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S07PacketRespawn;

@Mixin(NetHandlerPlayClient.class)
public class PlayerRespawnMixin {

    @Inject(method = "handleRespawn", at = At.HEAD)
    private void herz$handleRespawn(S07PacketRespawn packetIn) {
        EventBus.INSTANCE.post(new PlayerRespawnEvent());
    }
}
