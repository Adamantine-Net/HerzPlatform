package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.recipe.RecipeRegistry;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

@Mixin(CraftingManager.class)
public class CraftingManagerMixin {

    @Inject(method = "<init>", at = At.TAIL)
    private void herz$afterInit() {
        for (IRecipe recipe : RecipeRegistry.flush()) {
            ((CraftingManager) (Object) this).addRecipe(recipe);
        }
    }
}
