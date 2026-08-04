package net.ada.mixins.v1_8;

import net.ada.api.mod.ModLoader;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.item.ItemRegistry;

import net.minecraft.item.Item;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "registerItems", at = At.HEAD)
    private static void herz$beforeRegisterItems() {
        // gotta run mod init BEFORE the flush below, otherwise anything a mod
        // registers here misses the flush and never gets a real item id at all
        ModLoader.initAll();
    }

    @Inject(method = "registerItems", at = At.TAIL)
    private static void herz$afterRegisterItems() {
        ItemRegistry.ITEMS.registerAll();
    }
}
