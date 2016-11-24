package org.moreofeverything.bakery.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import org.moreofeverything.bakery.Bakery;
import org.moreofeverything.bakery.init.ModBlocks;

public class BlockBase extends Block
{
    private final String BASE_NAME;

    public BlockBase(String name, CreativeTabs tab, Material material)
    {
        super(material);
        BASE_NAME = name;
        setRegistryName(name);
        setUnlocalizedName(Bakery.MODID + "_" + BASE_NAME);
        setCreativeTab(tab);

        ModBlocks.register(this);
    }

    public void initModelsAndVariants()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
