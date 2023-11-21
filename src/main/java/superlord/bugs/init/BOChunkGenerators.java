package superlord.bugs.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.chunkgen.BOChunkGenerator;

public class BOChunkGenerators {

public static final DeferredRegister<Codec<? extends ChunkGenerator>> REGISTER = DeferredRegister.create(Registries.CHUNK_GENERATOR, BuggingOut.MOD_ID);
	
	public static final RegistryObject<Codec<BOChunkGenerator>> BUGGING_OUT_CHUNK_GENERATOR = REGISTER.register("bugging_out_chunk_generator", () -> BOChunkGenerator.CODEC);
	
}
