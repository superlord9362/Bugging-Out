package superlord.bugs.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.bugs.BuggingOut;
import superlord.bugs.config.BuggingOutConfig;

public class BOBiomes {
		
	public static final ResourceKey<Biome> FUNGAL_GARDENS = register("fungal_gardens");
	public static final ResourceKey<Biome> INFESTED_TUNNELS = register("infested_tunnels");
	public static final ResourceKey<Biome> TERMITE_GALLERY = register("termite_gallery");
	public static final ResourceKey<Biome> TERMITE_TUNNELS = register("termite_tunnels");

	public static final ResourceKey<Biome> MOLDY_GROTTO = register("moldy_grotto");
	public static final ResourceKey<Biome> ROTTEN_PASSAGES = register("rotten_passages");
	public static final ResourceKey<Biome> MOSSY_REGROWTH = register("mossy_regrowth");
	public static final ResourceKey<Biome> BEETLE_NEST = register("beetle_nest");

	public static final ResourceKey<Biome> GRASSY_MEADOWS = register("grassy_meadows");
	public static final ResourceKey<Biome> FLOWER_MEADOWS = register("flower_meadows");
	public static final ResourceKey<Biome> DIRTY_TUNNELS = register("dirt_tunnels");

	public static void bootstrap(BootstapContext<Biome> bootstapContext) {
		HolderGetter<PlacedFeature> holderGetter = bootstapContext.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
		bootstapContext.register(FUNGAL_GARDENS, BOBiomes.fungalGardens(holderGetter, holdergetter1));
		bootstapContext.register(INFESTED_TUNNELS, BOBiomes.infestedTunnels(holderGetter, holdergetter1));
		bootstapContext.register(TERMITE_GALLERY, BOBiomes.termiteGallery(holderGetter, holdergetter1));
		bootstapContext.register(TERMITE_TUNNELS, BOBiomes.termiteTunnels(holderGetter, holdergetter1));
		bootstapContext.register(MOLDY_GROTTO, BOBiomes.moldyGrotto(holderGetter, holdergetter1));
		bootstapContext.register(MOSSY_REGROWTH, BOBiomes.mossyRegrowth(holderGetter, holdergetter1));
		bootstapContext.register(BEETLE_NEST, BOBiomes.beetleNest(holderGetter, holdergetter1));
		bootstapContext.register(ROTTEN_PASSAGES, BOBiomes.rottenPassages(holderGetter, holdergetter1));
		bootstapContext.register(GRASSY_MEADOWS, BOBiomes.grassyMeadows(holderGetter, holdergetter1));
		bootstapContext.register(FLOWER_MEADOWS, BOBiomes.flowerMeadows(holderGetter, holdergetter1));
		bootstapContext.register(DIRTY_TUNNELS, BOBiomes.dirtyTunnels(holderGetter, holdergetter1));
	}
	
	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(BuggingOut.MOD_ID, name));
	}
	
	private static Biome biome(int waterColor, int waterFogColor, int skyColor, int fogColor, boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(precipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	private static Biome dustyBiome(int waterColor, int waterFogColor, int skyColor, int fogColor, boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(precipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientParticle(new AmbientParticleSettings(BOParticles.TERMOSTONE_DUST.get(), 0.118093334F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	private static Biome wetBiome(int waterColor, int waterFogColor, int skyColor, int fogColor, boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(precipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientParticle(new AmbientParticleSettings(ParticleTypes.FALLING_WATER, 0.0295233335F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	public static Biome infestedTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.FERROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.CRUMBLY_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.COMMON_TERMOSTONE_PILLAR);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.GLOWWORM_HOLE);
		if (BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormInfestedTunnelsSpawnWeight, 1, 1));
		if (BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerInfestedTunnelsSpawnWeight, 2, 4));
		if (BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphInfestedTunnelsSpawnWeight, 1, 5));
		if (BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierInfestedTunnelsSpawnWeight, 1, 2));
		if (BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeInfestedTunnelsSpawnWeight, 1, 1));
		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome fungalGardens(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOM_MYCELIUM);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MYCELIUM_ROCK);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMITE_MYCELIUM_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.INFESTED_POROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.PLACED_GIANT_TERMITE_MUSHROOMS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOMS);
		if (BuggingOutConfig.glowwormFungalGardenSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormFungalGardenSpawnWeight, 1, 1));
		if (BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerFungalGardenSpawnWeight, 2, 4));
		if (BuggingOutConfig.termiteNymphFungalGardenSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphFungalGardenSpawnWeight, 1, 5));
		if (BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierFungalGardenSpawnWeight, 1, 2));
		if (BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeFungalGardenSpawnWeight, 1, 1));

		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome termiteGallery(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_ROCK);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.CRUMBLY_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.INFESTED_POROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOMS);
		if (BuggingOutConfig.glowwormTermiteGallerySpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteGallerySpawnWeight, 1, 1));
		if (BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteGallerySpawnWeight, 2, 4));
		if (BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteGallerySpawnWeight, 1, 5));
		if (BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteGallerySpawnWeight, 1, 2));
		if (BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteGallerySpawnWeight, 1, 1));
		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome termiteTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.FERROUS_TERMOSTONE);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.COMMON_TERMOSTONE_PILLAR);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
		if (BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.GLOWWORM.get(), BuggingOutConfig.glowwormTermiteTunnelsSpawnWeight, 1, 1));
		if (BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_WORKER.get(), BuggingOutConfig.termiteWorkerTermiteTunnelsSpawnWeight, 2, 4));
		if (BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_NYMPH.get(), BuggingOutConfig.termiteNymphTermiteTunnelsSpawnWeight, 1, 5));
		if (BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_SOLDIER.get(), BuggingOutConfig.termiteSoldierTermiteTunnelsSpawnWeight, 1, 2));
		if (BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.TERMITE_KAMIKAZE.get(), BuggingOutConfig.termiteKamakazeTermiteTunnelsSpawnWeight, 1, 1));
		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome moldyGrotto(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.SPLINTERS);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MULCH);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.STRIPPED_ROTTEN_WOOD);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.ROTTEN_CHARCOAL);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MOLDY_WALL);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MOLD_STALKS);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MOLD_SPORE_SPREADER);
		if (BuggingOutConfig.springtailMoldyGrottoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailMoldyGrottoSpawnWeight, 2, 4));
		if (BuggingOutConfig.barkBeetleMoldyGrottoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleMoldyGrottoSpawnWeight, 3, 5));
		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome rottenPassages(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.COMMON_SPLINTERS);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MULCH);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.STRIPPED_ROTTEN_WOOD);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.ROTTEN_CHARCOAL);
		if (BuggingOutConfig.springtailRottenPassagesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailRottenPassagesSpawnWeight, 2, 4));
		if (BuggingOutConfig.barkBeetleRottenPassagesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleRottenPassagesSpawnWeight, 3, 5));
		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome mossyRegrowth(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.RARE_SPLINTERS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.FUZZY_MOSS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.FUZZY_WALL_MOSS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.FUZZY_CEILING_MOSS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.SHELF_MUSHROOMS);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.LARGE_SHELF_MUSHROOMS);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MULCH);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.STRIPPED_ROTTEN_WOOD);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.ROTTEN_CHARCOAL);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MOSS);
		if (BuggingOutConfig.springtailMossyRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailMossyRegrowthSpawnWeight, 2, 4));
		if (BuggingOutConfig.barkBeetleMossyRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleMossyRegrowthSpawnWeight, 3, 5));
		return wetBiome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome beetleNest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MULCH);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.STRIPPED_ROTTEN_WOOD);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.ROTTEN_CHARCOAL);
		if (BuggingOutConfig.springtailBeetleNestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.SPRINGTAIL.get(), BuggingOutConfig.springtailBeetleNestSpawnWeight, 2, 4));
		if (BuggingOutConfig.barkBeetleBeetleNestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(BOEntities.BARK_BEETLE.get(), BuggingOutConfig.barkBeetleBeetleNestSpawnWeight, 3, 5));
		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome grassyMeadows(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome flowerMeadows(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
	public static Biome dirtyTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
	}
	
}
