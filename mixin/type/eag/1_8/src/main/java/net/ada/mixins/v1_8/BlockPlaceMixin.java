package net.ada.mixins.v1_8;

import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.BlockPlaceEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

@Mixin(ItemBlock.class)
public class BlockPlaceMixin {

    @Inject(method = "onItemUse", at = At.TAIL)
    private void herz$onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, BlockPos blockpos,
                                 EnumFacing enumfacing, float f, float f1, float f2) {
        EventBus.INSTANCE.post(new BlockPlaceEvent(entityplayer, itemstack, blockpos));
    }
}
