package com.sinhika.bark;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpiceTab extends CreativeTabs
{

    private static Item icon;
    private static boolean did_init = false;

    public SpiceTab()
    {
        super(Bark.MODID);
     }

    public static void init(Item i_for_icon)
    {
        if (!did_init)
        {
            did_init = true;
            icon = i_for_icon;
        }
    }

    @Override
    public Item getTabIconItem()
    {
        return icon;
    }

}
