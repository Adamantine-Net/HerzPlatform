package dev.notanorange.mixins.v1_8;

import dev.notanorange.mixin.annotation.At;
import dev.notanorange.mixin.annotation.Inject;
import dev.notanorange.mixin.annotation.Mixin;
import dev.notanorange.v1_8.item.ItemRegistry;

import net.minecraft.item.Item;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "registerItems", at = At.TAIL)
    private static void herz$afterRegisterItems() {
        ItemRegistry.markReady();
    }
}