package net.ada.mixins.v1_8;

import net.ada.api.mod.ModLoader;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.block.BlockRegistry;

import net.minecraft.block.Block;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "registerBlocks", at = At.HEAD)
    private static void herz$beforeRegisterBlocks() {
        // this is the actual first thing Bootstrap.register() calls, before
        // ANY other registry flush (items, entities, etc all come after this),
        // so mods need to be initialized here to have any chance of registering
        // blocks/items/whatever in time
        ModLoader.initAll();
    }

    @Inject(method = "registerBlocks", at = At.TAIL)
    private static void herz$afterRegisterBlocks() {
        BlockRegistry.BLOCKS.registerAll();
    }
}
