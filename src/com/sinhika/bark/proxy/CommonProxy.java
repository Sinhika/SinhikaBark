package com.sinhika.bark.proxy;

import com.sinhika.bark.blocks.BlockHandler;
import com.sinhika.bark.items.ItemHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e) {
        // init items
    	ItemHandler.init();
    	BlockHandler.init();
	}

	public void init(FMLInitializationEvent e) {

	}

	public void postInit(FMLPostInitializationEvent e) {

	}
	    
    // Client stuff
    public void registerRenderers()
    {
        // Nothing here as the server doesn't render graphics or entities!
    }
} // end class CommonProxy
