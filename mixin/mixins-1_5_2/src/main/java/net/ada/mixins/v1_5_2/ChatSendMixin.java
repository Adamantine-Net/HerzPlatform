package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ChatSendEvent;
import net.minecraft.src.EntityClientPlayerMP;
@Mixin(EntityClientPlayerMP.class)
public class ChatSendMixin {
    @Inject(method = "sendChatMessage", at = At.HEAD)
    private void herz$sendChatMessage(String message) {
        EventBus.INSTANCE.post(new ChatSendEvent(message));
    }
}
