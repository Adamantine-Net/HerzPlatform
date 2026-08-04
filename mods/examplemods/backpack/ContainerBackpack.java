package net.ada.example.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBackpack extends Container {

    private final IInventory backpackInventory;

    public ContainerBackpack(InventoryPlayer playerInv, IInventory backpackInventory) {
        this.backpackInventory = backpackInventory;

        // 5x5x grid
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                addSlotToContainer(new Slot(backpackInventory, row * 5 + col, 8 + col * 18, 18 + row * 18));
            }
        }

        //standard player inv below it
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlotToContainer(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 122 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            addSlotToContainer(new Slot(playerInv, col, 8 + col * 18, 180)); //hotbar
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return backpackInventory.isUseableByPlayer(player);
    }

    //shift click handler
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack result = null;
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            result = stackInSlot.copy();

            if (slotIndex < 25) {
                // shift clicking FROM backpack TO player inv
                if (!mergeItemStack(stackInSlot, 25, 61, true)) {
                    return null;
                }
            } else {
                // shift clicking FROM player inv INTO the backpack
                if (!mergeItemStack(stackInSlot, 0, 25, false)) {
                    return null;
                }
            }

            if (stackInSlot.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return result;
    }
}
