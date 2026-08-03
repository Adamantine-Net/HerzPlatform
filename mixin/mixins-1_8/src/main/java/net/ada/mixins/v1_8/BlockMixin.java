package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.block.BlockRegistry;

import net.minecraft.block.Block;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "registerBlocks", at = At.TAIL)
    private static void herz$afterRegisterBlocks() {
        BlockRegistry.BLOCKS.registerAll();
    }
}
