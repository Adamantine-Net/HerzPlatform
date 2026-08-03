package net.ada.example.backpack;

import net.ada.v1_8.capability.ItemCapability;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public final class BackpackCapability {

    public static final int SIZE = 25; // 5x5 size because good size

    public static final ItemCapability<ItemStack[]> CONTENTS = new ItemCapability<>("ada_example:backpack_contents",
            new ItemCapability.NbtSerializer<ItemStack[]>() {
                public NBTTagCompound write(ItemStack[] slots) {
                    NBTTagCompound tag = new NBTTagCompound();
                    NBTTagList list = new NBTTagList();
                    for (int i = 0; i < slots.length; i++) {
                        if (slots[i] != null) {
                            NBTTagCompound slotTag = new NBTTagCompound();
                            slotTag.setByte("Slot", (byte) i);
                            slots[i].writeToNBT(slotTag);
                            list.appendTag(slotTag);
                            // empty slots just dont get written at all so theres no point wasting bytes on null
                        }
                    }
                    tag.setTag("Items", list);
                    return tag;
                }

                public ItemStack[] read(NBTTagCompound tag) {
                    ItemStack[] slots = new ItemStack[SIZE];
                    NBTTagList list = tag.getTagList("Items", 10);
                    for (int i = 0; i < list.tagCount(); i++) {
                        NBTTagCompound slotTag = list.getCompoundTagAt(i);
                        int slot = slotTag.getByte("Slot") & 255; // byte is signed in java so you gotta mask it ugh
                        if (slot < SIZE) {
                            slots[slot] = ItemStack.loadItemStackFromNBT(slotTag);
                        }
                    }
                    return slots;
                }
            });

    private BackpackCapability() {
    }
}
