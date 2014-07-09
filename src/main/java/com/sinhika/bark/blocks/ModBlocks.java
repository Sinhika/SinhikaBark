package com.sinhika.bark.blocks;

import com.sinhika.bark.Bark;
import com.sinhika.bark.items.BarkItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class ModBlocks {
	/** declare blocks */
	public static Block barkBlock;
	
	public static final void init() {
    	// init blocks
    	barkBlock = new BlockBark();
    	GameRegistry.registerBlock(barkBlock, BarkItemBlock.class, Bark.MODID + "_barkblock");

    	// register in ore dictionary
    	for (int i= 0; i < BlockBark.bark_names.length; i++) 
    	{
    		BlockBark.setOredict_name(BlockBark.bark_names[i], i);
    		OreDictionary.registerOre(BlockBark.getOredict_name(i), 
    								  new ItemStack(barkBlock, 1, i));
    	}
	} // end init()
} // end class ModBlocks
