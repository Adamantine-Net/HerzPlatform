package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.PlayerJoinEvent;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S01PacketJoinGame;

@Mixin(NetHandlerPlayClient.class)
public class PlayerJoinMixin {

    @Inject(method = "handleJoinGame", at = At.HEAD)
    private void herz$handleJoinGame(S01PacketJoinGame packetIn) {
        EventBus.INSTANCE.post(new PlayerJoinEvent());
    }
}
