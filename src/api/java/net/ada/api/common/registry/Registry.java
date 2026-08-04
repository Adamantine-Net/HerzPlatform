package net.ada.api.registry;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Registry<T> {

    private final String name;
    private final IdMapping ids;
    private final Map<String, T> byName = new LinkedHashMap<>();

    public Registry(String name, IdMapping ids) {
        this.name = name;
        this.ids = ids;
    }

    T register(String id, T entry, RegistryPusher<T> pusher) {
        if (byName.containsKey(id)) {
            throw new IllegalStateException("'" + id + "' is already registered in " + name);
        }
        int assignedId = ids.assign(id);
        pusher.push(assignedId, id, entry);
        byName.put(id, entry);
        return entry;
    }

    public T get(String id) {
        return byName.get(id);
    }

    public IdMapping getIdMapping() {
        return ids;
    }
}
