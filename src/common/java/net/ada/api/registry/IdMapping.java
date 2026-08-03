package net.ada.api.registry;

import java.util.LinkedHashMap;
import java.util.Map;

public final class IdMapping {

    private final Map<String, Integer> nameToId = new LinkedHashMap<>();
    private final Map<Integer, String> idToName = new LinkedHashMap<>();
    private int nextId;

    public IdMapping(int startId) {
        nextId = startId;
    }

    public int assign(String name) {
        Integer existing = nameToId.get(name);
        if (existing != null) {
            return existing;
        }
        while (idToName.containsKey(nextId)) {
            nextId++;
        }
        int id = nextId++;
        nameToId.put(name, id);
        idToName.put(id, name);
        return id;
    }

    public Map<String, Integer> entries() {
        return nameToId;
    }
}
