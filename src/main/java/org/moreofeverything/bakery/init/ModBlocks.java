package org.moreofeverything.bakery.init;

import org.moreofeverything.bakery.Bakery;
import org.moreofeverything.bakery.block.BlockOven;
import org.moreofeverything.bakery.block.base.BlockBase;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@GameRegistry.ObjectHolder(Bakery.MODID)
public class ModBlocks
{

    private static final List<BlockBase> BLOCKS = new ArrayList<>();

    public static final BlockBase OVEN = new BlockOven();

    private ModBlocks() {}

    public static Collection<BlockBase> getBlocks()
    {
        return BLOCKS;
    }

    public static void register(BlockBase block)
    {
        BLOCKS.add(block);
    }
}
