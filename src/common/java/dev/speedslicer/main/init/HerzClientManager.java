package dev.speedslicer.main.init;

import dev.speedslicer.api.PlatformAPI;

import java.util.Objects;

public class HerzClientManager {
    private static PlatformAPI platform;

    private HerzClientManager() {
    }

    public static void initialize(PlatformAPI platformAPI) {
        if (platform != null) {
            throw new IllegalStateException(
                    "MeinHerzBrennt is already initialized"
            );
        }

        platform = Objects.requireNonNull(
                platformAPI,
                "platformAPI"
        );

        platform.logger().info("MeinHerzBrennt initialized");
    }

    public static PlatformAPI platform() {
        if (platform == null) {
            throw new IllegalStateException(
                    "MeinHerzBrennt has not been initialized"
            );
        }

        return platform;
    }
}
