package net.ada.v1_5_2.event;
import net.ada.api.event.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
public class ItemUseEvent extends Event {
    public final ItemStack stack;
    public final World world;
    public final EntityPlayer player;
    public ItemUseEvent(ItemStack stack, World world, EntityPlayer player) {
        this.stack = stack;
        this.world = world;
        this.player = player;
    }
}
