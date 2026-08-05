package net.ada.v1_8.enchantment;

public final class EnchantmentRegistry {

    private static final int MIN_ID = 63;
    private static final int MAX_ID = 32766;
    private static int nextId = MIN_ID;

    public static int reserveId(String name) {
        if (nextId > MAX_ID) {
            throw new IllegalStateException("out of enchantment ids");
        }
        return nextId++;
    }

    private EnchantmentRegistry() {
    }
}
