package superlord.bugs.common.world;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.bugs.BuggingOut;
import superlord.bugs.init.BOPlacedFeatures;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID)
public class TermiteMoundDecorator {
	
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		String name = event.getName().getPath();
		if (name.equals("termite_mound")) {
			builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BOPlacedFeatures.FERROUS_TERMOSTONE.getHolder().orElseThrow());
			builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BOPlacedFeatures.TERMITE_MUSHROOM_MYCELIUM.getHolder().orElseThrow());
			builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BOPlacedFeatures.POROUS_TERMOSTONE.getHolder().orElseThrow());
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.PLACED_GIANT_TERMITE_MUSHROOMS.getHolder().orElseThrow());
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BOPlacedFeatures.TERMITE_MUSHROOMS.getHolder().orElseThrow());
		}
	}

}
