package net.ada.v1_8.block;

import net.ada.api.registry.DeferredRegister;
import net.ada.api.registry.IdMapping;
import net.ada.api.registry.Registry;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public final class BlockRegistry {

    public static final IdMapping IDS = new IdMapping(4096);

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(
            new Registry<>("blocks", IDS),
            (id, name, block) -> Block.blockRegistry.register(id, new ResourceLocation(name), block)
    );

    private BlockRegistry() {
    }
}
