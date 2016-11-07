package org.moreofeverything.bakery.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.moreofeverything.bakery.init.ModItems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ModRecipes
{
    public static void addRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.EGG_BOWL),
                new ItemStack(Items.BOWL), new ItemStack((Items.EGG)));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.DOUGH),
                new ItemStack(ModItems.EGG_BOWL.setContainerItem(Items.BOWL)),
                new ItemStack(Items.POTIONITEM.setContainerItem(Items.GLASS_BOTTLE)),
                new ItemStack(ModItems.FLOUR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FLOUR),
                new ItemStack(ModItems.MORTAR_AND_PESTLE),
                new ItemStack(Items.WHEAT));

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.MORTAR_AND_PESTLE),
                "  A",
                "BCB",
                " B ",
                'A', new ItemStack(Items.STICK), 'B', new ItemStack(Blocks.STONE,1,1), 'C', new ItemStack(Blocks.STONE,1,2));
    }

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

    public static void removeFurnaceRecipe(ItemStack item)
    {
        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.instance().getSmeltingList();
        for (Iterator<Map.Entry<ItemStack,ItemStack>> i = smeltingList.entrySet().iterator(); i.hasNext(); ){
            Map.Entry<ItemStack,ItemStack> entry = i.next();
            ItemStack result = entry.getValue();
            if (ItemStack.areItemStacksEqual(result, item)){
                i.remove();
            }
        }
    }
}
