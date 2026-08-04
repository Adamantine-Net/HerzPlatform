package net.ada.v1_8.potion;

public final class PotionRegistry {

    private static final int MIN_ID = 24;
    private static final int MAX_ID = 127;
    private static int nextId = MIN_ID;

    public static int reserveId(String name) {
        if (nextId > MAX_ID) {
            throw new IllegalStateException("out of potion ids, vanilla 1.8 only allows "
                    + (MAX_ID - MIN_ID + 1) + " custom potions");
        }
        return nextId++;
    }

    private PotionRegistry() {
    }
}
