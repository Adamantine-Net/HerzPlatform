package net.ada.v1_5_2.potion;

public final class PotionRegistry {

    private static final int MIN_ID = 21;
    private static final int MAX_ID = 127;
    private static int nextId = MIN_ID;

    public static int reserveId() {
        if (nextId > MAX_ID) {
            throw new IllegalStateException("out of potion ids");
        }
        return nextId++;
    }

    private PotionRegistry() {
    }
}
