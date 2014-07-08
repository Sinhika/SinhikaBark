package com.sinhika.bark.items;

import java.util.List;

import com.sinhika.bark.Bark;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBark extends Item
{
	public static final String[] names = new String[]
			{"oak", "spruce", "birch", "cinnamon", "acacia", "big_oak"};
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	 
    public ItemBark()
    {
        super();
        this.setMaxStackSize(64);
        this.setCreativeTab(Bark.customTabSpices);
        this.setUnlocalizedName(Bark.MODID + "_bark");
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	icons = new IIcon[names.length];
    	for (int ii=0; ii < icons.length; ii++) {
    		if (names[ii] == "cinnamon") {
    			icons[ii] = iconRegister.registerIcon(Bark.MODID + ":" + names[ii] + "_sticks");
    		}
    		else {
    			icons[ii] = iconRegister.registerIcon(Bark.MODID + ":" + names[ii] + "_bark");
    		}
    	} // end for
    }

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getUnlocalizedName(net.minecraft.item.ItemStack)
	 */
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, names.length);
		return super.getUnlocalizedName() + "." + names[i];
	} // end getUnlocalizedName()

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getIconFromDamage(int)
	 */
	@Override
	public IIcon getIconFromDamage(int par1) {
		return icons[par1];
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getSubItems(net.minecraft.item.Item, net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			@SuppressWarnings("rawtypes") List par3List) 
	{
		for (int i=0; i < names.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
			
	} // end getSubItems()
    	
    
} // class ItemBark
