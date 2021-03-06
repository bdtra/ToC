//<editor-fold desc="Package">
package com.gmail.bmdetra;
//</editor-fold>

//<editor-fold desc="Imports">
import com.gmail.bmdetra.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
//</editor-fold>

//<editor-fold desc="The value here should match an entry in the META-INF/mods.toml file">
@Mod("tomesofcreation")
//</editor-fold>

public class TomesOfCreation
{
    //<editor-fold desc="Directly reference a log4j logger.">
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tomesofcreation";
    public static TomesOfCreation instance;
    //</editor-fold>

    //<editor-fold desc="Constructor and registers">
    public TomesOfCreation() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        eventBus.addListener(this::setup);

        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);

        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);

        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);
        instance = this;
        // Allows this to be used as an event bus subscriber
        MinecraftForge.EVENT_BUS.register(this);
    }
    //</editor-fold>

    //<editor-fold desc="setup">
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    //</editor-fold>

    //<editor-fold desc="client side stuff">
    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
    //</editor-fold>

    //<editor-fold desc="IMC">
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("tomesofcreation", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    //</editor-fold>

    //<editor-fold desc="You can use SubscribeEvent and let the Event Bus discover methods to call">
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    //</editor-fold>

    public static class TomesOfCreationItemGroup extends ItemGroup
    {
        public static final TomesOfCreationItemGroup instance = new TomesOfCreationItemGroup(ItemGroup.GROUPS.length, "Tomes Of Creation");
        private TomesOfCreationItemGroup(int index, String label)
        {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.empty_tome);
        }
    }

}