package net.ada.v1_8.biome;

public final class BiomeRegistry {

    private static final int MIN_ID = 40;
    private static final int MAX_ID = 255;
    private static int nextId = MIN_ID;

    public static int reserveId(String name) {
        if (nextId > MAX_ID) {
            throw new IllegalStateException("out of biome ids, vanilla 1.8 only allows "
                    + (MAX_ID - MIN_ID + 1) + " custom biomes");
        }
        return nextId++;
    }

    private BiomeRegistry() {
    }
}
