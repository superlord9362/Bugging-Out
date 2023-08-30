package superlord.bugs.init;

import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BOConfiguredFeatures {

	public static final DeferredRegister<ConfiguredFeature<?,?>> REGISTER = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BuggingOut.MOD_ID);

	
	public static final RegistryObject<ConfiguredFeature<?, ?>> HUGE_TERMITE_MUSHROOM = REGISTER.register("configured_huge_termite_mushroom", () -> new ConfiguredFeature<>(BOFeatures.HUGE_TERMITE_MUSHROOM.get(), new NoneFeatureConfiguration()));

	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMITE_MUSHROOMS = REGISTER.register("configured_termite_mushrooms", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(BOBlocks.TERMITE_MUSHROOM.get()), 32)));

	public static final RegistryObject<ConfiguredFeature<?, ?>> FERROUS_TERMOSTONE = REGISTER.register("configured_ferrous_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.FERROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> POROUS_TERMOSTONE = REGISTER.register("configured_porous_termostone", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.POROUS_TERMOSTONE.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())), UniformInt.of(1, 3), 3)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("configured_termite_mushroom_mycelium", () -> new ConfiguredFeature(BOFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get()), BlockPredicate.matchesBlocks(List.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get())), UniformInt.of(1, 3), 3)));


	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
		return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
	}
	
}
