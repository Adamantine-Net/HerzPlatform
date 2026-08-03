package net.ada.v1_8.config;

import java.util.HashMap;
import java.util.Map;

public final class ConfigManager {

    private static final Map<String, Config> configs = new HashMap<>();

    public static Config get(String modId) {
        Config config = configs.get(modId);
        if (config == null) {
            config = new Config(modId);
            configs.put(modId, config);
        }
        return config;
    }

    private ConfigManager() {
    }
}
