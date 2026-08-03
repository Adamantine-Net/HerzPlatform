package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
public class BlockPlaceEvent extends Event {
    public final EntityPlayer player;
    public final ItemStack stack;
    public final int x;
    public final int y;
    public final int z;
    public BlockPlaceEvent(EntityPlayer player, ItemStack stack, int x, int y, int z) {
        this.player = player;
        this.stack = stack;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
