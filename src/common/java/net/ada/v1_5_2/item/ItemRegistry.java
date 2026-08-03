package net.ada.v1_5_2.item;

public final class ItemRegistry {

    private static int nextId = 5000;

    public static int reserveId() {
        return nextId++;
    }

    private ItemRegistry() {
    }
}
