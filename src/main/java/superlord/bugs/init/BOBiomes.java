package superlord.bugs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import superlord.bugs.BuggingOut;

public class BOBiomes {
		
	public static final ResourceKey<Biome> FUNGAL_GARDENS = register("fungal_gardens");
	public static final ResourceKey<Biome> INFESTED_TUNNELS = register("infested_tunnels");
	public static final ResourceKey<Biome> TERMITE_GALLERY = register("termite_gallery");
	public static final ResourceKey<Biome> TERMITE_TUNNELS = register("termite_tunnels");

	public static final ResourceKey<Biome> MOLDY_ROTTEN_LOG = register("moldy_rotten_log");
	public static final ResourceKey<Biome> HOLLOWED_ROTTEN_LOG = register("hollowed_rotten_log");
	public static final ResourceKey<Biome> DAMP_ROTTEN_LOG = register("damp_rotten_log");
	public static final ResourceKey<Biome> BEETLE_INFESTED_LOG = register("beetle_infested_log");

	public static final ResourceKey<Biome> GRASSY_MEADOWS = register("grassy_meadows");
	public static final ResourceKey<Biome> FLOWER_MEADOWS = register("flower_meadows");
	public static final ResourceKey<Biome> DIRTY_TUNNELS = register("dirt_tunnels");

//	public static void bootstrap(BootstapContext<Biome> bootstapContext) {
//		HolderGetter<PlacedFeature> holderGetter = bootstapContext.lookup(Registries.PLACED_FEATURE);
//		HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
//		bootstapContext.register(FUNGAL_GARDENS, BOBiomes.fungalGardens(holderGetter, holdergetter1));
//		bootstapContext.register(INFESTED_TUNNELS, BOBiomes.infestedTunnels(holderGetter, holdergetter1));
//		bootstapContext.register(TERMITE_GALLERY, BOBiomes.termiteGallery(holderGetter, holdergetter1));
//		bootstapContext.register(TERMITE_TUNNELS, BOBiomes.termiteTunnels(holderGetter, holdergetter1));
//		bootstapContext.register(MOLDY_ROTTEN_LOG, BOBiomes.moldyRottenLog(holderGetter, holdergetter1));
//		bootstapContext.register(DAMP_ROTTEN_LOG, BOBiomes.dampRottenLog(holderGetter, holdergetter1));
//		bootstapContext.register(BEETLE_INFESTED_LOG, BOBiomes.beetleInfestedLog(holderGetter, holdergetter1));
//		bootstapContext.register(HOLLOWED_ROTTEN_LOG, BOBiomes.hollowedRottenLog(holderGetter, holdergetter1));
//		bootstapContext.register(GRASSY_MEADOWS, BOBiomes.grassyMeadows(holderGetter, holdergetter1));
//		bootstapContext.register(FLOWER_MEADOWS, BOBiomes.flowerMeadows(holderGetter, holdergetter1));
//		bootstapContext.register(DIRTY_TUNNELS, BOBiomes.dirtyTunnels(holderGetter, holdergetter1));
//	}
//	
	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(BuggingOut.MOD_ID, name));
	}
//	
//	private static Biome biome(int waterColor, int waterFogColor, int skyColor, int fogColor, boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
//		return (new Biome.BiomeBuilder())
//				.hasPrecipitation(precipitation)
//				.temperature(temperature)
//				.downfall(downfall)
//				.specialEffects((new BiomeSpecialEffects.Builder())
//						.waterColor(waterColor)
//						.waterFogColor(waterFogColor)
//						.fogColor(fogColor)
//						.skyColor(skyColor)
//						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
//						.build())
//				.mobSpawnSettings(spawnBuilder.build())
//				.generationSettings(biomeBuilder.build())
//				.build();
//	}
//	
//	private static Biome dustyBiome(int waterColor, int waterFogColor, int skyColor, int fogColor, boolean precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
//		return (new Biome.BiomeBuilder())
//				.hasPrecipitation(precipitation)
//				.temperature(temperature)
//				.downfall(downfall)
//				.specialEffects((new BiomeSpecialEffects.Builder())
//						.waterColor(waterColor)
//						.waterFogColor(waterFogColor)
//						.fogColor(fogColor)
//						.skyColor(skyColor)
//						.ambientParticle(new AmbientParticleSettings(BOParticles.TERMOSTONE_DUST.get(), 0.118093334F))
//						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
//						.build())
//				.mobSpawnSettings(spawnBuilder.build())
//				.generationSettings(biomeBuilder.build())
//				.build();
//	}
//	
//	public static Biome fungalGardens(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.FERROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.CRUMBLY_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.COMMON_TERMOSTONE_PILLAR);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.GLOWWORM_HOLE);
//		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome infestedTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOM_MYCELIUM);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.MYCELIUM_ROCK);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMITE_MYCELIUM_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.INFESTED_POROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.PLACED_GIANT_TERMITE_MUSHROOMS);
//		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOMS);
//		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome termiteGallery(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_ROCK);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.CRUMBLY_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.POROUS_TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.INFESTED_POROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOMS);
//		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome termiteTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.FERROUS_TERMOSTONE);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.COMMON_TERMOSTONE_PILLAR);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_CEILING_BLOB);
//		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BOPlacedFeatures.TERMOSTONE_PILLAR);
//		return dustyBiome(7372597, 5267523, 7357740, 10051133, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome moldyRottenLog(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome hollowedRottenLog(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome dampRottenLog(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome beetleInfestedLog(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(6836531, 5324584, 2905980, 2509931, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome grassyMeadows(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome flowerMeadows(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
//	public static Biome dirtyTunnels(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
//		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
//		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
//		return biome(2710990, 2182312, 2996932, 2132366, false, 1, 0, spawnSettings, biomeFeatures);
//	}
//	
}
