package com.sinhika.bark.items;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import com.google.common.collect.Sets;
import com.sinhika.bark.Bark;
import com.sinhika.bark.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemSpud extends ItemTool {

	   /** an array of the blocks this bark spud is effective against */
    @SuppressWarnings("rawtypes")
	public static final Set blocksEffectiveAgainst = 
    		Sets.newHashSet( new Block[] {Blocks.log, Blocks.log2, ModBlocks.barkBlock } );
   
    public String myToolMaterialName;
    
    public static String createToolMaterialName(ToolMaterial tm) 
    {
		if (tm == ToolMaterial.EMERALD) {
			return new String("diamond");
		}
		else {
			return new String(tm.toString().toLowerCase());
		}	
    }
    
	/**
	 * @param toolMaterial
	 */ 
	public ItemSpud(ToolMaterial toolMaterial) 
	{
		super(2.0F, toolMaterial, blocksEffectiveAgainst);
		setCreativeTab(Bark.customTabSpices);
		this.setNoRepair();	// to avoid dupe when placed in crafting table.
		myToolMaterialName = createToolMaterialName(toolMaterial);
		this.setUnlocalizedName(Bark.MODID + "_" + myToolMaterialName + "_spud");
	} // end ctor

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getContainerItem(net.minecraft.item.ItemStack)
	 */
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
        // copy our item.
		ItemStack returnItem = new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage() + 1);
		
        // is spud enchanted? If so, must copy enchantments to
        // new spud(s)
		if (itemStack.isItemEnchanted()) {
			NBTTagCompound nbtcompound = itemStack.getTagCompound();
			returnItem.setTagCompound(nbtcompound);
		}
		
		return returnItem;
	} // end getContainerItem()

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#hasContainerItem(net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#hasContainerItem()
	 */
	@Override
	public boolean hasContainerItem() {
		return true;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#doesContainerItemLeaveCraftingGrid(net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
		return false;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onBlockStartBreak(net.minecraft.item.ItemStack, int, int, int, net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z,
			EntityPlayer player) 
	{
        if (player.worldObj.isRemote) return false;
        Block targetBlock = player.worldObj.getBlock(X, Y, Z);
        if ((targetBlock instanceof BlockLog) || targetBlock == Blocks.log || targetBlock == Blocks.log2) 
        {
        	int metadata = targetBlock.getDamageValue(player.worldObj, X, Y, Z);
        	ArrayList<ItemStack> drops = getBarkPeeled(player.worldObj, targetBlock, metadata,
        					EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
        	Random rand = new Random();
        	
        	for (ItemStack stack : drops) {
                float f = 0.2F;
                double d = rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double d1 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double d2 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
                EntityItem entityItem = new EntityItem(player.worldObj, X+d, Y+d1, Z+d2, stack);
                entityItem.delayBeforeCanPickup = 10;
                player.worldObj.spawnEntityInWorld(entityItem);
        	}
        	itemstack.damageItem(1, player);
        	player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(targetBlock)], 1);
        	player.worldObj.setBlockToAir(X, Y, Z);
        	return true;
        }
		return false;
	} // end onBlockStartBreak()


    /**
     * Determine what kind of bark was peeled from which log, and how many.
     * precondition: must be some kind of bark, or a type of log with a matching
     * bark.
     * 
     * @param world current World object
     * @param tgt block being broken
     * @param metadata metadata value of block being broken
     * @param fortune fortune factor on tool.
     * @return list of bark drops
     */
    protected ArrayList<ItemStack> getBarkPeeled(World world, Block tgt,
            int metadata, int fortune)
    {
        int hl = toolMaterial.getHarvestLevel();

        // adjust metadata value according to new log or old log...
        if (tgt == Blocks.log2) {
        	metadata = metadata + 4;
        }
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        int count;

        if (fortune > 0)
        {
            count = hl + 3 + world.rand.nextInt(fortune + 2) - 1;
        }
        else
        {
            count = hl + 3;
        }
        for (int i = 0; i < count; i++)
        {
            ret.add(new ItemStack(ModItems.barkItem, 1, metadata));
        }
        return ret;
    } // end getBarkPeeled()	

} // end class ItemSpud
