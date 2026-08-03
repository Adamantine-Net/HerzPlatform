package net.ada.example.backpack;

import net.ada.v1_8.capability.ItemCapabilityProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class BackpackInventory implements net.minecraft.inventory.IInventory {

    private final ItemStack backpackStack;
    private final ItemStack[] slots;

    public BackpackInventory(ItemStack backpackStack) {
        this.backpackStack = backpackStack;
        ItemStack[] loaded = ItemCapabilityProvider.get(backpackStack, BackpackCapability.CONTENTS);
        this.slots = loaded != null ? loaded : new ItemStack[BackpackCapability.SIZE];
    }

    public int getSizeInventory() {
        return BackpackCapability.SIZE;
    }

    public ItemStack getStackInSlot(int slot) {
        return slots[slot];
    }

    public ItemStack decrStackSize(int slot, int amount) {
        if (slots[slot] == null) {
            return null;
        }
        ItemStack result;
        if (slots[slot].stackSize <= amount) {
            result = slots[slot];
            slots[slot] = null;
        } else {
            result = slots[slot].splitStack(amount);
        }
        markDirty();
        return result;
    }

    public ItemStack removeStackFromSlot(int slot) {
        ItemStack result = slots[slot];
        slots[slot] = null;
        markDirty();
        return result;
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        slots[slot] = stack;
        markDirty();
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void markDirty() {
        ItemCapabilityProvider.set(backpackStack, BackpackCapability.CONTENTS, slots);
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return true; 
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
        markDirty(); // probably redundant since we save on every change anyway but wtver
    }

    
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return true; // no weird slot restrictions, throw whatever u want in there
    }

    
    public int getField(int id) {
        return 0;
    }

    
    public void setField(int id, int value) {
    }

    
    public int getFieldCount() {
        return 0;
    }

    
    public void clear() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = null;
        }
        markDirty();
    }

    
    public String getName() {
        return "Backpack"; //could localize this later ig, dont care rn
    }

    
    public boolean hasCustomName() {
        return false;
    }

    
    public IChatComponent getDisplayName() {
        return new ChatComponentText(getName());
    }
}
