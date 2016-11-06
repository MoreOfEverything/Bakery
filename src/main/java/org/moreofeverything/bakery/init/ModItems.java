package org.moreofeverything.bakery.init;

import org.moreofeverything.bakery.Bakery;
import org.moreofeverything.bakery.item.*;
import org.moreofeverything.bakery.item.base.ItemBase;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@GameRegistry.ObjectHolder(Bakery.MODID)
public class ModItems {

    private static final List<ItemBase> ITEMS = new ArrayList<>();

    public static final ItemBase DOUGH = new ItemDough();
    public static final ItemBase EGG_BOWL = new ItemEggBowl();
    public static final ItemBase FLOUR = new ItemFlour();
    public static final ItemBase MORTAR_AND_PESTLE = new ItemMortarAndPestle();

    private ModItems() {}

    public static Collection<ItemBase> getItems() {
        return ITEMS;
    }

    public static void register(ItemBase item) {
        ITEMS.add(item);
    }
}