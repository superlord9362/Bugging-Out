package superlord.bugs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import superlord.bugs.BuggingOut;

public class BOConfiguredFeatures {

	public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_TERMITE_MUSHROOM = registerConfiguredFeature("configured_huge_termite_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MUSHROOMS = registerConfiguredFeature("configured_termite_mushrooms");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FERROUS_TERMOSTONE = registerConfiguredFeature("configured_ferrous_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE = registerConfiguredFeature("configured_porous_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MUSHROOM_MYCELIUM = registerConfiguredFeature("configured_termite_mushroom_mycelium");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE = registerConfiguredFeature("configured_crumbly_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> INFESTED_POROUS_TERMOSTONE = registerConfiguredFeature("configured_infested_porous_termostone");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWWORM_HOLE = registerConfiguredFeature("configured_glowworm_hole");

	public static final ResourceKey<ConfiguredFeature<?, ?>> MYCELIUM_ROCK = registerConfiguredFeature("configured_mycelium_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_ROCK = registerConfiguredFeature("configured_termostone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MYCELIUM_CEILING_BLOB = registerConfiguredFeature("configured_termite_mycelium_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_CEILING_BLOB = registerConfiguredFeature("configured_termostone_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE_CEILING_BLOB = registerConfiguredFeature("configured_porous_termostone_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_MOUND = registerConfiguredFeature("configured_termostone_mound");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE_MOUND = registerConfiguredFeature("configured_crumbly_termostone_mound");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_PILLAR = registerConfiguredFeature("configured_termostone_pillar");
//
//	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
//		FeatureUtils.register(bootstapContext, HUGE_TERMITE_MUSHROOM, BOFeatures.HUGE_TERMITE_MUSHROOM.get(), new NoneFeatureConfiguration());
//		FeatureUtils.register(bootstapContext, TERMITE_MUSHROOMS, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 4), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 3), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 2), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 1), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 0), 1)), 32));
//		FeatureUtils.register(bootstapContext, FERROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.FERROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3));
//		FeatureUtils.register(bootstapContext, POROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.POROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3));
//		FeatureUtils.register(bootstapContext, TERMITE_MUSHROOM_MYCELIUM, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
//		FeatureUtils.register(bootstapContext, CRUMBLY_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.CRUMBLY_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
//		FeatureUtils.register(bootstapContext, INFESTED_POROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
//		FeatureUtils.register(bootstapContext, GLOWWORM_HOLE, BOFeatures.GLOWWORM_HOLE.get(), new NoneFeatureConfiguration());
//		FeatureUtils.register(bootstapContext, MYCELIUM_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState()));
//		FeatureUtils.register(bootstapContext, TERMOSTONE_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
//		FeatureUtils.register(bootstapContext, TERMITE_MYCELIUM_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
//		FeatureUtils.register(bootstapContext, TERMOSTONE_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
//		FeatureUtils.register(bootstapContext, POROUS_TERMOSTONE_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
//		FeatureUtils.register(bootstapContext, TERMOSTONE_MOUND, BOFeatures.TERMITE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
//		FeatureUtils.register(bootstapContext, CRUMBLY_TERMOSTONE_MOUND, BOFeatures.CRUMBLY_TERMITE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
//		FeatureUtils.register(bootstapContext, TERMOSTONE_PILLAR, BOFeatures.TERMOSTONE_PILLAR.get(), new LargeDripstoneConfiguration(30, UniformInt.of(3, 19), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
//	}
//
//	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
//		return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
//	}
//
//	public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfiguration) {
//		bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfiguration));
//	}
//
	public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BuggingOut.MOD_ID, id));
	}

}
