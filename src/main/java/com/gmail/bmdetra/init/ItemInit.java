package com.gmail.bmdetra.init;

import com.gmail.bmdetra.TomesOfCreation;
import com.gmail.bmdetra.objects.items.Ancient_Paper;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TomesOfCreation.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TomesOfCreation.MOD_ID)
public class ItemInit
{
    public static final Item ancient_paper = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Ancient_Paper(new Item.Properties().group(TomesOfCreation.TomesOfCreationItemGroup.instance)).setRegistryName("ancient_paper"));
    }
}
