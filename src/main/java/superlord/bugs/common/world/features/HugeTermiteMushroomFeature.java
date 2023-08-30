package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.init.BOBlocks;

public class HugeTermiteMushroomFeature extends Feature<NoneFeatureConfiguration> {

	public HugeTermiteMushroomFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> placeContext) {
		return place(placeContext.level(), placeContext.chunkGenerator(), placeContext.random(), placeContext.origin(), placeContext.config());
	}

	public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config) {
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.north().above(2)).is(Blocks.AIR) && world.getBlockState(pos.north(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.north().east().above(2)).is(Blocks.AIR) && world.getBlockState(pos.north().east(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.north(2).east().above(2)).is(Blocks.AIR) && world.getBlockState(pos.north(2).east(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.north().west().above(2)).is(Blocks.AIR) && world.getBlockState(pos.north().west(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.north(2).west().above(2)).is(Blocks.AIR) && world.getBlockState(pos.north(2).west(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.east().above(2)).is(Blocks.AIR) && world.getBlockState(pos.east(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.west().above(2)).is(Blocks.AIR) && world.getBlockState(pos.west(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.south().above(2)).is(Blocks.AIR) && world.getBlockState(pos.south(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.south().east().above(2)).is(Blocks.AIR) && world.getBlockState(pos.south().east(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.south(2).east().above(2)).is(Blocks.AIR) && world.getBlockState(pos.south(2).east(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.south().west().above(2)).is(Blocks.AIR) && world.getBlockState(pos.south().west(2).above(2)).is(Blocks.AIR) && world.getBlockState(pos.south(2).west().above(2)).is(Blocks.AIR) && world.getBlockState(pos.south(2).west(2).above(2)).is(Blocks.AIR)) {
			placeMushroomTree(world, rand, pos);
			return true;
		} else {
			return false;
		}
	}

	private void placeMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		int stemHeight = RandomSource.nextInt(5) + 2;
		int capRadius = RandomSource.nextInt(2) + 2;
		if (stemHeight == 6) {
			place6Tall3RadiusMushroomTree(world, RandomSource, pos);
		} else if (stemHeight == 5) {
			if (capRadius == 3) {
				place5Tall3RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place5Tall2RadiusMushroomTree(world, RandomSource, pos);
			}
		} else if (stemHeight == 4) {
			if (capRadius == 3) {
				place4Tall3RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place4Tall2RadiusMushroomTree(world, RandomSource, pos);
			}
		} else if (stemHeight == 3) {
			place3TallMushroomTree(world, RandomSource, pos);
		} else if (stemHeight == 2) {
			place2TallMushroomTree(world, RandomSource, pos);
		}
	}

	private void place6Tall3RadiusMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		int failTest = RandomSource.nextInt(2);
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4)).is(Blocks.AIR) && world.getBlockState(pos.above(5)).is(Blocks.AIR) && world.getBlockState(pos.above(6)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).north(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(6).south(3).west(3)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).north(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(6).south(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			if (failTest == 0) {
				place5Tall3RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place5Tall2RadiusMushroomTree(world, RandomSource, pos);
			}
		}
	}

	private void place5Tall3RadiusMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		int failTest = RandomSource.nextInt(2);
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4)).is(Blocks.AIR) && world.getBlockState(pos.above(5)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(3).west(3)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			if (failTest == 0) {
				place5Tall2RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place4Tall3RadiusMushroomTree(world, RandomSource, pos);
			}
		}
	}

	private void place5Tall2RadiusMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		int failTest = RandomSource.nextInt(2);
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4)).is(Blocks.AIR) && world.getBlockState(pos.above(5)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(5).south(2).west(2)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(5).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			if (failTest == 0) {
				place4Tall3RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place4Tall2RadiusMushroomTree(world, RandomSource, pos);
			}
		}
	}

	private void place4Tall3RadiusMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		int failTest = RandomSource.nextInt(2);
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).east(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).west(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(3).west(3)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).east(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(3).west(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			if (failTest == 0) {
				place4Tall2RadiusMushroomTree(world, RandomSource, pos);
			} else {
				place3TallMushroomTree(world, RandomSource, pos);
			}
		}
	}

	private void place4Tall2RadiusMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(4)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(4).south(2).west(2)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(4).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			place3TallMushroomTree(world, RandomSource, pos);
		}
	}

	private void place3TallMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3)).is(Blocks.AIR) && world.getBlockState(pos.above(3).north()).is(Blocks.AIR) && world.getBlockState(pos.above(3).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).south()).is(Blocks.AIR) && world.getBlockState(pos.above(3).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).east()).is(Blocks.AIR) && world.getBlockState(pos.above(3).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).west()).is(Blocks.AIR) && world.getBlockState(pos.above(3).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(3).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(3).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(3).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(3).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(3).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(3).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(3).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(3).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(3).south(2).west(2)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(3).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			place2TallMushroomTree(world, RandomSource, pos);
		}
	}

	private void place2TallMushroomTree(LevelAccessor world, RandomSource RandomSource, BlockPos pos) {
		if (world.getBlockState(pos).is(Blocks.AIR) && world.getBlockState(pos.above()).is(Blocks.AIR) && world.getBlockState(pos.above(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).north()).is(Blocks.AIR) && world.getBlockState(pos.above(2).north(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).south()).is(Blocks.AIR) && world.getBlockState(pos.above(2).south(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).north().west()).is(Blocks.AIR) && world.getBlockState(pos.above(2).north().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).north(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(2).north(2).west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).north().east()).is(Blocks.AIR) && world.getBlockState(pos.above(2).north().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).north(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(2).north(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).south().east()).is(Blocks.AIR) && world.getBlockState(pos.above(2).south().east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).south(2).east()).is(Blocks.AIR) && world.getBlockState(pos.above(2).south(2).east(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).south().west()).is(Blocks.AIR) && world.getBlockState(pos.above(2).south().west(2)).is(Blocks.AIR) && world.getBlockState(pos.above(2).south(2).west()).is(Blocks.AIR) && world.getBlockState(pos.above(2).south(2).west(2)).is(Blocks.AIR)) {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_STEM.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).north(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south().east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south().east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(2).east(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(2).east(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south().west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south().west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(2).west(), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
			world.setBlock(pos.above(2).south(2).west(2), BOBlocks.TERMITE_MUSHROOM_BLOCK.get().defaultBlockState(), 2);
		} else {
			world.setBlock(pos, BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState(), 2);
		}
	}


}
