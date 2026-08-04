package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_8.loot.LootModifier;
import net.ada.v1_8.loot.LootRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

@Mixin(Block.class)
public class BlockDropsMixin {

    @Inject(method = "dropBlockAsItemWithChance", at = At.HEAD, cancellable = true)
    private void herz$dropBlockAsItemWithChance(World world, BlockPos blockpos, IBlockState iblockstate,
                                                 float f, int i, CallbackInfo ci) {
        LootModifier modifier = LootRegistry.get((Block) (Object) this);
        if (modifier != null) {
            modifier.drop(world, blockpos, iblockstate, f, i);
            ci.cancel();
        }
    }
}
