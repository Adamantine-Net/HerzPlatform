package net.ada.v1_5_2.recipe;

import net.minecraft.src.IRecipe;

import java.util.ArrayList;
import java.util.List;

public final class RecipeRegistry {

    private static final List<IRecipe> pending = new ArrayList<>();

    public static void register(IRecipe recipe) {
        pending.add(recipe);
    }

    public static List<IRecipe> flush() {
        List<IRecipe> copy = new ArrayList<>(pending);
        pending.clear();
        return copy;
    }

    private RecipeRegistry() {
    }
}
