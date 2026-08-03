package net.ada.example.backpack;

import net.minecraft.item.Item;

public class ItemBackpack extends Item {

    public ItemBackpack() {
        setMaxStackSize(1); //cant stack backpacks obviously ;-;
        setUnlocalizedName("backpack");
    }
}
