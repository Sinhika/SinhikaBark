package com.sinhika.bark.items;

import java.util.ArrayList;

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
    	}
    	
    	// create spuds
    	spudItems = new ArrayList<ItemSpud>(DEFAULT_TYPE_SIZE);
    	for (Item.ToolMaterial tm: Item.ToolMaterial.values()) {
    		ItemSpud spud = new ItemSpud(tm);
    		spud.setTextureName(Bark.MODID + ":" + spud.myToolMaterialName + "_spud");
    		spudItems.add(spud);
    		GameRegistry.registerItem(spud, spud.getUnlocalizedName().substring(5));
    	}
    	
    	// create canoe
    	canoeItem = new ItemCanoe();
    	GameRegistry.registerItem(canoeItem, canoeItem.getUnlocalizedName().substring(5));
	} // end init()
} // end class ModItems
