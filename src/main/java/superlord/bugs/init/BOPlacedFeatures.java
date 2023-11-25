package superlord.bugs.init;

import java.util.List;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import superlord.bugs.BuggingOut;

@SuppressWarnings("deprecation")
public class BOPlacedFeatures {
	
	public static void init() {}
	
	public static final ResourceKey<PlacedFeature> TERMITE_MUSHROOMS = registerPlacedFeature("placed_termite_mushrooms");
	public static final ResourceKey<PlacedFeature> PLACED_GIANT_TERMITE_MUSHROOMS = registerPlacedFeature("placed_giant_termite_mushroom");
	public static final ResourceKey<PlacedFeature> FERROUS_TERMOSTONE = registerPlacedFeature("placed_ferrous_termostone");
	public static final ResourceKey<PlacedFeature> POROUS_TERMOSTONE = registerPlacedFeature("placed_porous_termostone");
	public static final ResourceKey<PlacedFeature> TERMITE_MUSHROOM_MYCELIUM = registerPlacedFeature("placed_termite_mushroom_mycelium");
	public static final ResourceKey<PlacedFeature> MYCELIUM_ROCK = registerPlacedFeature("placed_mycelium_rock");
	public static final ResourceKey<PlacedFeature> TERMOSTONE_ROCK = registerPlacedFeature("placed_termostone_rock");
	public static final ResourceKey<PlacedFeature> CRUMBLY_TERMOSTONE = registerPlacedFeature("placed_crumbly_termostone");
	public static final ResourceKey<PlacedFeature> TERMOSTONE_PILLAR = registerPlacedFeature("placed_termostone_pillar");
	public static final ResourceKey<PlacedFeature> COMMON_TERMOSTONE_PILLAR = registerPlacedFeature("placed_common_termostone_pillar");
	public static final ResourceKey<PlacedFeature> INFESTED_POROUS_TERMOSTONE = registerPlacedFeature("placed_infested_porous_termostone");
	public static final ResourceKey<PlacedFeature> TERMITE_MYCELIUM_CEILING_BLOB = registerPlacedFeature("placed_termite_mycelium_ceiling_blob");
	public static final ResourceKey<PlacedFeature> TERMOSTONE_CEILING_BLOB = registerPlacedFeature("placed_termostone_ceiling_blob");
	public static final ResourceKey<PlacedFeature> POROUS_TERMOSTONE_CEILING_BLOB = registerPlacedFeature("placed_porous_termostone_ceiling_blob");
	public static final ResourceKey<PlacedFeature> TERMOSTONE_MOUND = registerPlacedFeature("placed_termostone_mound");
	public static final ResourceKey<PlacedFeature> CRUMBLY_TERMOSTONE_MOUND = registerPlacedFeature("placed_crumbly_termostone_mound");
	public static final ResourceKey<PlacedFeature> GLOWWORM_HOLE = registerPlacedFeature("placed_glowworm_hole");
	
	public static final ResourceKey<PlacedFeature> MULCH = registerPlacedFeature("placed_mulch");
	public static final ResourceKey<PlacedFeature> STRIPPED_ROTTEN_WOOD = registerPlacedFeature("placed_stripped_rotten_wood");
	public static final ResourceKey<PlacedFeature> ROTTEN_CHARCOAL = registerPlacedFeature("placed_rotten_charcoal");
	public static final ResourceKey<PlacedFeature> MOSS = registerPlacedFeature("placed_moss");
	public static final ResourceKey<PlacedFeature> FUZZY_MOSS = registerPlacedFeature("placed_fuzzy_moss");
	public static final ResourceKey<PlacedFeature> FUZZY_WALL_MOSS = registerPlacedFeature("placed_fuzzy_wall_moss");
	public static final ResourceKey<PlacedFeature> FUZZY_CEILING_MOSS = registerPlacedFeature("placed_fuzzy_ceiling_moss");
	public static final ResourceKey<PlacedFeature> COMMON_SPLINTERS = registerPlacedFeature("placed_common_splinters");
	public static final ResourceKey<PlacedFeature> SPLINTERS = registerPlacedFeature("placed_splinters");
	public static final ResourceKey<PlacedFeature> RARE_SPLINTERS = registerPlacedFeature("placed_rare_splinters");
	public static final ResourceKey<PlacedFeature> SHELF_MUSHROOMS = registerPlacedFeature("placed_shelf_mushrooms");
	
