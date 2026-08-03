package dev.notanorange.mixins.v1_8;

import dev.notanorange.mixin.annotation.At;
import dev.notanorange.mixin.annotation.Inject;
import dev.notanorange.mixin.annotation.Mixin;
import dev.notanorange.v1_8.block.BlockRegistry;

import net.minecraft.block.Block;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "registerBlocks", at = At.TAIL)
    private static void herz$afterRegisterBlocks() {
        BlockRegistry.BLOCKS.registerAll();
    }
}
