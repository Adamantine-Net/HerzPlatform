package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
public class ChatSendEvent extends Event {
    public final String message;
    public ChatSendEvent(String message) {
        this.message = message;
    }
}
