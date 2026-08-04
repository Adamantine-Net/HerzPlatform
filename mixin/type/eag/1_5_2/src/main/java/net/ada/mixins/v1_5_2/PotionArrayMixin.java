package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.ModifyConstant;
import net.ada.mixin.annotation.Mixin;

import net.minecraft.src.Potion;

@Mixin(Potion.class)
public class PotionArrayMixin {

    @ModifyConstant(method = "<clinit>", constant = 32, replacement = 128)
    private void herz$expandPotionArray() {
    }
}
