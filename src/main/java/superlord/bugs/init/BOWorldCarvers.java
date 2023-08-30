package superlord.bugs.init;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.carver.BOWorldCarver;

public class BOWorldCarvers {

	public static final DeferredRegister<WorldCarver<?>> REGISTER = DeferredRegister.create(Registry.CARVER_REGISTRY, BuggingOut.MOD_ID);

	public static final RegistryObject<WorldCarver<CaveCarverConfiguration>> BUG_CAVE = REGISTER.register("bug_cave", () -> new BOWorldCarver(CaveCarverConfiguration.CODEC));

}
