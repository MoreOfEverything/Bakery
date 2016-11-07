package org.moreofeverything.bakery.item.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.moreofeverything.bakery.init.ModItems;
import org.moreofeverything.core.util.CraftingUtils;

public class RecipesFood
{
    public static void addRecipes()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.EGG_BOWL), new ItemStack(Items.BOWL), new ItemStack((Items.EGG)));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.DOUGH), new ItemStack(ModItems.EGG_BOWL.setContainerItem(Items.BOWL)), new ItemStack(Items.POTIONITEM.setContainerItem(Items.GLASS_BOTTLE)), new ItemStack(ModItems.FLOUR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FLOUR), new ItemStack(ModItems.MORTAR_AND_PESTLE), new ItemStack(Items.WHEAT));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.MORTAR_AND_PESTLE), "  A", "BCB", " B ", 'A', new ItemStack(Items.STICK), 'B', new ItemStack(Blocks.STONE,1,1), 'C', new ItemStack(Blocks.STONE,1,2));
    }

    public static void removeRecipes()
    {
        CraftingUtils.removeRecipe(new ItemStack(Items.BREAD));
    }
}
