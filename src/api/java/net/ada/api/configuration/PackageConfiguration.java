package net.ada.api.configuration;


import java.util.List;

public record PackageConfiguration (
        String UUID,
        String id,
        String name,
        List<String> description,
        List<PlatformType> platforms
){

}
