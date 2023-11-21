package superlord.bugs.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.biomesource.BOBiomeSource;

public class BOBiomeSources {
	
	public static final DeferredRegister<Codec<? extends BiomeSource>> REGISTER = DeferredRegister.create(Registries.BIOME_SOURCE, BuggingOut.MOD_ID);
	
	public static final RegistryObject<Codec<BOBiomeSource>> BUGGING_OUT_BIOME_SOURCE = REGISTER.register("bugging_out_biome_source", () -> BOBiomeSource.CODEC);

}
