package org.moreofeverything.bakery.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import org.moreofeverything.bakery.block.base.BlockBase;
import org.moreofeverything.bakery.init.ModBlocks;
import org.moreofeverything.bakery.inventory.ContainerOven;

import javax.annotation.Nullable;

/**
 * Oven block.
 */
public class BlockOven extends BlockBase
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockOven()
    {
        super("oven", CreativeTabs.DECORATIONS, Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            playerIn.displayGui(new BlockOven.InterfaceOven(worldIn, pos));
            return true;
        }
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return (state.getValue(FACING)).getHorizontalIndex();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public static class InterfaceOven implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceOven(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return null;
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(ModBlocks.OVEN.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerOven(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
}
