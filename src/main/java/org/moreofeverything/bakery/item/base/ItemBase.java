package org.moreofeverything.bakery.item.base;

import org.moreofeverything.bakery.Bakery;
import org.moreofeverything.bakery.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item
{
    private final String BASE_NAME;

    public ItemBase(String name, CreativeTabs tab)
    {
        super();
        BASE_NAME = name;
        setRegistryName(name);
        setUnlocalizedName(Bakery.MODID + "_" + BASE_NAME);
        setCreativeTab(tab);

        ModItems.register(this);
    }

    public void initModelsAndVariants() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

    public ItemBase getItem() {
        return this;
    }
}