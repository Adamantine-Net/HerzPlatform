package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.Packet3Chat;
public class ChatReceiveEvent extends Event {
    public final Packet3Chat packet;
    public ChatReceiveEvent(Packet3Chat packet) {
        this.packet = packet;
    }
}
