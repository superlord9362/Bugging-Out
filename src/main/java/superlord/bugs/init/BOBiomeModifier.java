package superlord.bugs.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.TermiteMoundDecorator;

public class BOBiomeModifier implements BiomeModifier {
	
	private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(BuggingOut.MOD_ID, "bugging_out_biome_modifiers"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, BuggingOut.MOD_ID);
	
	public BOBiomeModifier() {
	}

	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase == Phase.ADD) {
			TermiteMoundDecorator.addBiomeSpawns(biome, builder);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Codec<? extends BiomeModifier> codec() {
		return (Codec)SERIALIZER.get();
	}
	
	public static Codec<BOBiomeModifier> makeCodec() {
		return Codec.unit(BOBiomeModifier::new);
	}
	
}
