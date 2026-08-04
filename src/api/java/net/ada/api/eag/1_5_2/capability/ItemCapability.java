package net.ada.v1_5_2.capability;

import net.minecraft.src.NBTTagCompound;

public final class ItemCapability<T> {

    private final String name;
    private final NbtSerializer<T> serializer;

    public ItemCapability(String name, NbtSerializer<T> serializer) {
        this.name = name;
        this.serializer = serializer;
    }

    public String getName() {
        return name;
    }

    NBTTagCompound write(T value) {
        return serializer.write(value);
    }

    T read(NBTTagCompound tag) {
        return serializer.read(tag);
    }

    public interface NbtSerializer<T> {
        NBTTagCompound write(T value);

        T read(NBTTagCompound tag);
    }
}
