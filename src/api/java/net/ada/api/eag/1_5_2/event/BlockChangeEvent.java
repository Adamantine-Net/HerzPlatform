package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.World;
public class BlockChangeEvent extends Event {
    public final World world;
    public final int x;
    public final int y;
    public final int z;
    public BlockChangeEvent(World world, int x, int y, int z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
