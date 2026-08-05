package net.ada.api.event;

public class Event {

    private boolean cancelled = false;

    public boolean isCancellable() {
        return false;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        if (!isCancellable()) {
            throw new UnsupportedOperationException(getClass().getSimpleName() + " isnt cancellable");
        }
        this.cancelled = cancelled;
    }
}
