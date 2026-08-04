package net.ada.v1_5_2.capability;

import net.minecraft.src.World;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public final class BlockCapabilityProvider {

    private static final Map<World, Map<BlockPosKey, Map<BlockCapability<?>, Object>>> store = new IdentityHashMap<>();

    public static <T> void set(World world, int x, int y, int z, BlockCapability<T> capability, T value) {
        BlockPosKey key = new BlockPosKey(x, y, z);
        Map<BlockPosKey, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            worldStore = new HashMap<>();
            store.put(world, worldStore);
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(key);
        if (posStore == null) {
            posStore = new HashMap<>();
            worldStore.put(key, posStore);
        }
        posStore.put(capability, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(World world, int x, int y, int z, BlockCapability<T> capability) {
        Map<BlockPosKey, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            return null;
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(new BlockPosKey(x, y, z));
        if (posStore == null) {
            return null;
        }
        return (T) posStore.get(capability);
    }

    public static boolean has(World world, int x, int y, int z, BlockCapability<?> capability) {
        Map<BlockPosKey, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            return false;
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(new BlockPosKey(x, y, z));
        return posStore != null && posStore.containsKey(capability);
    }

    public static void clear(World world, int x, int y, int z) {
        Map<BlockPosKey, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore != null) {
            worldStore.remove(new BlockPosKey(x, y, z));
        }
    }

    private BlockCapabilityProvider() {
    }
}
