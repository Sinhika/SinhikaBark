package com.sinhika.bark.items;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() instanceof ItemBark)
        {
            return 100;
        }
        return 0;
    }
}
