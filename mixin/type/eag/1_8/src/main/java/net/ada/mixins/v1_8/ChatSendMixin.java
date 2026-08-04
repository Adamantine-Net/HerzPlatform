package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ChatSendEvent;
import net.minecraft.client.entity.EntityPlayerSP;
@Mixin(EntityPlayerSP.class)
public class ChatSendMixin {
    @Inject(method = "sendChatMessage", at = At.HEAD)
    private void herz$sendChatMessage(String message) {
        EventBus.INSTANCE.post(new ChatSendEvent(message));
    }
}
