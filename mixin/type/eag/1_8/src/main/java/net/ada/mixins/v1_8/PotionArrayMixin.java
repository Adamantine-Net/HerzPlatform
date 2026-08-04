package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.ModifyConstant;
import net.ada.mixin.annotation.Mixin;

import net.minecraft.potion.Potion;

@Mixin(Potion.class)
public class PotionArrayMixin {

    @ModifyConstant(method = "<clinit>", constant = 32, replacement = 128)
    private void herz$expandPotionArray() {
    }
}
