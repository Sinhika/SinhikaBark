package com.sinhika.bark.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.sinhika.bark.blocks.BlockBark;
import com.sinhika.bark.blocks.ModBlocks;
import com.sinhika.bark.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModCrafting {
	
    private static String[] spudPattern = new String[] { " #X", " # ", " # " };
    private static String[] blockPattern = new String[] { "XXX", "XXX", "XXX" };
	
	public static final void init() {
		
		// split bark bundles into 9 barks
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.barkItem, 9, i), 
											new ItemStack(ModBlocks.barkBlock, 1, i));
		} // end-for
		
		// bundle up barks into bark bundles.
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.barkBlock, 1, i),
				new Object [] { blockPattern, 'X', new ItemStack(ModItems.barkItem,1,i)});
		}
		
		// smelt bark bundles
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.barkBlock, 1, i),
					new ItemStack(Items.coal, 1, 1), 0.1F);
		}
		
		// craft bark spuds
		for (int i=0; i < ModItems.spudItems.size(); i++) {
			GameRegistry.addShapedRecipe(new ItemStack(ModItems.spudItems.get(i)), 
				new Object[] {spudPattern, '#', Items.stick, 'X', 
							  new ItemStack(ModItems.spudItems.get(i).func_150913_i().func_150995_f(),
									  		1, OreDictionary.WILDCARD_VALUE) });
		} // endfor
		
		// peel bark from log using spud
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			int meta;
			ItemStack log;
			if (i < 4) {	// oldLog
				meta = i;
				log = new ItemStack(Blocks.log, 1, meta);
			}
			else // if (i >= 4 && i < 6) 
			{ // new log
				meta = i - 4;
				log  = new ItemStack(Blocks.log2, 1, meta);
			}
			// TODO else custom mod logs.
			
			for (int j=0; j < ModItems.spudItems.size(); j++) {
				int yield = ModItems.spudItems.get(j).func_150913_i().getHarvestLevel() + 3;
				ItemStack product = new ItemStack(ModItems.barkItem, yield, i);
				GameRegistry.addShapelessRecipe(product, log, 
						new ItemStack(ModItems.spudItems.get(j), 1, OreDictionary.WILDCARD_VALUE));
			} // end-for j
		} // end-for i
			
		
		// **** Specialities ****
		// paper from birch bark
	    GameRegistry.addShapedRecipe( new ItemStack(Items.paper, 3),
	                        new Object[]{ "xxx", 'x', new ItemStack(ModItems.barkItem, 1, 2) });
		
		// birchbark canoe
		GameRegistry.addShapedRecipe( new ItemStack(ModItems.canoeItem), 
				new Object[] {"   ", "xsx", "xxx", 
							  'x', new ItemStack(ModBlocks.barkBlock, 1, 2),
							  's', Items.slime_ball});
		
		// ground cinnamon
		// TODO
	} // end init()
} // end class ModCrafting
