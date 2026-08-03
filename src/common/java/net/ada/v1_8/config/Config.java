package net.ada.v1_8.config;

import net.lax1dude.eaglercraft.v1_8.internal.PlatformApplication;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Config {

    private final String storageKey;
    private final Map<String, String> values = new LinkedHashMap<>();

    Config(String modId) {
        storageKey = "net.ada.config." + modId;
        load();
    }

    public String getString(String key, String def) {
        String v = values.get(key);
        return v != null ? v : def;
    }

    public void setString(String key, String value) {
        values.put(key, value);
        save();
    }

    public int getInt(String key, int def) {
        String v = values.get(key);
        return v != null ? Integer.parseInt(v) : def;
    }

    public void setInt(String key, int value) {
        setString(key, Integer.toString(value));
    }

    public boolean getBoolean(String key, boolean def) {
        String v = values.get(key);
        return v != null ? Boolean.parseBoolean(v) : def;
    }

    public void setBoolean(String key, boolean value) {
        setString(key, Boolean.toString(value));
    }

    public float getFloat(String key, float def) {
        String v = values.get(key);
        return v != null ? Float.parseFloat(v) : def;
    }

    public void setFloat(String key, float value) {
        setString(key, Float.toString(value));
    }

    private void load() {
        byte[] data = PlatformApplication.getLocalStorage(storageKey);
        if (data == null) {
            return;
        }
        String text = toStringUtf8(data);
        for (String line : text.split("\n")) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            int eq = trimmed.indexOf('=');
            if (eq < 0) {
                continue;
            }
            values.put(trimmed.substring(0, eq), trimmed.substring(eq + 1));
        }
    }

    private void save() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            sb.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
        }
        PlatformApplication.setLocalStorage(storageKey, toBytesUtf8(sb.toString()));
    }

    private static String toStringUtf8(byte[] data) {
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] toBytesUtf8(String s) {
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
