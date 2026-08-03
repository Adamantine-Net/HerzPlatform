package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.HarvestBlockEvent;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
@Mixin(Block.class)
public class HarvestBlockMixin {
    @Inject(method = "harvestBlock", at = At.HEAD)
    private void herz$harvestBlock(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        EventBus.INSTANCE.post(new HarvestBlockEvent(world, player, x, y, z));
    }
}
