package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ChatReceiveEvent;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S02PacketChat;
@Mixin(NetHandlerPlayClient.class)
public class ChatReceiveMixin {
    @Inject(method = "handleChat", at = At.HEAD)
    private void herz$handleChat(S02PacketChat packetIn) {
        EventBus.INSTANCE.post(new ChatReceiveEvent(packetIn));
    }
}
