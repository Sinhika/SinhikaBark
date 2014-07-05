package com.sinhika.bark.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
		// TODO
		
		// peel bark from log using spud
		// TODO
		
		// **** Specialities ****
		// paper from birch bark
		// TODO
		
		// birchbark canon
		// TODO
		
		// ground cinnamon
		// TODO
	} // end init()
} // end class ModCrafting
