package dev.notanorange.v1_8.item;

import dev.notanorange.api.registry.DeferredRegister;
import dev.notanorange.api.registry.Registry;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(
            new Registry<>("items", 20000),
            (id, name, item) -> Item.itemRegistry.register(id, new ResourceLocation(name), item)
    );

    private ItemRegistry() {
    }
}
