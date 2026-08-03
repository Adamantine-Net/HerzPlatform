package net.ada.v1_5_2.enchantment;

public final class EnchantmentRegistry {

    private static final int MIN_ID = 52;
    private static final int MAX_ID = 32766;
    private static int nextId = MIN_ID;

    public static int reserveId() {
        if (nextId > MAX_ID) {
            throw new IllegalStateException("out of enchantment ids");
        }
        return nextId++;
    }

    private EnchantmentRegistry() {
    }
}
