package com.sinhika.bark.blocks;

import com.sinhika.bark.Bark;
import com.sinhika.bark.items.BarkItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class BlockHandler {
	/** declare blocks */
	public static Block barkBlock;
	
	public static final void init() {
    	// init blocks
    	barkBlock = new BlockBark();
    	GameRegistry.registerBlock(barkBlock, BarkItemBlock.class, Bark.MODID + "_barkblock");

	}
} // end class BlockHandler
