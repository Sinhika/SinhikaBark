package sinhika.bark;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import sinhika.bark.blocks.BlockBark;
import sinhika.bark.items.ItemBark;
import sinhika.bark.proxy.CommonProxy;
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
    public static Bark instance;
	
	/** declare blocks */
	public static Block barkBlock;
	
	/** declare items */
	public static Item barkItem;
	
    /** custom creative-mode tab object */
    public static CreativeTabs customTabSpices;
    
    /** Says where the client and server 'proxy' code is loaded. */
    @SidedProxy(clientSide = "sinhika.bark.proxy.ClientProxy", serverSide = "sinhika.bark.proxy.CommonProxy")
    public static CommonProxy proxy;

    /**
     * preInit phase actions go here, such as reading config files and setting
     * up logger.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // initialize configurables

    	customTabSpices = new SpiceTab();
    	
    	// init blocks
    	barkBlock = new BlockBark();
    	GameRegistry.registerBlock(barkBlock, barkBlock.getUnlocalizedName().substring(5));
    	
        // init items
    	barkItem = new ItemBark();
    	GameRegistry.registerItem(barkItem, barkItem.getUnlocalizedName().substring(5));
    	// init recipes


        // register entities

    } // end preInit()

    /**
     * Load phase actions go here, such as creating items & blocks, adding
     * recipes, etc.
     */
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	SpiceTab.init(new ItemStack(barkItem, 1, 3).getItem());
    	
        // register handlers
    } // end load()

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
    
    
} // end class