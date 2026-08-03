package net.ada.api.capability;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public final class CapabilityProvider {

    private static final Map<Object, Map<Capability<?>, Object>> store = new IdentityHashMap<>();

    public static <T> void set(Object owner, Capability<T> capability, T instance) {
        Map<Capability<?>, Object> caps = store.get(owner);
        if (caps == null) {
            caps = new HashMap<>();
            store.put(owner, caps);
        }
        caps.put(capability, instance);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Object owner, Capability<T> capability) {
        Map<Capability<?>, Object> caps = store.get(owner);
        if (caps == null) {
            return null;
        }
        return (T) caps.get(capability);
    }

    public static boolean has(Object owner, Capability<?> capability) {
        Map<Capability<?>, Object> caps = store.get(owner);
        return caps != null && caps.containsKey(capability);
    }

    public static void clear(Object owner) {
        store.remove(owner);
    }

    private CapabilityProvider() {
    }
}
