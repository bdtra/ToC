package com.gmail.bmdetra.init;

import com.gmail.bmdetra.TomesOfCreation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TomesOfCreation.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TomesOfCreation.MOD_ID)
public class ItemInit
{
    public static final Item empty_tome = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {

    }
}
