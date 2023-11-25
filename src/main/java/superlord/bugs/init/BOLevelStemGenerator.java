package superlord.bugs.init;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import superlord.bugs.BuggingOut;

public class BOLevelStemGenerator extends DatapackBuiltinEntriesProvider {
	
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, ctx -> BOConfiguredFeatures.bootstrap(ctx))
			.add(Registries.PLACED_FEATURE, BOPlacedFeatures::bootstrap)
			.add(Registries.BIOME, BOBiomes::bootstrap)
			.add(Registries.DIMENSION_TYPE, ctx -> BODimensions.bootstrapType(ctx))
			.add(Registries.NOISE_SETTINGS, ctx -> BODimensions.bootstrapNoise(ctx))
			.add(Registries.LEVEL_STEM, ctx -> BODimensions.bootstrapStem(ctx));

	public BOLevelStemGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(BuggingOut.MOD_ID));
	}
	
}
