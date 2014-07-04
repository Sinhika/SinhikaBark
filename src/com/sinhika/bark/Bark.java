package com.sinhika.bark;

import com.sinhika.bark.blocks.BlockBark;
import com.sinhika.bark.items.BarkItemBlock;
import com.sinhika.bark.items.ItemBark;
import com.sinhika.bark.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Module Sinhika's Bark main class.
 * 
 * @author Sinhika (sinhika@republicofnewhome.org)
 * 
 */
@Mod(modid = Bark.MODID, name = Bark.NAME, version = Bark.VERSION)
public class Bark
{
	/** mod constants */
	public static final String MODID = "sinhikabark";
	public static final String NAME = "Sinhika's Bark";
	public static final String VERSION = "1.7.2-0.01 (build @BUILD_NUMBER@";

	/** The instance of your mod that Forge uses. */
    @Instance(Bark.MODID)
    public static Bark instance = new Bark();
	
	/** declare blocks */
	public static Block barkBlock;
	
	/** declare items */
	public static Item barkItem;
	
    /** custom creative-mode tab object */
    public static CreativeTabs customTabSpices;
    
    /** Says where the client and server 'proxy' code is loaded. */
    @SidedProxy(clientSide = "com.sinhika.bark.proxy.ClientProxy", serverSide = "com.sinhika.bark.proxy.CommonProxy")
    public static CommonProxy proxy;

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Bark.proxy.preInit(event);
    	
      	customTabSpices = new SpiceTab();
    	
    	// init blocks
    	barkBlock = new BlockBark();
    	GameRegistry.registerBlock(barkBlock, BarkItemBlock.class, Bark.MODID + "_barkblock");
    	
        // init items
    	barkItem = new ItemBark();
    	GameRegistry.registerItem(barkItem, barkItem.getUnlocalizedName().substring(5));
  
    } // end preInit()

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes.
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Bark.proxy.init(event);
    	SpiceTab.init(new ItemStack(barkItem, 1, 3).getItem());
    	
    } // end load()

   
    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	Bark.proxy.postInit(event);
    }
    
    
} // end class Bark