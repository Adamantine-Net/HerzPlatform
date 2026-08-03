package net.ada.v1_8.loot;

import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public final class LootRegistry {

    private static final Map<Block, LootModifier> byBlock = new HashMap<>();

    public static void register(Block block, LootModifier modifier) {
        byBlock.put(block, modifier);
    }

    public static LootModifier get(Block block) {
        return byBlock.get(block);
    }

    private LootRegistry() {
    }
}
