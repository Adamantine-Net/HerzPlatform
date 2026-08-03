package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.item.ItemRegistry;

import net.minecraft.item.Item;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "registerItems", at = At.TAIL)
    private static void herz$afterRegisterItems() {
        ItemRegistry.ITEMS.registerAll();
    }
}
