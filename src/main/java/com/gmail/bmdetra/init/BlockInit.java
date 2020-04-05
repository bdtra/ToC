package com.gmail.bmdetra.init;

import com.gmail.bmdetra.TomesOfCreation;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TomesOfCreation.MOD_ID)
@Mod.EventBusSubscriber(modid = TomesOfCreation.MOD_ID, bus=Bus.MOD)
public class BlockInit
{
    public static final Block empty_tome = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.GLASS).notSolid().hardnessAndResistance(0.3f,15.0f).sound(SoundType.WOOD)).setRegistryName("empty_tome"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(empty_tome, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("empty_tome"));
    }
}
