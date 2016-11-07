package org.moreofeverything.bakery;

import org.moreofeverything.bakery.init.ModItems;
import org.moreofeverything.bakery.recipe.ModRecipes;
import org.moreofeverything.bakery.init.RemoveRecipes;
import org.moreofeverything.bakery.item.base.ItemBase;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Bakery.MODID, version = Bakery.VERSION)
public class Bakery
{
    public static final String MODID = "bakery";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RemoveRecipes.remove();
        ModItems.getItems().forEach(GameRegistry::register);
        if (event.getSide() == Side.CLIENT) {
            ModItems.getItems().forEach(ItemBase::initModelsAndVariants);
        }
        ModRecipes.addRecipes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
