package superlord.bugs.init;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.block.TermiteMushroomBlock;

public class BOConfiguredFeatures {

	public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_TERMITE_MUSHROOM = registerConfiguredFeature("configured_huge_termite_mushroom");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MUSHROOMS = registerConfiguredFeature("configured_termite_mushrooms");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FERROUS_TERMOSTONE = registerConfiguredFeature("configured_ferrous_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE = registerConfiguredFeature("configured_porous_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MUSHROOM_MYCELIUM = registerConfiguredFeature("configured_termite_mushroom_mycelium");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE = registerConfiguredFeature("configured_crumbly_termostone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> INFESTED_POROUS_TERMOSTONE = registerConfiguredFeature("configured_infested_porous_termostone");

	public static final ResourceKey<ConfiguredFeature<?, ?>> MULCH = registerConfiguredFeature("configured_mulch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> STRIPPED_ROTTEN_WOOD = registerConfiguredFeature("configured_stripped_rotten_wood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS = registerConfiguredFeature("configured_moss");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWWORM_HOLE = registerConfiguredFeature("configured_glowworm_hole");

	public static final ResourceKey<ConfiguredFeature<?, ?>> MYCELIUM_ROCK = registerConfiguredFeature("configured_mycelium_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_ROCK = registerConfiguredFeature("configured_termostone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMITE_MYCELIUM_CEILING_BLOB = registerConfiguredFeature("configured_termite_mycelium_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_CEILING_BLOB = registerConfiguredFeature("configured_termostone_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE_CEILING_BLOB = registerConfiguredFeature("configured_porous_termostone_ceiling_blob");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_MOUND = registerConfiguredFeature("configured_termostone_mound");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE_MOUND = registerConfiguredFeature("configured_crumbly_termostone_mound");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TERMOSTONE_PILLAR = registerConfiguredFeature("configured_termostone_pillar");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> FUZZY_MOSS = registerConfiguredFeature("configured_fuzzy_moss");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FUZZY_WALL_MOSS = registerConfiguredFeature("configured_fuzzy_wall_moss");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FUZZY_CEILING_MOSS = registerConfiguredFeature("configured_fuzzy_ceiling_moss");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SPLINTERS = registerConfiguredFeature("configured_splinters");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SHELF_MUSHROOMS = registerConfiguredFeature("configured_shelf_mushrooms");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ROTTEN_CHARCOAL = registerConfiguredFeature("configured_rotten_charcoal");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
		FeatureUtils.register(bootstapContext, HUGE_TERMITE_MUSHROOM, BOFeatures.HUGE_TERMITE_MUSHROOM.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, TERMITE_MUSHROOMS, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 4), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 3), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 2), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 1), 1).add(BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState().setValue(TermiteMushroomBlock.AGE, 0), 1)), 32));
		FeatureUtils.register(bootstapContext, FERROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.FERROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3));
		FeatureUtils.register(bootstapContext, POROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.POROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3));
		FeatureUtils.register(bootstapContext, TERMITE_MUSHROOM_MYCELIUM, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
		FeatureUtils.register(bootstapContext, CRUMBLY_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.CRUMBLY_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
		FeatureUtils.register(bootstapContext, INFESTED_POROUS_TERMOSTONE, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3));
		FeatureUtils.register(bootstapContext, MULCH, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.MULCH.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.ROTTEN_WOOD.get(), BOBlocks.MULCH.get(), BOBlocks.STRIPPED_ROTTEN_WOOD.get(), BOBlocks.FUZZY_MOSS_BLOCK.get())), UniformInt.of(1, 8), 3));
		FeatureUtils.register(bootstapContext, MOSS, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.FUZZY_MOSS_BLOCK.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.ROTTEN_WOOD.get(), BOBlocks.MULCH.get(), BOBlocks.STRIPPED_ROTTEN_WOOD.get(), BOBlocks.FUZZY_MOSS_BLOCK.get())), UniformInt.of(1, 8), 3));
		FeatureUtils.register(bootstapContext, STRIPPED_ROTTEN_WOOD, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.STRIPPED_ROTTEN_WOOD.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.ROTTEN_WOOD.get(), BOBlocks.MULCH.get(), BOBlocks.STRIPPED_ROTTEN_WOOD.get(), BOBlocks.FUZZY_MOSS_BLOCK.get())), UniformInt.of(1, 8), 3));
		FeatureUtils.register(bootstapContext, ROTTEN_CHARCOAL, BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.ROTTEN_CHARCOAL_ORE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.ROTTEN_WOOD.get(), BOBlocks.MULCH.get(), BOBlocks.STRIPPED_ROTTEN_WOOD.get(), BOBlocks.FUZZY_MOSS_BLOCK.get())), UniformInt.of(1, 8), 3));
		FeatureUtils.register(bootstapContext, GLOWWORM_HOLE, BOFeatures.GLOWWORM_HOLE.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, MYCELIUM_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState()));
		FeatureUtils.register(bootstapContext, TERMOSTONE_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
		FeatureUtils.register(bootstapContext, TERMITE_MYCELIUM_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, TERMOSTONE_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, POROUS_TERMOSTONE_CEILING_BLOB, BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, TERMOSTONE_MOUND, BOFeatures.TERMITE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
		FeatureUtils.register(bootstapContext, CRUMBLY_TERMOSTONE_MOUND, BOFeatures.CRUMBLY_TERMITE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState()));
		FeatureUtils.register(bootstapContext, TERMOSTONE_PILLAR, BOFeatures.TERMOSTONE_PILLAR.get(), new LargeDripstoneConfiguration(30, UniformInt.of(3, 19), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
		FeatureUtils.register(bootstapContext, FUZZY_MOSS, BOFeatures.FUZZY_MOSS.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, FUZZY_WALL_MOSS, BOFeatures.FUZZY_WALL_MOSS.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, FUZZY_CEILING_MOSS, BOFeatures.FUZZY_CEILING_MOSS.get(), new NoneFeatureConfiguration());
		FeatureUtils.register(bootstapContext, SPLINTERS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(BOBlocks.SPLINTERS.get()), 32));
		FeatureUtils.register(bootstapContext, SHELF_MUSHROOMS, BOFeatures.SHELF_MUSHROOMS.get(), new NoneFeatureConfiguration());
	}

	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
		return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfiguration) {
		bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfiguration));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BuggingOut.MOD_ID, id));
	}

}
