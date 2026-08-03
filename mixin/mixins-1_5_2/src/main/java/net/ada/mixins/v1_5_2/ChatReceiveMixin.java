package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ChatReceiveEvent;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet3Chat;
@Mixin(NetClientHandler.class)
public class ChatReceiveMixin {
    @Inject(method = "handleChat", at = At.HEAD)
    private void herz$handleChat(Packet3Chat packetIn) {
        EventBus.INSTANCE.post(new ChatReceiveEvent(packetIn));
    }
}
