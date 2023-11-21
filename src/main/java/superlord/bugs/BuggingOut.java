package superlord.bugs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
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
import superlord.bugs.common.util.ShrinkingSoupTeleporter;
import superlord.bugs.config.BOConfigHolder;
import superlord.bugs.config.BuggingOutConfig;
import superlord.bugs.init.BOBiomeSources;
import superlord.bugs.init.BOBlockEntities;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOChunkGenerators;
import superlord.bugs.init.BODimensions;
import superlord.bugs.init.BOEffects;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOFeatures;
import superlord.bugs.init.BOItems;
import superlord.bugs.init.BOParticles;
import superlord.bugs.init.BOPlacedFeatures;
import superlord.bugs.init.BOTabs;
import superlord.bugs.init.BOWoodTypes;

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
		bus.addListener(this::onModConfigEvent);

		BOBlocks.REGISTER.register(bus);
		BOItems.REGISTER.register(bus);
		BOItems.BUILDING.register(bus);
		BOItems.DECORATIONS.register(bus);
		BOItems.SPAWN_EGGS.register(bus);
		BOItems.MISC.register(bus);
		BOTabs.REGISTER.register(bus);
		BOFeatures.REGISTER.register(bus);
		BOEntities.REGISTER.register(bus);
		BOParticles.REGISTER.register(bus);
		BOBlockEntities.REGISTER.register(bus);
		BOEffects.REGISTER.register(bus);
		BOBiomeSources.REGISTER.register(bus);
		BOChunkGenerators.REGISTER.register(bus);

		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, BOConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, BOConfigHolder.SERVER_SPEC);

		bus.addListener(this::registerEntityAttributes);
		//bus.addListener(this::gatherData);
		
		PROXY.init();
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

	private void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(BOEntities.TERMITE_WORKER.get(), TermiteWorker.createAttributes().build());
		event.put(BOEntities.TERMITE_SOLDIER.get(), TermiteSoldier.createAttributes().build());
		event.put(BOEntities.TERMITE_NYMPH.get(), TermiteNymph.createAttributes().build());
		event.put(BOEntities.TERMITE_KAMIKAZE.get(), TermiteKamikaze.createAttributes().build());
		event.put(BOEntities.GLOWWORM.get(), Glowworm.createAttributes().build());
	}

	@SuppressWarnings("deprecation")
	public void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BOPlacedFeatures.init();
			WoodType.register(BOWoodTypes.ROTTEN);
		});
		SpawnPlacements.register(BOEntities.GLOWWORM.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Glowworm::canGlowwormSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_KAMIKAZE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteKamikaze::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_NYMPH.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteNymph::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_SOLDIER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteSoldier::canTermiteSpawn);
		SpawnPlacements.register(BOEntities.TERMITE_WORKER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TermiteWorker::canTermiteSpawn);
	}

	@SubscribeEvent
	public static void respawnInBugs(PlayerRespawnEvent event) {
		Player player = (Player)event.getEntity();
		ServerLevel serverWorld = (ServerLevel)player.level();
		MinecraftServer minecraftServer = serverWorld.getServer();
		ResourceKey<Level> registryKey = BODimensions.BUGS;
		ServerLevel serverWorld1 = minecraftServer.getLevel(registryKey);
		if (player.getLastDeathLocation().get().dimension() == BODimensions.BUGS) {
			if (serverWorld1 != null && !player.isPassenger()) {
				player.changeDimension(serverWorld1, new ShrinkingSoupTeleporter(serverWorld1));
			}
		}
	}

}
