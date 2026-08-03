package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.network.play.server.S02PacketChat;
public class ChatReceiveEvent extends Event {
    public final S02PacketChat packet;
    public ChatReceiveEvent(S02PacketChat packet) {
        this.packet = packet;
    }
}
