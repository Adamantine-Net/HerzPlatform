package dev.notanorange.v1_8.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class ItemRegistry {

    private static int nextId = 20000;
    private static boolean ready = false;

    public static Item register(String id, Item item) {
        if (!ready) {
            throw new IllegalStateException("cant register");
        }
        int assignedId = nextId++;
        Item.itemRegistry.register(assignedId, new ResourceLocation(id), item);
        return item;
    }

    public static void markReady() {
        ready = true;
    }

    private ItemRegistry() {
    }
}