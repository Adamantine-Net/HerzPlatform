package net.ada.api.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class DeferredRegister<T> {

    private final Registry<T> registry;
    private final RegistryPusher<T> pusher;
    private final List<Entry<T>> pending = new ArrayList<>();

    public DeferredRegister(Registry<T> registry, RegistryPusher<T> pusher) {
        this.registry = registry;
        this.pusher = pusher;
    }

    public RegistryObject<T> register(String name, Supplier<T> supplier) {
        RegistryObject<T> holder = new RegistryObject<>();
        pending.add(new Entry<>(name, supplier, holder));
        return holder;
    }

    public void registerAll() {
        for (Entry<T> entry : pending) {
            T created = entry.supplier.get();
            registry.register(entry.name, created, pusher);
            entry.holder.bind(created);
        }
        pending.clear();
    }

    private static final class Entry<T> {
        final String name;
        final Supplier<T> supplier;
        final RegistryObject<T> holder;

        Entry(String name, Supplier<T> supplier, RegistryObject<T> holder) {
            this.name = name;
            this.supplier = supplier;
            this.holder = holder;
        }
    }
}
