package com.sinhika.bark.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent e) {

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
