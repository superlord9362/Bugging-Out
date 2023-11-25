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
		return codec.group(RegistryOps.retrieveElement(BOBiomes.FUNGAL_GARDENS), RegistryOps.retrieveElement(BOBiomes.INFESTED_TUNNELS), RegistryOps.retrieveElement(BOBiomes.TERMITE_GALLERY), RegistryOps.retrieveElement(BOBiomes.TERMITE_TUNNELS), RegistryOps.retrieveElement(BOBiomes.MOLDY_GROTTO), RegistryOps.retrieveElement(BOBiomes.ROTTEN_PASSAGES), RegistryOps.retrieveElement(BOBiomes.MOSSY_REGROWTH), RegistryOps.retrieveElement(BOBiomes.BEETLE_NEST), RegistryOps.retrieveElement(BOBiomes.GRASSY_MEADOWS), RegistryOps.retrieveElement(BOBiomes.FLOWER_MEADOWS), RegistryOps.retrieveElement(BOBiomes.DIRTY_TUNNELS)).apply(codec, codec.stable(BOBiomeSource::new));
	});

	private final Holder<Biome> fungalGardens, infestedTunnels, termiteGallery, termiteTunnels, moldyGrotto, rottenPassages, mossyRegrowth, beetleNest, grassyMeadows, flowerMeadows, dirtyTunnels;

	public static BOBiomeSource create(HolderGetter<Biome> biome) {
		return new BOBiomeSource(biome.getOrThrow(BOBiomes.FUNGAL_GARDENS), biome.getOrThrow(BOBiomes.INFESTED_TUNNELS), biome.getOrThrow(BOBiomes.TERMITE_GALLERY), biome.getOrThrow(BOBiomes.TERMITE_TUNNELS), biome.getOrThrow(BOBiomes.MOLDY_GROTTO), biome.getOrThrow(BOBiomes.ROTTEN_PASSAGES), biome.getOrThrow(BOBiomes.MOSSY_REGROWTH), biome.getOrThrow(BOBiomes.BEETLE_NEST), biome.getOrThrow(BOBiomes.GRASSY_MEADOWS), biome.getOrThrow(BOBiomes.FLOWER_MEADOWS), biome.getOrThrow(BOBiomes.DIRTY_TUNNELS));
	}

	public BOBiomeSource(Holder<Biome> fungalGardens, Holder<Biome> infestedTunnels, Holder<Biome> termiteGallery, Holder<Biome> termiteTunnels, Holder<Biome> moldyGrotto, Holder<Biome> rottenPassages, Holder<Biome> mossyRegrowth, Holder<Biome> beetleNest, Holder<Biome> grassyMeadows, Holder<Biome> flowerMeadows, Holder<Biome> dirtyTunnels) {
		this.fungalGardens = fungalGardens;
		this.infestedTunnels = infestedTunnels;
		this.termiteGallery = termiteGallery;
		this.termiteTunnels = termiteTunnels;
		this.moldyGrotto = moldyGrotto;
		this.rottenPassages = rottenPassages;
		this.mossyRegrowth = mossyRegrowth;
		this.beetleNest = beetleNest;
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
		} else if (y > 13) {
			if (noiseValue >= 0) {
				if (noiseValue >= 0 && noiseValue < 1 || noiseValue >= 3) {
					return flowerMeadows;
				}
				return grassyMeadows;
			} else {
				if (noiseValue > -4 && noiseValue <= -2) {
					return rottenPassages;
				}
				if (noiseValue > -2 && noiseValue < -1) {
					return mossyRegrowth;
				}
				if (noiseValue >= -1) {
					return moldyGrotto;
				}
				return beetleNest;
			}
		} else {
			if (noiseValue >= 0) {
				return dirtyTunnels;
			}
			if (noiseValue > -4 && noiseValue <= -2) {
				return rottenPassages;
			}
			if (noiseValue > -2 && noiseValue < -1) {
				return mossyRegrowth;
			}
			if (noiseValue >= -1) {
				return moldyGrotto;
			}
			return beetleNest;
		}
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.fungalGardens, this.infestedTunnels,this.termiteGallery, this.termiteTunnels, this.moldyGrotto, this.rottenPassages, this.mossyRegrowth, this.beetleNest, this.grassyMeadows, this.flowerMeadows, this.dirtyTunnels);
	}

}
