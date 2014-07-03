package sinhika.bark.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import sinhika.bark.Bark;

public class BarkItemBlock extends ItemBlockWithMetadata
{

    public BarkItemBlock(Block par1, Block par2Block)
    {
        super(par1, par2Block);
        setCreativeTab(Bark.customTabSpices);
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an
     * ItemStack so different stacks can have different names based on their
     * damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, BlockBark.bark_names.length);
    	return super.getUnlocalizedName() + "." + BlockBark.bark_names[i];               
    }
}
