package net.ada.v1_8.capability;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public final class BlockCapabilityProvider {

    private static final Map<World, Map<BlockPos, Map<BlockCapability<?>, Object>>> store = new IdentityHashMap<>();

    public static <T> void set(World world, BlockPos pos, BlockCapability<T> capability, T value) {
        Map<BlockPos, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            worldStore = new HashMap<>();
            store.put(world, worldStore);
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(pos);
        if (posStore == null) {
            posStore = new HashMap<>();
            worldStore.put(pos, posStore);
        }
        posStore.put(capability, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(World world, BlockPos pos, BlockCapability<T> capability) {
        Map<BlockPos, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            return null;
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(pos);
        if (posStore == null) {
            return null;
        }
        return (T) posStore.get(capability);
    }

    public static boolean has(World world, BlockPos pos, BlockCapability<?> capability) {
        Map<BlockPos, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore == null) {
            return false;
        }
        Map<BlockCapability<?>, Object> posStore = worldStore.get(pos);
        return posStore != null && posStore.containsKey(capability);
    }

    public static void clear(World world, BlockPos pos) {
        Map<BlockPos, Map<BlockCapability<?>, Object>> worldStore = store.get(world);
        if (worldStore != null) {
            worldStore.remove(pos);
        }
    }

    private BlockCapabilityProvider() {
    }
}
