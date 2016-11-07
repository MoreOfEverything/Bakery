package org.moreofeverything.bakery.init;

import org.moreofeverything.bakery.recipe.ModRecipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RemoveRecipes {

    public static void remove() {
        ModRecipes.removeRecipe(new ItemStack(Items.BREAD));
    }
}