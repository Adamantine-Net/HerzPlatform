package net.ada.v1_5_2.persist;

import net.ada.api.registry.IdMapping;
import net.ada.v1_5_2.block.BlockRegistry;
import net.ada.v1_5_2.entity.EntityRegistry;
import net.ada.v1_5_2.item.ItemRegistry;

import java.util.LinkedHashMap;
import java.util.Map;

public final class PersistentIds {

    public static String snapshot() {
        StringBuilder sb = new StringBuilder();
        appendSection(sb, "items", ItemRegistry.IDS);
        appendSection(sb, "blocks", BlockRegistry.IDS);
        appendSection(sb, "entities", EntityRegistry.IDS);
        return sb.toString();
    }

    private static void appendSection(StringBuilder sb, String section, IdMapping ids) {
        for (Map.Entry<String, Integer> entry : ids.entries().entrySet()) {
            sb.append(section).append(':').append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
        }
    }

    public static void verifyOrThrow(String saved) {
        Map<String, Integer> savedMap = parse(saved);
        Map<String, Integer> currentMap = parse(snapshot());

        StringBuilder mismatches = new StringBuilder();
        for (Map.Entry<String, Integer> entry : savedMap.entrySet()) {
            Integer currentId = currentMap.get(entry.getKey());
            if (currentId == null) {
                mismatches.append("missing: ").append(entry.getKey()).append('\n');
            } else if (!currentId.equals(entry.getValue())) {
                mismatches.append(entry.getKey()).append(" was ").append(entry.getValue())
                        .append(" now ").append(currentId).append('\n');
            }
        }

        if (mismatches.length() > 0) {
            throw new IllegalStateException("world id mapping mismatch, refusing to load:\n" + mismatches);
        }
    }

    private static Map<String, Integer> parse(String data) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String line : data.split("\n")) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            int eq = trimmed.lastIndexOf('=');
            if (eq < 0) {
                continue;
            }
            result.put(trimmed.substring(0, eq), Integer.parseInt(trimmed.substring(eq + 1)));
        }
        return result;
    }

    private PersistentIds() {
    }
}
