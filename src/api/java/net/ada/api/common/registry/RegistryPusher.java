package net.ada.api.registry;

public interface RegistryPusher<T> {
    void push(int id, String name, T entry);
}
