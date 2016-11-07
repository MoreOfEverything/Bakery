package org.moreofeverything.bakery.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;

import java.util.ArrayList;

public class CraftingUtils
{
    public static void removeRecipe(ItemStack item)
    {
        ItemStack recipeResult = null;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe tmpRecipe = (IRecipe) recipes.get(i);
            if (tmpRecipe instanceof ShapedRecipes)
            {
                ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (tmpRecipe instanceof ShapelessRecipes)
            {
                ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
                recipeResult = recipe.getRecipeOutput();
            }
            if (ItemStack.areItemStacksEqual(item, recipeResult))
            {
                recipes.remove(i);
            }
        }
    }
}
