package net.ada.v1_8.villager;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.village.MerchantRecipeList;

public interface TradeEntry {
    void modifyMerchantRecipeList(MerchantRecipeList recipeList, EaglercraftRandom random);
}
