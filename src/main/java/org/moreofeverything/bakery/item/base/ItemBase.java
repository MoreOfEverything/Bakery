package org.moreofeverything.bakery.item.base;

import org.moreofeverything.bakery.Bakery;
import org.moreofeverything.bakery.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item
{
    private final String BASE_NAME;

    public ItemBase(String name)
    {
        super();
        BASE_NAME = name;
        setRegistryName(name);
        setUnlocalizedName(Bakery.MODID + "_" + BASE_NAME);
        setCreativeTab(CreativeTabs.MISC);

        ModItems.register(this);
    }

    public void initModelsAndVariants() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

    public ItemBase getItem() {
        return this;
    }
}