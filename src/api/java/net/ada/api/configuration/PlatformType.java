package net.ada.api.configuration;

import java.util.List;

public record PlatformType(String platform, List<VersionSourceSet> sourceSetList) {
}
