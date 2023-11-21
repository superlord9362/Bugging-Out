package superlord.bugs.common.world.biomesource;

import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager.NoiseBiomeSource;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate.Sampler;
import superlord.bugs.common.util.FastNoise;
import superlord.bugs.common.world.chunkgen.BOChunkGenerator;
import superlord.bugs.init.BOBiomes;

public class BOBiomeSource extends BiomeSource implements NoiseBiomeSource {

	double noiseValue;

	public static final Codec<BOBiomeSource> CODEC = RecordCodecBuilder.create((codec) -> {
		return codec.group(RegistryOps.retrieveElement(BOBiomes.FUNGAL_GARDENS), RegistryOps.retrieveElement(BOBiomes.INFESTED_TUNNELS), RegistryOps.retrieveElement(BOBiomes.TERMITE_GALLERY), RegistryOps.retrieveElement(BOBiomes.TERMITE_TUNNELS), RegistryOps.retrieveElement(BOBiomes.MOLDY_ROTTEN_LOG), RegistryOps.retrieveElement(BOBiomes.HOLLOWED_ROTTEN_LOG), RegistryOps.retrieveElement(BOBiomes.DAMP_ROTTEN_LOG), RegistryOps.retrieveElement(BOBiomes.BEETLE_INFESTED_LOG), RegistryOps.retrieveElement(BOBiomes.GRASSY_MEADOWS), RegistryOps.retrieveElement(BOBiomes.FLOWER_MEADOWS), RegistryOps.retrieveElement(BOBiomes.DIRTY_TUNNELS)).apply(codec, codec.stable(BOBiomeSource::new));
	});

	private final Holder<Biome> fungalGardens, infestedTunnels, termiteGallery, termiteTunnels, moldyRottenLog, hollowedRottenLog, dampRottenLog, beetleInfestedLog, grassyMeadows, flowerMeadows, dirtyTunnels;

	public BOBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(BOBiomes.FUNGAL_GARDENS), biome.getOrThrow(BOBiomes.INFESTED_TUNNELS), biome.getOrThrow(BOBiomes.TERMITE_GALLERY), biome.getOrThrow(BOBiomes.TERMITE_TUNNELS), biome.getOrThrow(BOBiomes.MOLDY_ROTTEN_LOG), biome.getOrThrow(BOBiomes.HOLLOWED_ROTTEN_LOG), biome.getOrThrow(BOBiomes.DAMP_ROTTEN_LOG), biome.getOrThrow(BOBiomes.BEETLE_INFESTED_LOG), biome.getOrThrow(BOBiomes.GRASSY_MEADOWS), biome.getOrThrow(BOBiomes.FLOWER_MEADOWS), biome.getOrThrow(BOBiomes.DIRTY_TUNNELS));
	}

	public BOBiomeSource(Holder<Biome> fungalGardens, Holder<Biome> infestedTunnels, Holder<Biome> termiteGallery, Holder<Biome> termiteTunnels, Holder<Biome> moldyRottenLog, Holder<Biome> hollowedRottenLog, Holder<Biome> dampRottenLog, Holder<Biome> beetleInfestedLog, Holder<Biome> grassyMeadows, Holder<Biome> flowerMeadows, Holder<Biome> dirtyTunnels) {
		this.fungalGardens = fungalGardens;
		this.infestedTunnels = infestedTunnels;
		this.termiteGallery = termiteGallery;
		this.termiteTunnels = termiteTunnels;
		this.moldyRottenLog = moldyRottenLog;
		this.hollowedRottenLog = hollowedRottenLog;
		this.dampRottenLog = dampRottenLog;
		this.beetleInfestedLog = beetleInfestedLog;
		this.grassyMeadows = grassyMeadows;
		this.flowerMeadows = flowerMeadows;
		this.dirtyTunnels = dirtyTunnels;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) {
		return getNoiseBiome(x, y, z);
	}

	public double calculateNoiseValue(int x, int z, FastNoise noise) {
		float frequency = 0.1F;
		float amplitude = 4.0F;
		double noiseX = noise.GetNoise(x * frequency, z * frequency);
		double noiseZ = noise.GetNoise(x * frequency, z * frequency);
		double combinedNoise = amplitude * (noiseX + noiseZ);
		return combinedNoise;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		noiseValue = calculateNoiseValue(x, z, BOChunkGenerator.noise);
		if (y < 0) {
			if (noiseValue > 2 && noiseValue < 3) {
				return fungalGardens;
			}
			if (noiseValue > 0.5 && noiseValue <= 2 || noiseValue >= 3 && noiseValue < 5) {
				return termiteGallery;
			}
			if (noiseValue > -2.3 && noiseValue <= 0.5) {
				return termiteTunnels;
			} 
			return infestedTunnels;
		}
		if (noiseValue >= 0) {
			if (y >= 0 && y < 50) {
				return dirtyTunnels;
			}
			if (y >= 50) {
				if (noiseValue >= 0 && noiseValue < 1 || noiseValue >= 3) {
					return flowerMeadows;
				}
				return grassyMeadows;
			}
			return flowerMeadows;
		} else {
			if (noiseValue > -4 && noiseValue <= -2) {
				return hollowedRottenLog;
			}
			if (noiseValue > -2 && noiseValue < -1) {
				return dampRottenLog;
			}
			if (noiseValue >= -1) {
				return moldyRottenLog;
			}
			return beetleInfestedLog;
		}
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.fungalGardens, this.infestedTunnels,this.termiteGallery, this.termiteTunnels, this.moldyRottenLog, this.hollowedRottenLog, this.dampRottenLog, this.beetleInfestedLog, this.grassyMeadows, this.flowerMeadows, this.dirtyTunnels);
	}

}
