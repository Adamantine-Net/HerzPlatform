package net.ada.v1_8.event;
import net.ada.api.event.Event;
import net.minecraft.world.World;
public class WorldTimeChangeEvent extends Event {
    public final World world;
    public final long time;
    public WorldTimeChangeEvent(World world, long time) {
        this.world = world;
        this.time = time;
    }
}
