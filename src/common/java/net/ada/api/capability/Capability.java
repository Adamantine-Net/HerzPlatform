package net.ada.api.capability;

public final class Capability<T> {

    private final String name;

    public Capability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
