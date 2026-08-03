package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.mixin.callback.CallbackInfo;
import net.ada.v1_8.villager.Profession;
import net.ada.v1_8.villager.ProfessionRegistry;
import net.ada.v1_8.villager.TradeEntry;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipeList;

@Mixin(EntityVillager.class)
public class EntityVillagerMixin {

    @Shadow
    protected EaglercraftRandom rand;

    @Shadow
    private MerchantRecipeList buyingList;

    @Shadow
    public int getProfession() {
        return 0;
    }

    @Inject(method = "populateBuyingList", at = At.HEAD, cancellable = true)
    private void herz$populateBuyingList(CallbackInfo ci) {
        Profession custom = ProfessionRegistry.get(getProfession());
        if (custom == null) {
            return;
        } //repalce later 
        buyingList = new MerchantRecipeList();
        for (TradeEntry trade : custom.trades) {
            trade.modifyMerchantRecipeList(buyingList, rand);
        }
        ci.cancel();
    }
}
