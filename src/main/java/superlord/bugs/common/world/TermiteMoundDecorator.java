package superlord.bugs.common.world;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.bugs.BuggingOut;
import superlord.bugs.config.BuggingOutConfig;
import superlord.bugs.init.BOEntities;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID)
public class TermiteMoundDecorator {
	
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		String name = event.getName().getPath();
		if (name.equals("fungal_gardens")) {
			if (BuggingOutConfig.glowwormFungalGardenSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormFungalGardenSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphFungalGardenSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphFungalGardenSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight, 1, 1));
		}
		if (name.equals("infested_tunnels")) {
			if (BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight, 1, 1));
		}
		if (name.equals("termite_gallery")) {
			if (BuggingOutConfig.glowwormTermiteGallerySpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteGallerySpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight, 1, 1));
		}
		if (name.equals("termite_tunnels")) {
			if (BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight, 1, 1));
		}
	}

}
