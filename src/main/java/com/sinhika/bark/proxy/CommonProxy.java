package com.sinhika.bark.proxy;

import com.sinhika.bark.blocks.ModBlocks;
import com.sinhika.bark.crafting.ModCrafting;
import com.sinhika.bark.entities.ModEntities;
import com.sinhika.bark.items.ModItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e) {
        
    	ModItems.init();
    	ModBlocks.init();
    	ModEntities.init();
	}

	public void init(FMLInitializationEvent e) {
    	ModCrafting.init();
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
	
    public void registerRenderers()
    {
    	// does nothing server-side!
    }

} // end class CommonProxy
