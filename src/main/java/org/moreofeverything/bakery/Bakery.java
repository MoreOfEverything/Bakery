package org.moreofeverything.bakery;

import net.minecraft.block.Block;
import org.moreofeverything.bakery.block.base.BlockBase;
import org.moreofeverything.bakery.init.*;
import org.moreofeverything.bakery.item.base.ItemBase;
import org.moreofeverything.core.util.BlockUtils;
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
        for (Block block : ModBlocks.getBlocks())
        {
            GameRegistry.register(block);
            GameRegistry.register(BlockUtils.getItemBlockFor(block), block.getRegistryName());
        }
        if (event.getSide() == Side.CLIENT)
        {
            ModItems.getItems().forEach(ItemBase::initModelsAndVariants);
            ModBlocks.getBlocks().forEach(BlockBase::initModelsAndVariants);
        }
        ModRecipes.addRecipes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
