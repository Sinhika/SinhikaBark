/**
 * implementation file for class BlockBark.
 */
package com.sinhika.bark.blocks;

import java.util.List;

import com.sinhika.bark.Bark;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author cyhiggin
 *
 */
public class BlockBark extends Block {

    public static final String[] bark_names = new String[] {"oak", "spruce", "birch", "cinnamon", "acacia", "big_oak"};
    protected static String[] oredict_names = new String[bark_names.length];
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

	/**
	 * 
	 */
	public BlockBark() {
		super(Material.wood);
		this.setBlockName(Bark.MODID + "_barkblock");
		this.setBlockTextureName("log");
	    this.setCreativeTab(Bark.customTabSpices);
        this.setHardness(1.5F);
	    this.setStepSound(soundTypeWood);
	}
	
	/**
     * Determines the damage on the item the block drops. Used in cloth and
     * wood.
     */
    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
	
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= this.icons.length)
        {
            par2 = 0;
        }
        return this.icons[par2];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.icons = new IIcon[bark_names.length];
        for (int i = 0; i < icons.length; ++i)
        {	
        	if (bark_names[i] == "cinnamon") {
        		this.icons[i] = 
        				iconRegister.registerIcon(Bark.MODID + ":" + "bark_cinnamon");
        	}
        	else {
        		this.icons[i] = iconRegister.registerIcon("minecraft:log_" + bark_names[i]);
        	}
        }
    } // end registerIcons()
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: bark
     * returns 6 blocks)
     */
    @SuppressWarnings("unchecked")
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs,
            @SuppressWarnings("rawtypes") List subItems)
    {
        for (int i = 0; i < bark_names.length; i++)
        {
            subItems.add(new ItemStack(par1, 1, i));
        }
    } // end getSubBlocks()

	public static String getOredict_name(int i) {
		return oredict_names[i];
	}

	public static void setOredict_name(String bark_name, int i) 
	{
		StringBuilder dictName = new StringBuilder();
		dictName.append("woodBark");
		dictName.append(bark_name.substring(0,1).toUpperCase());
		dictName.append(bark_name.substring(1));
		oredict_names[i] = dictName.toString();
	}

	
    
} /* end class BlockBark */
