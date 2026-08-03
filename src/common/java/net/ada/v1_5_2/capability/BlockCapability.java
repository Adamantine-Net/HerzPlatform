package net.ada.v1_5_2.capability;

public final class BlockCapability<T> {

    private final String name;

    public BlockCapability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
