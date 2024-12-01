package superlord.bugs.common.world;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;
import superlord.bugs.BuggingOut;
import superlord.bugs.config.BuggingOutConfig;
import superlord.bugs.init.BOBiomes;
import superlord.bugs.init.BOEntities;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID)
public class TermiteMoundDecorator {
	
	private static ResourceLocation getBiomeName(Holder<Biome> biome) {
        return biome.unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null);
    }
	
	public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (getBiomeName(biome) == BOBiomes.FUNGAL_GARDENS.location()) {
			if (BuggingOutConfig.glowwormFungalGardenSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormFungalGardenSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphFungalGardenSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphFungalGardenSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight, 1, 1));
		}
		if (getBiomeName(biome) == BOBiomes.INFESTED_TUNNELS.location()) {
			if (BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight, 1, 1));
		}
		if (getBiomeName(biome) == BOBiomes.TERMITE_GALLERY.location()) {
			if (BuggingOutConfig.glowwormTermiteGallerySpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteGallerySpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight, 1, 1));
		}
		if (getBiomeName(biome) == BOBiomes.TERMITE_TUNNELS.location()) {
			if (BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight, 1, 1));
			if (BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight, 2, 4));
			if (BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight, 1, 5));
			if (BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight, 1, 2));
			if (BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight, 1, 1));
		}
		if (getBiomeName(biome) == BOBiomes.MOLDY_GROTTO.location()) {
			if (BuggingOutConfig.springtailMoldyGrottoSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailMoldyGrottoSpawnWeight, 2, 4));
			if (BuggingOutConfig.barkBeetleMoldyGrottoSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleMoldyGrottoSpawnWeight, 3, 5));
		}
		if (getBiomeName(biome) == BOBiomes.BEETLE_NEST.location()) {
			if (BuggingOutConfig.springtailBeetleNestSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailBeetleNestSpawnWeight, 2, 4));
			if (BuggingOutConfig.barkBeetleBeetleNestSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleBeetleNestSpawnWeight, 3, 5));
		}
		if (getBiomeName(biome) == BOBiomes.MOSSY_REGROWTH.location()) {
			if (BuggingOutConfig.springtailMossyRegrowthSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailMossyRegrowthSpawnWeight, 2, 4));
			if (BuggingOutConfig.barkBeetleMossyRegrowthSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleMossyRegrowthSpawnWeight, 3, 5));
		}
		if (getBiomeName(biome) == BOBiomes.ROTTEN_PASSAGES.location()) {
			if (BuggingOutConfig.springtailRottenPassagesSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailRottenPassagesSpawnWeight, 2, 4));
			if (BuggingOutConfig.barkBeetleRottenPassagesSpawnWeight != 0) builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleRottenPassagesSpawnWeight, 3, 5));
		}
	}

}
