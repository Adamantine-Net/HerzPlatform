package dev.notanorange.v1_8.block;

import dev.notanorange.api.registry.DeferredRegister;
import dev.notanorange.api.registry.Registry;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public final class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(
            new Registry<>("blocks", 4096),
            (id, name, block) -> Block.blockRegistry.register(id, new ResourceLocation(name), block)
    );

    private BlockRegistry() {
    }
}
