package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.ModifyConstant;
import net.ada.mixin.annotation.Mixin;

import net.minecraft.src.Enchantment;

@Mixin(Enchantment.class)
public class EnchantmentArrayMixin {

    @ModifyConstant(method = "<clinit>", constant = 256, replacement = 32767)
    private void herz$expandEnchantmentArray() {
    }
}
