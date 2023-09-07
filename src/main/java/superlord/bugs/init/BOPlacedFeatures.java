package superlord.bugs.init;

import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

@SuppressWarnings("deprecation")
public class BOPlacedFeatures {

	public static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BuggingOut.MOD_ID);

	public static final RegistryObject<PlacedFeature> TERMITE_MUSHROOMS = REGISTER.register("placed_termite_mushrooms", () -> new PlacedFeature(BOConfiguredFeatures.TERMITE_MUSHROOMS.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> PLACED_GIANT_TERMITE_MUSHROOMS = REGISTER.register("placed_giant_termite_mushroom", () -> new PlacedFeature(BOConfiguredFeatures.HUGE_TERMITE_MUSHROOM.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> FERROUS_TERMOSTONE = REGISTER.register("placed_ferrous_termostone", () -> new PlacedFeature(BOConfiguredFeatures.FERROUS_TERMOSTONE.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> POROUS_TERMOSTONE = REGISTER.register("placed_porous_termostone", () -> new PlacedFeature(BOConfiguredFeatures.POROUS_TERMOSTONE.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("placed_termite_mushroom_mycelium", () -> new PlacedFeature(BOConfiguredFeatures.TERMITE_MUSHROOM_MYCELIUM.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> CRUMBLY_TERMOSTONE = REGISTER.register("placed_crumbly_termostone", () -> new PlacedFeature(BOConfiguredFeatures.CRUMBLY_TERMOSTONE.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMOSTONE_PILLAR = REGISTER.register("placed_termostone_pillar", () -> new PlacedFeature(BOConfiguredFeatures.TERMOSTONE_PILLAR.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> COMMON_TERMOSTONE_PILLAR = REGISTER.register("placed_common_termostone_pillar", () -> new PlacedFeature(BOConfiguredFeatures.TERMOSTONE_PILLAR.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(20), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> INFESTED_POROUS_TERMOSTONE = REGISTER.register("placed_infested_porous_termostone", () -> new PlacedFeature(BOConfiguredFeatures.INFESTED_POROUS_TERMOSTONE.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> MYCELIUM_ROCK = REGISTER.register("placed_mycelium_rock", () -> new PlacedFeature(BOConfiguredFeatures.MYCELIUM_ROCK.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMOSTONE_ROCK = REGISTER.register("placed_termostone_rock", () -> new PlacedFeature(BOConfiguredFeatures.TERMOSTONE_ROCK.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMITE_MYCELIUM_CEILING_BLOB = REGISTER.register("placed_termite_mycelium_ceiling_blob", () -> new PlacedFeature(BOConfiguredFeatures.TERMITE_MYCELIUM_CEILING_BLOB.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMOSTONE_CEILING_BLOB = REGISTER.register("placed_termostone_ceiling_blob", () -> new PlacedFeature(BOConfiguredFeatures.TERMOSTONE_CEILING_BLOB.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> POROUS_TERMOSTONE_CEILING_BLOB = REGISTER.register("placed_porous_termostone_ceiling_blob", () -> new PlacedFeature(BOConfiguredFeatures.POROUS_TERMOSTONE_CEILING_BLOB.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> TERMOSTONE_MOUND = REGISTER.register("placed_termostone_mound", () -> new PlacedFeature(BOConfiguredFeatures.TERMOSTONE_MOUND.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> CRUMBLY_TERMOSTONE_MOUND = REGISTER.register("placed_crumbly_termostone_mound", () -> new PlacedFeature(BOConfiguredFeatures.CRUMBLY_TERMOSTONE_MOUND.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> GLOWWORM_HOLE = REGISTER.register("placed_glowworm_hole", () -> new PlacedFeature(BOConfiguredFeatures.GLOWWORM_HOLE.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome())));

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
