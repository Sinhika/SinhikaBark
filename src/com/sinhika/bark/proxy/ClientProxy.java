package com.sinhika.bark.proxy;

// import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
//        RenderingRegistry.registerEntityRenderingHandler(EntityCanoe.class, 
//                                                         new RenderCanoe());
    }

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent)
	 */
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
	}

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#init(cpw.mods.fml.common.event.FMLInitializationEvent)
	 */
	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
	}

	/* (non-Javadoc)
	 * @see com.sinhika.bark.proxy.CommonProxy#postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent)
	 */
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}
} // end class
