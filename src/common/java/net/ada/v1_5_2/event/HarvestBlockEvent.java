package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
public class HarvestBlockEvent extends Event {
    public final World world;
    public final EntityPlayer player;
    public final int x;
    public final int y;
    public final int z;
    public HarvestBlockEvent(World world, EntityPlayer player, int x, int y, int z) {
        this.world = world;
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
