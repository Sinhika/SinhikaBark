package com.sinhika.bark.entities;

import com.sinhika.bark.Bark;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class ModEntities {
	
	public static final void init() {
		int boatId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityCanoe.class, 
				Bark.MODID + "_entityCanoe", boatId);
		EntityRegistry.registerModEntity(EntityCanoe.class, Bark.MODID + "_entityCanoe", 
				boatId, Bark.instance, 80, 3, true);
	}
} // end class ModEntities