	public static void bootstrap(BootstapContext<PlacedFeature> bootstapContext) {
		HolderGetter<ConfiguredFeature<?, ?>> holderGetter = bootstapContext.lookup(Registries.CONFIGURED_FEATURE);
		PlacementUtils.register(bootstapContext, TERMITE_MUSHROOMS, holderGetter.getOrThrow(BOConfiguredFeatures.TERMITE_MUSHROOMS), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, PLACED_GIANT_TERMITE_MUSHROOMS, holderGetter.getOrThrow(BOConfiguredFeatures.HUGE_TERMITE_MUSHROOM), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FERROUS_TERMOSTONE, holderGetter.getOrThrow(BOConfiguredFeatures.FERROUS_TERMOSTONE), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, POROUS_TERMOSTONE, holderGetter.getOrThrow(BOConfiguredFeatures.POROUS_TERMOSTONE), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMITE_MUSHROOM_MYCELIUM, holderGetter.getOrThrow(BOConfiguredFeatures.TERMITE_MUSHROOM_MYCELIUM), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, MYCELIUM_ROCK, holderGetter.getOrThrow(BOConfiguredFeatures.MYCELIUM_ROCK), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMOSTONE_ROCK, holderGetter.getOrThrow(BOConfiguredFeatures.TERMOSTONE_ROCK), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CRUMBLY_TERMOSTONE, holderGetter.getOrThrow(BOConfiguredFeatures.CRUMBLY_TERMOSTONE), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMOSTONE_PILLAR, holderGetter.getOrThrow(BOConfiguredFeatures.TERMOSTONE_PILLAR), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, COMMON_TERMOSTONE_PILLAR, holderGetter.getOrThrow(BOConfiguredFeatures.TERMOSTONE_PILLAR), List.of(CountOnEveryLayerPlacement.of(20), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, INFESTED_POROUS_TERMOSTONE, holderGetter.getOrThrow(BOConfiguredFeatures.INFESTED_POROUS_TERMOSTONE), List.of(CountOnEveryLayerPlacement.of(20), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMITE_MYCELIUM_CEILING_BLOB, holderGetter.getOrThrow(BOConfiguredFeatures.TERMITE_MYCELIUM_CEILING_BLOB), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMOSTONE_CEILING_BLOB, holderGetter.getOrThrow(BOConfiguredFeatures.TERMOSTONE_CEILING_BLOB), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, POROUS_TERMOSTONE_CEILING_BLOB, holderGetter.getOrThrow(BOConfiguredFeatures.POROUS_TERMOSTONE_CEILING_BLOB), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, TERMOSTONE_MOUND, holderGetter.getOrThrow(BOConfiguredFeatures.TERMOSTONE_MOUND), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CRUMBLY_TERMOSTONE_MOUND, holderGetter.getOrThrow(BOConfiguredFeatures.CRUMBLY_TERMOSTONE_MOUND), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, GLOWWORM_HOLE, holderGetter.getOrThrow(BOConfiguredFeatures.GLOWWORM_HOLE), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
	
		PlacementUtils.register(bootstapContext, MULCH, holderGetter.getOrThrow(BOConfiguredFeatures.MULCH), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, STRIPPED_ROTTEN_WOOD, holderGetter.getOrThrow(BOConfiguredFeatures.STRIPPED_ROTTEN_WOOD), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, MOSS, holderGetter.getOrThrow(BOConfiguredFeatures.MOSS), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, ROTTEN_CHARCOAL, holderGetter.getOrThrow(BOConfiguredFeatures.ROTTEN_CHARCOAL), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FUZZY_MOSS, holderGetter.getOrThrow(BOConfiguredFeatures.FUZZY_MOSS), List.of(CountOnEveryLayerPlacement.of(100), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FUZZY_WALL_MOSS, holderGetter.getOrThrow(BOConfiguredFeatures.FUZZY_WALL_MOSS), List.of(CountOnEveryLayerPlacement.of(100), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FUZZY_CEILING_MOSS, holderGetter.getOrThrow(BOConfiguredFeatures.FUZZY_CEILING_MOSS), List.of(CountOnEveryLayerPlacement.of(100), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, COMMON_SPLINTERS, holderGetter.getOrThrow(BOConfiguredFeatures.SPLINTERS), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SPLINTERS, holderGetter.getOrThrow(BOConfiguredFeatures.SPLINTERS), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, RARE_SPLINTERS, holderGetter.getOrThrow(BOConfiguredFeatures.SPLINTERS), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SHELF_MUSHROOMS, holderGetter.getOrThrow(BOConfiguredFeatures.SHELF_MUSHROOMS), List.of(CountOnEveryLayerPlacement.of(50), BiomeFilter.biome()));
	}
	
	public static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BuggingOut.MOD_ID, id));
	}
	
	public static List<PlacementModifier> worldSurfaceSquaredWithCount(int p_195475_) {
		return List.of(CountPlacement.of(p_195475_), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	@SuppressWarnings("unused")
	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

}
