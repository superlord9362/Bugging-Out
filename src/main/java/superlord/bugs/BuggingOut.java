package superlord.bugs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.bugs.client.ClientProxy;
import superlord.bugs.common.CommonProxy;
import superlord.bugs.common.entity.Glowworm;
import superlord.bugs.common.entity.TermiteKamikaze;
import superlord.bugs.common.entity.TermiteNymph;
import superlord.bugs.common.entity.TermiteSoldier;
import superlord.bugs.common.entity.TermiteWorker;
import superlord.bugs.config.BOConfigHolder;
import superlord.bugs.config.BuggingOutConfig;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOConfiguredFeatures;
import superlord.bugs.init.BOConfiguredWorldCarvers;
import superlord.bugs.init.BOEffects;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOFeatures;
import superlord.bugs.init.BOItems;
import superlord.bugs.init.BOPlacedFeatures;
import superlord.bugs.init.BOWorldCarvers;

@Mod(BuggingOut.MOD_ID)
@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID)
public class BuggingOut {
	
	public static final String MOD_ID = "bugging_out";
	public static final Logger LOGGER = LogManager.getLogger();

	@SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public BuggingOut() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();

		bus.addListener(this::setup);
		
		BOBlocks.REGISTER.register(bus);
		BOItems.REGISTER.register(bus);
		BOFeatures.REGISTER.register(bus);
		BOConfiguredFeatures.REGISTER.register(bus);
		BOEntities.REGISTER.register(bus);
		BOEffects.REGISTER.register(bus);
		BOPlacedFeatures.REGISTER.register(bus);
		BOWorldCarvers.REGISTER.register(bus);
		BOConfiguredWorldCarvers.REGISTER.register(bus);
		
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, BOConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, BOConfigHolder.SERVER_SPEC);
		
		bus.addListener(this::registerEntityAttributes);
	}
	
	@SubscribeEvent
	public void onModConfigEvent(final ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		if (config.getSpec() == BOConfigHolder.SERVER_SPEC) {
			BuggingOutConfig.bakeServer(config);
		}
		if (config.getSpec() == BOConfigHolder.CLIENT_SPEC) {
			BuggingOutConfig.bakeClient(config);
		}
	}
	
	public final static CreativeModeTab BUGS_BUILDING = new CreativeModeTab("bugs_building_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOBlocks.TERMOSTONE.get());
		}
	};
	
	public final static CreativeModeTab BUGS_DECORATION = new CreativeModeTab("bugs_decoration_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOBlocks.TERMITE_MUSHROOM.get());
		}
	};
	
	public final static CreativeModeTab BUGS_SPAWN_EGGS = new CreativeModeTab("bugs_spawn_eggs_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOItems.TERMITE_WORKER_SPAWN_EGG.get());
		}
	};
	
	public final static CreativeModeTab BUGS_MISC = new CreativeModeTab("bugs_misc_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOItems.TERMITE_MUSHROOM_SPORES.get());
		}
	};
	
	private void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(BOEntities.TERMITE_WORKER.get(), TermiteWorker.createAttributes().build());
		event.put(BOEntities.TERMITE_SOLDIER.get(), TermiteSoldier.createAttributes().build());
		event.put(BOEntities.TERMITE_NYMPH.get(), TermiteNymph.createAttributes().build());
		event.put(BOEntities.TERMITE_KAMIKAZE.get(), TermiteKamikaze.createAttributes().build());
		event.put(BOEntities.GLOWWORM.get(), Glowworm.createAttributes().build());
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(BOEntities.GLOWWORM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Glowworm::canGlowwormSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_KAMIKAZE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteKamikaze::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_NYMPH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteNymph::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_SOLDIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteSoldier::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_WORKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteWorker::canTermiteSpawn);
	}
	
}
