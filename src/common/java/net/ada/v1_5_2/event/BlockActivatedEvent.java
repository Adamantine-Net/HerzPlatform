package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
public class BlockActivatedEvent extends Event {
    public final World world;
    public final int x;
    public final int y;
    public final int z;
    public final EntityPlayer player;
    public BlockActivatedEvent(World world, int x, int y, int z, EntityPlayer player) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;
    }
}
