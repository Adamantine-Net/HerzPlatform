package net.ada.api.registry;

public final class RegistryObject<T> {

    private T value;

    void bind(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null) {
            throw new IllegalStateException("not registered yet, cant call get() before the registry event fires");
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }
}
