package net.ada.api.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EventBus {

    public static final EventBus INSTANCE = new EventBus();

    private final Map<Class<?>, List<Listener>> listeners = new HashMap<>();

    private static final class Listener {
        final Object target;
        final Method method;

        Listener(Object target, Method method) {
            this.target = target;
            this.method = method;
        }
    }

    public synchronized void register(Object subscriber) {
        for (Method method : subscriber.getClass().getDeclaredMethods()) {
            if (!method.isAnnotationPresent(SubscribeEvent.class)) {
                continue;
            }

            Class<?>[] params = method.getParameterTypes();
            if (params.length != 1 || !Event.class.isAssignableFrom(params[0])) {
                throw new IllegalArgumentException("@SubscribeEvent method " + subscriber.getClass().getName()
                        + "#" + method.getName() + " needs exactly one Event parameter");
            }

            method.setAccessible(true);
            listeners.computeIfAbsent(params[0], k -> new ArrayList<>()).add(new Listener(subscriber, method));
        }
    }

    public synchronized void unregister(Object subscriber) {
        for (List<Listener> list : listeners.values()) {
            list.removeIf(l -> l.target == subscriber);
        }
    }

    public synchronized boolean hasListeners(Class<? extends Event> eventType) {
        List<Listener> list = listeners.get(eventType);
        return list != null && !list.isEmpty();
    }

    public void post(Event event) {
        List<Listener> matching;
        synchronized (this) {
            List<Listener> found = listeners.get(event.getClass());
            if (found == null || found.isEmpty()) {
                return;
            }
            matching = new ArrayList<>(found);
        }

        for (Listener listener : matching) {
            try {
                listener.method.invoke(listener.target, event);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("failed calling " + listener.target.getClass().getName()
                        + "#" + listener.method.getName(), e);
            }
        }
    }

    private EventBus() {
    }
}
