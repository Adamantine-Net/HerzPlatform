package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.HarvestBlockEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
@Mixin(Block.class)
public class HarvestBlockMixin {
    @Inject(method = "harvestBlock", at = At.HEAD)
    private void herz$harvestBlock(World world, EntityPlayer entityplayer, BlockPos blockpos,
                                    IBlockState iblockstate, TileEntity te) {
        EventBus.INSTANCE.post(new HarvestBlockEvent(world, entityplayer, blockpos, iblockstate));
    }
}
