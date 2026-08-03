package net.ada.v1_5_2.capability;

import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;

public final class ItemCapabilityProvider {

    private static final String ROOT_KEY = "ada_caps";

    public static <T> void set(ItemStack stack, ItemCapability<T> capability, T value) {
        NBTTagCompound root = getOrCreateRoot(stack);
        root.setTag(capability.getName(), capability.write(value));
    }

    public static <T> T get(ItemStack stack, ItemCapability<T> capability) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null || !tag.hasKey(ROOT_KEY)) {
            return null;
        }
        NBTTagCompound root = tag.getCompoundTag(ROOT_KEY);
        if (!root.hasKey(capability.getName())) {
            return null;
        }
        return capability.read(root.getCompoundTag(capability.getName()));
    }

    public static boolean has(ItemStack stack, ItemCapability<?> capability) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null || !tag.hasKey(ROOT_KEY)) {
            return false;
        }
        return tag.getCompoundTag(ROOT_KEY).hasKey(capability.getName());
    }

    private static NBTTagCompound getOrCreateRoot(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        NBTTagCompound root;
        if (tag.hasKey(ROOT_KEY)) {
            root = tag.getCompoundTag(ROOT_KEY);
        } else {
            root = new NBTTagCompound();
            tag.setTag(ROOT_KEY, root);
        }
        return root;
    }

    private ItemCapabilityProvider() {
    }
}
