package dev.notanorange.api.registry;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Registry<T> {

    private final String name;
    private int nextId;
    private final Map<String, T> byName = new LinkedHashMap<>();

    public Registry(String name, int startId) {
        this.name = name;
        this.nextId = startId;
    }

    T register(String id, T entry, RegistryPusher<T> pusher) {
        if (byName.containsKey(id)) {
            throw new IllegalStateException("'" + id + "' is already registered in " + name);
        }
        int assignedId = nextId++;
        pusher.push(assignedId, id, entry);
        byName.put(id, entry);
        return entry;
    }

    public T get(String id) {
        return byName.get(id);
    }
}
