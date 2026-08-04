package net.ada.v1_8.item;

import net.ada.api.registry.DeferredRegister;
import net.ada.api.registry.IdMapping;
import net.ada.api.registry.Registry;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class ItemRegistry {

    public static final IdMapping IDS = new IdMapping(20000);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(
            new Registry<>("items", IDS),
            (id, name, item) -> Item.itemRegistry.register(id, new ResourceLocation(name), item)
    );

    private ItemRegistry() {
    }
}
