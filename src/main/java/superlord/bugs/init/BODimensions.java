package superlord.bugs.init;

import java.util.List;
import java.util.OptionalLong;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.biomesource.BOBiomeSource;
import superlord.bugs.common.world.chunkgen.BOChunkGenerator;

public class BODimensions {

	//public static final DeferredRegister<PoiType> REGISTER = DeferredRegister.create(ForgeRegistries.POI_TYPES, BuggingOut.MOD_ID);

	public static final ResourceKey<DimensionType> BUG_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(BuggingOut.MOD_ID, "bugs"));
	public static final ResourceKey<Level> BUGS = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(BuggingOut.MOD_ID, "bugs"));

	public static final ResourceKey<LevelStem> BUGS_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(BuggingOut.MOD_ID, "bugs"));
	public static final ResourceKey<NoiseGeneratorSettings> BUGS_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(BuggingOut.MOD_ID, "bugs_noise_settings"));

	public static void bootstrapType(BootstapContext<DimensionType> context) {
		context.register(BUG_TYPE, new DimensionType(
				OptionalLong.empty(), //fixed time
				true, //skylight
				false, //ceiling
				false, //ultrawarm
				true, //natural
				0.1D, //coordinate scale
				true, //bed works
				false, //respawn anchor works
				-64, // Minimum Y Level
				384, // Height + Min Y = Max Y
				384, // Logical Height
				BlockTags.INFINIBURN_OVERWORLD, //infiniburn
				BuiltinDimensionTypes.OVERWORLD_EFFECTS, // DimensionRenderInfo
				0F, // ambient light
				new DimensionType.MonsterSettings(true, false, UniformInt.of(0, 0), 0)));
	}
	
	public static void bootstrapStem(BootstapContext<LevelStem> context) {
		HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
		HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
		HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
		context.register(BUGS_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(BUG_TYPE), new BOChunkGenerator(BOBiomeSource.create(biomeRegistry), noiseGenSettings.getOrThrow(BUGS_NOISE_GEN))));
	}
	
	public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
		HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);
		HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
		DensityFunction densityfunction = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_X);
		DensityFunction densityfunction1 = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_Z);

		context.register(BUGS_NOISE_GEN, new NoiseGeneratorSettings(
				NoiseSettings.create(0, 128, 2, 2),
				BOBlocks.TERMOSTONE.get().defaultBlockState(),
				Blocks.AIR.defaultBlockState(),
				new NoiseRouter(
						DensityFunctions.zero(), //barrier
						DensityFunctions.zero(), //fluid level floodedness
						DensityFunctions.zero(), //fluid level spread
						DensityFunctions.zero(), //lava
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
						NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
						NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
						DensityFunctions.rangeChoice(
								NoiseRouterData.getFunction(functions, NoiseRouterData.Y),
								0.0D,
								32.0D,
								DensityFunctions.constant(2.0D),
								DensityFunctions.constant(-2.0D)), //depth
						NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
						DensityFunctions.zero(), //initial density
						DensityFunctions.zero(), //final density
						DensityFunctions.zero(), //vein toggle
						DensityFunctions.zero(), //vein ridged
						DensityFunctions.zero() //vein gap
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()))
				),
				List.of(), //spawn targets
				64,
				false,
				false,
				false,
				false
		));
	}

}
