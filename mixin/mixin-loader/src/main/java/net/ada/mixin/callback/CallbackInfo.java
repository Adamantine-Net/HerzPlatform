package net.ada.mixin.callback;

public class CallbackInfo {

    private boolean cancelled = false;

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }
}
