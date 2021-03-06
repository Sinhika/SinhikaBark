package com.sinhika.bark.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.sinhika.bark.blocks.BlockBark;
import com.sinhika.bark.blocks.ModBlocks;
import com.sinhika.bark.items.ItemBark;
import com.sinhika.bark.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModCrafting {
	
    private static String[] spudPattern = new String[] { " #X", " # ", " # " };
    private static String[] blockPattern = new String[] { "XXX", "XXX", "XXX" };
	
	public static final void init() {
		
		// split bark bundles into 9 barks
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addRecipe(
					new ShapelessOreRecipe(new ItemStack(ModItems.barkItem, 9, i), 
										   BlockBark.getOredict_name(i)));
		} // end-for
		
		// bundle up barks into bark bundles.
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addRecipe(
				new ShapedOreRecipe(new ItemStack(ModBlocks.barkBlock, 1, i),
						new Object [] { blockPattern, 'X', ItemBark.oredict_names[i]}));
		}
		
		// smelt bark bundles
		for (int i=0; i < BlockBark.bark_names.length; i++) {
			GameRegistry.addSmelting(new ItemStack(ModBlocks.barkBlock, 1, i),
					new ItemStack(Items.coal, 1, 1), 0.1F);
		}
		
		// craft bark spuds
		for (int i=0; i < ModItems.spudItems.size(); i++) {
			GameRegistry.addRecipe(
				new ShapedOreRecipe(new ItemStack(ModItems.spudItems.get(i)), 
				new Object[] {spudPattern, '#', "stickWood", 
							  'X', 
							  new ItemStack(ModItems.spudItems.get(i).func_150913_i().func_150995_f(),
									  		1, OreDictionary.WILDCARD_VALUE) }));
		} // endfor
		
		// peel bark from log using spud
		// REMOVED DUE TO INFINITE FUEL BUG
			
		
		// **** Specialities ****
		// paper from birch bark
	    GameRegistry.addRecipe( 
	    					new ShapedOreRecipe( new ItemStack(Items.paper, 3),
	                        new Object[]{ "xxx", 'x', "barkBirch" }));
		
		// birchbark canoe
		GameRegistry.addRecipe( new ShapedOreRecipe(
										new ItemStack(ModItems.canoeItem), 
												new Object[] {"   ", "xsx", "xxx", 
												'x', "woodBarkBirch",
												's', "slimeball"}));
		
		// ground cinnamon
		// TODO
	} // end init()
} // end class ModCrafting
