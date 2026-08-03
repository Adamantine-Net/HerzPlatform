package net.ada.v1_5_2.block;

public final class BlockRegistry {

    private static int nextId = 250;

    public static int reserveId() {
        return nextId++;
    }

    private BlockRegistry() {
    }
}
