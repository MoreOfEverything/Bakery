package org.moreofeverything.bakery;

import org.moreofeverything.bakery.init.*;
import org.moreofeverything.bakery.item.base.ItemBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Bakery.MODID, version = Bakery.VERSION)
public class Bakery
{
    public static final String MODID = "moe_bakery";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModRecipes.removeRecipes();
        ModItems.getItems().forEach(GameRegistry::register);
        if (event.getSide() == Side.CLIENT)
        {
            ModItems.getItems().forEach(ItemBase::initModelsAndVariants);
        }
        ModRecipes.addRecipes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
