package com.sinhika.bark.proxy;

// import cpw.mods.fml.client.registry.RenderingRegistry;
import com.sinhika.bark.entities.EntityCanoe;
import com.sinhika.bark.renders.RenderCanoe;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
 
    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCanoe.class, 
                                                         new RenderCanoe());
    }

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent)
	 */
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#init(cpw.mods.fml.common.event.FMLInitializationEvent)
	 */
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent)
	 */
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
} // end class
