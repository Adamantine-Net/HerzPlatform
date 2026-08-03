package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.BlockPlaceEvent;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
@Mixin(ItemBlock.class)
public class BlockPlaceMixin {
    @Inject(method = "onItemUse", at = At.TAIL)
    private void herz$onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z,
                                 int side, float hitX, float hitY, float hitZ) {
        EventBus.INSTANCE.post(new BlockPlaceEvent(player, itemstack, x, y, z));
    }
}
