package com.sinhika.bark.renders;

import com.sinhika.bark.Bark;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;

public class RenderCanoe extends RenderBoat 
{
	
    private static final ResourceLocation textureResource 
    = new ResourceLocation(Bark.MODID, "textures/entity/birch_canoe.png");

	public RenderCanoe() {
		super();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.client.renderer.entity.RenderBoat#getEntityTexture(net.minecraft.entity.item.EntityBoat)
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityBoat par1EntityBoat) {
		return textureResource;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.client.renderer.entity.RenderBoat#getEntityTexture(net.minecraft.entity.Entity)
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return textureResource;
	}

} // end class RenderBoat
