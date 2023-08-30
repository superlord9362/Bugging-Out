package superlord.bugs.init;

import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

public class BOConfiguredWorldCarvers {
	
	public static final DeferredRegister<ConfiguredWorldCarver<?>> REGISTER = DeferredRegister.create(Registry.CONFIGURED_CARVER_REGISTRY, BuggingOut.MOD_ID);

	public static final RegistryObject<ConfiguredWorldCarver<?>> BUG_CAVE = REGISTER.register("configured_bug_cave", () -> BOWorldCarvers.BUG_CAVE.get().configured(new CaveCarverConfiguration(1F, UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(180)), UniformFloat.of(0.1F, 0.9F), VerticalAnchor.aboveBottom(0), CarverDebugSettings.of(false, Blocks.CRIMSON_BUTTON.defaultBlockState()), UniformFloat.of(0.7F, 1.4F), UniformFloat.of(0.8F, 1.3F), UniformFloat.of(-1.0F, 1.0F))));


}
