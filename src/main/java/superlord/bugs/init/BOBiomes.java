package superlord.bugs.init;

import com.google.common.base.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

public class BOBiomes {
	
public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, BuggingOut.MOD_ID);
	
	static {
		termite_mound("termite_mound", OverworldBiomes::theVoid);
	}
	
	public static RegistryObject<Biome> termite_mound(String name, Supplier<Biome> biome) {
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BuggingOut.MOD_ID, name)), 1));
		return REGISTER.register(name, biome);
	}

}
