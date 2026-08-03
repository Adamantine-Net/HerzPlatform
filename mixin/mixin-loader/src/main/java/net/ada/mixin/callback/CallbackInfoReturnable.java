package net.ada.mixin.callback;

public class CallbackInfoReturnable<T> extends CallbackInfo {

    private T returnValue;

    public void setReturnValue(T value) {
        returnValue = value;
        cancel();
    }

    public T getReturnValue() {
        return returnValue;
    }
}
