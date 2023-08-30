package superlord.bugs.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BOConfiguredFeatures {

	public static final DeferredRegister<ConfiguredFeature<?,?>> REGISTER = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BuggingOut.MOD_ID);


	public static final RegistryObject<ConfiguredFeature<?, ?>> HUGE_TERMITE_MUSHROOM = REGISTER.register("configured_huge_termite_mushroom", () -> new ConfiguredFeature<>(BOFeatures.HUGE_TERMITE_MUSHROOM.get(), new NoneFeatureConfiguration()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMITE_MUSHROOMS = REGISTER.register("configured_termite_mushrooms", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(BOBlocks.TERMITE_MUSHROOM.get()), 32)));

	public static final RegistryObject<ConfiguredFeature<?, ?>> FERROUS_TERMOSTONE = REGISTER.register("configured_ferrous_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(BOBlocks.FERROUS_TERMOSTONE.get().defaultBlockState(), UniformInt.of(1, 3), 3, ImmutableList.of(BOBlocks.TERMOSTONE.get().defaultBlockState(), BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE = REGISTER.register("configured_porous_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState(), UniformInt.of(1, 3), 3, ImmutableList.of(BOBlocks.TERMOSTONE.get().defaultBlockState(), BOBlocks.FERROUS_TERMOSTONE.get().defaultBlockState(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("configured_termite_mushroom_mycelium", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), UniformInt.of(1, 3), 3, ImmutableList.of(BOBlocks.TERMOSTONE.get().defaultBlockState(), BOBlocks.FERROUS_TERMOSTONE.get().defaultBlockState(), BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE = REGISTER.register("configured_crumbly_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(BOBlocks.CRUMBLY_TERMOSTONE.get().defaultBlockState(), UniformInt.of(1, 3), 3, ImmutableList.of(BOBlocks.TERMOSTONE.get().defaultBlockState(), BOBlocks.FERROUS_TERMOSTONE.get().defaultBlockState(), BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> INFESTED_POROUS_TERMOSTONE = REGISTER.register("configured_infested_porous_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(BOBlocks.INFESTED_POROUS_TERMOSTONE.get().defaultBlockState(), UniformInt.of(1, 3), 3, ImmutableList.of(BOBlocks.TERMOSTONE.get().defaultBlockState(), BOBlocks.FERROUS_TERMOSTONE.get().defaultBlockState(), BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState()))));

	public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWWORM_HOLE = REGISTER.register("configured_glowworm_hole", () -> new ConfiguredFeature(BOFeatures.GLOWWORM_HOLE.get(), new NoneFeatureConfiguration()));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> MYCELIUM_ROCK = REGISTER.register("configured_mycelium_rock", () -> new ConfiguredFeature(Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMOSTONE_ROCK = REGISTER.register("configured_termostone_rock", () -> new ConfiguredFeature(Feature.FOREST_ROCK, new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMITE_MYCELIUM_CEILING_BLOB = REGISTER.register("configured_termite_mycelium_ceiling_blob", () -> new ConfiguredFeature(BOFeatures.TERMITE_MYCELIUM_CEILING_BLOB.get(), new NoneFeatureConfiguration()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMOSTONE_CEILING_BLOB = REGISTER.register("configured_termostone_ceiling_blob", () -> new ConfiguredFeature(BOFeatures.TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE_CEILING_BLOB = REGISTER.register("configured_porous_termostone_ceiling_blob", () -> new ConfiguredFeature(BOFeatures.POROUS_TERMOSTONE_CEILING_BLOB.get(), new NoneFeatureConfiguration()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMOSTONE_MOUND = REGISTER.register("configured_termostone_mound", () -> new ConfiguredFeature(BOFeatures.TERMINTE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRUMBLY_TERMOSTONE_MOUND = REGISTER.register("configured_crumbly_termostone_mound", () -> new ConfiguredFeature(BOFeatures.CRUMBLY_TERMINTE_MOUND.get(), new BlockStateConfiguration(BOBlocks.TERMOSTONE.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMOSTONE_PILLAR = REGISTER.register("configured_termostone_pillar", () -> new ConfiguredFeature(BOFeatures.TERMOSTONE_PILLAR.get(), new LargeDripstoneConfiguration(30, UniformInt.of(3, 19), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F)));

	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
		return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
	}

}
