package net.ada.v1_5_2.block;

import net.ada.api.registry.IdMapping;

public final class BlockRegistry {

    public static final IdMapping IDS = new IdMapping(250);

    public static int reserveId(String name) {
        return IDS.assign(name);
    }

    private BlockRegistry() {
    }
}
