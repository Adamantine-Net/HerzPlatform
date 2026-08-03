package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
public class BlockBreakEvent extends Event {
    public final int x;
    public final int y;
    public final int z;
    public BlockBreakEvent(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
