package sinhika.bark.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import sinhika.bark.Bark;
import sinhika.bark.blocks.BlockBark;

public class BarkItemBlock extends ItemMultiTexture
{

    public BarkItemBlock(Block blk)
    {
        super(blk, blk, BlockBark.bark_names);
        setUnlocalizedName(Bark.MODID + "_barkblock");
        setCreativeTab(Bark.customTabSpices);
    }

   
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getSubItems(net.minecraft.item.Item, net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			@SuppressWarnings("rawtypes") List par3List) 
	{
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
			
	} // end getSubItems()

} // end class BarkItemBlock
