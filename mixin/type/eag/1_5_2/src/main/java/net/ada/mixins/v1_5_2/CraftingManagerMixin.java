package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_5_2.recipe.RecipeRegistry;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;

import java.util.List;

@Mixin(CraftingManager.class)
public class CraftingManagerMixin {

    @Shadow
    private List recipes;

    @Inject(method = "<init>", at = At.TAIL)
    private void herz$afterInit() {
        for (IRecipe recipe : RecipeRegistry.flush()) {
            recipes.add(recipe);
        }
    }
}
