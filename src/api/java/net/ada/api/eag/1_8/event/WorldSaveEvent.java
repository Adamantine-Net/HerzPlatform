package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.world.storage.WorldInfo;
public class WorldSaveEvent extends Event {
    public final WorldInfo info;
    public WorldSaveEvent(WorldInfo info) {
        this.info = info;
    }
}
