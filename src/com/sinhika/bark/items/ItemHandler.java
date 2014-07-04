package com.sinhika.bark.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public final class ItemHandler {

	public static Item barkItem;

	public static final void init() {
    	barkItem = new ItemBark();
    	GameRegistry.registerItem(barkItem, barkItem.getUnlocalizedName().substring(5));
		
	}
} // end class ItemHandler
