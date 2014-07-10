package com.sinhika.bark.items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;
import com.sinhika.bark.Bark;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class ModItems {
	private static final int DEFAULT_TYPE_SIZE = 5;
	public static Item barkItem;
	public static ArrayList<ItemSpud> spudItems;
	public static Item canoeItem;
	
	private static final HashSet<String> existingToolTextures = 
			 Sets.newHashSet("wood", "stone", "gold", "iron", "diamond", "adamantium", "bronze", "copper",
						   "mythril", "onyx", "sinisite", "thyrium", "tin");
	
	public static final void init() 
	{
		// create barks
    	barkItem = new ItemBark();
    	GameRegistry.registerItem(barkItem, barkItem.getUnlocalizedName().substring(5));
    	
    	// register in ore dictionary
    	for (int i= 0; i < ItemBark.names.length; i++) {
    		ItemBark.setOredict_name(ItemBark.names[i], i);
    		OreDictionary.registerOre(ItemBark.oredict_names[i], 
    								  new ItemStack(barkItem, 1, i));
    		
    		if (ItemBark.names[i].equals("cinnamon"))   // to be compatible with Pam's HarvestCraft cinnamon.
    		{
    			OreDictionary.registerOre("cropCinnamon", new ItemStack(barkItem, 1, i));
    		} // end-if
    	} // end-for
    	
    	// create spuds
    	spudItems = new ArrayList<ItemSpud>(existingToolTextures.size());
    	
    	for (Item.ToolMaterial tm: Item.ToolMaterial.values()) 
    	{
    		// only create tools if a texture exists--
    		String textureName = ItemSpud.createToolMaterialName(tm) + "_spud";
    		if (existingToolTextures.contains(textureName)) 
    		{
    			ItemSpud spud = new ItemSpud(tm);
    			spud.setTextureName(Bark.MODID + ":" + textureName);
    			spudItems.add(spud);
    			GameRegistry.registerItem(spud, spud.getUnlocalizedName().substring(5));
    		} // end-if
    	} // end-for
    	
    	// create canoe
    	canoeItem = new ItemCanoe();
    	GameRegistry.registerItem(canoeItem, canoeItem.getUnlocalizedName().substring(5));
	} // end init()
} // end class ModItems
