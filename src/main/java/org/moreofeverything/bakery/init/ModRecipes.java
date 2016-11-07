package org.moreofeverything.bakery.init;

import org.moreofeverything.bakery.item.crafting.RecipesFood;

public class ModRecipes
{
    public static void addRecipes()
    {
        RecipesFood.addRecipes();
    }

    public static void removeRecipes()
    {
        RecipesFood.removeRecipes();
    }
}
