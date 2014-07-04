package com.sinhika.bark.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class ItemHandler {

	public static Item barkItem;

	public static final void init() {
    	barkItem = new ItemBark();
    	GameRegistry.registerItem(barkItem, barkItem.getUnlocalizedName().substring(5));
    	
    	// register in ore dictionary
    	for (int i= 0; i < ItemBark.names.length; i++) {
    		StringBuilder dictName = new StringBuilder();
    		dictName.append("bark");
    		dictName.append(ItemBark.names[i].substring(0,1).toUpperCase());
    		dictName.append(ItemBark.names[i].substring(1));
    		OreDictionary.registerOre(dictName.toString(), new ItemStack(barkItem, 1, i));
    	}
	} // end init()
} // end class ItemHandler
