package net.ada.v1_5_2.item;

import net.ada.api.registry.IdMapping;

public final class ItemRegistry {

    public static final IdMapping IDS = new IdMapping(5000);

    public static int reserveId(String name) {
        return IDS.assign(name);
    }

    private ItemRegistry() {
    }
}
