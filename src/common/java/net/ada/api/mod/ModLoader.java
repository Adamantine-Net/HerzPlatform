package net.ada.api.mod;

public final class ModLoader {

    private static boolean initialized = false;

    public static void initAll() {
        if (initialized) {
            return;
        }
        initialized = true;
    }

    private ModLoader() {
    }
}
