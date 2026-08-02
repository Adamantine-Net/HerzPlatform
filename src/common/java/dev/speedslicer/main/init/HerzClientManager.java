package dev.speedslicer.main.init;

import dev.speedslicer.api.PlatformAPI;
import dev.speedslicer.main.HerzClientConfiguration;

import java.util.Objects;

public class HerzClientManager {
    private static PlatformAPI platform;

    private HerzClientManager() {
    }

    public static void initialize(PlatformAPI platformAPI) {
        if (platform != null) {
            throw new IllegalStateException(
                    HerzClientConfiguration.clientBrandName + " is already initialized"
            );
        }

        platform = Objects.requireNonNull(
                platformAPI,
                "platformAPI"
        );

        platform.logger().info(HerzClientConfiguration.clientBrandName + " initialized");
    }

    public static PlatformAPI platform() {
        if (platform == null) {
            throw new IllegalStateException(
                    HerzClientConfiguration.clientBrandName + " has not been initialized"
            );
        }

        return platform;
    }
}
