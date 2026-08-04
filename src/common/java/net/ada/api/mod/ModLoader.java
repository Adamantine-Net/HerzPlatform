package net.ada.api.mod;

public final class ModLoader {

    private static boolean initialized = false;

    public static void initAll() {
        if (initialized) {
            return;
        }
        initialized = true;
        // this method body gets fully replaced by the weaver at build time with
        // direct "new SomeModInit().onInit();" calls for every ModInitializer it
        // finds. this version here only exists so the project compiles cleanly
        // even when zero mods are present - see MixinWeaver#patchModLoader
    }

    private ModLoader() {
    }
}
