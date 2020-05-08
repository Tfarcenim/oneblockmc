package tfar.oneblockmc;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OneBlockMC.MODID)
public class OneBlockMC
{
    // Directly reference a log4j logger.

    public static final String MODID = "oneblockmc";

    private static final Logger LOGGER = LogManager.getLogger();

    @ObjectHolder("oneblockmc:oneblockmc")
    public static Block block;

    @ObjectHolder("oneblockmc:oneblockmc")
    public static TileEntityType<?> tileEntityType;

    public OneBlockMC() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void blocks(final RegistryEvent.Register<Block> e) {
            register(new OneBlockMCBlock(Block.Properties.from(Blocks.SPONGE)),"oneblockmc",e.getRegistry());
        }

        @SubscribeEvent
        public static void items(final RegistryEvent.Register<Item> e) {
            register(new BlockItem(block,new Item.Properties().group(ItemGroup.MISC)),"oneblockmc",e.getRegistry());
        }

        @SubscribeEvent
        public static void tileEntityTypes(final RegistryEvent.Register<TileEntityType<?>> e) {
            register(TileEntityType.Builder.create(() -> new OneBlockMCBlockEntity(tileEntityType)
                    , block).build(null),"oneblockmc",e.getRegistry());
        }
    }

    public static <T extends IForgeRegistryEntry<T>> void register(T obj, String name, IForgeRegistry<T> registry) {
        register(obj, MODID, name, registry);
    }

    public static <T extends IForgeRegistryEntry<T>> void register(T obj, String modid, String name, IForgeRegistry<T> registry) {
        register(obj,new ResourceLocation(modid, name),registry);
    }

    public static <T extends IForgeRegistryEntry<T>> void register(T obj, ResourceLocation location, IForgeRegistry<T> registry) {
        registry.register(obj.setRegistryName(location));
    }
}
