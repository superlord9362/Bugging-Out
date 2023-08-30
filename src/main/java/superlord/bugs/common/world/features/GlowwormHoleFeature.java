package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.init.BOBlocks;

public class GlowwormHoleFeature extends Feature<NoneFeatureConfiguration> {

	public GlowwormHoleFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int direction = context.random().nextInt(4);
		BlockPos pos = context.origin();
		int xPos = pos.getX();
		int yPos = pos.getY();
		int zPos = pos.getZ();
		boolean flag = false;
		for (int i = yPos; i < 320; i++) {
				BlockPos blockPos = new BlockPos(xPos, i, zPos);
				if (!world.isEmptyBlock(blockPos)) {
				System.out.println(pos);
				if (direction == 0) {
					if (world.getBlockState(blockPos.north()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.SOUTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.east()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.WEST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.south()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.NORTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.west()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.EAST), 2);
						flag = true;
						break;
					}
				} else if (direction == 1) {
					if (world.getBlockState(blockPos.east()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.WEST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.south()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.NORTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.west()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.EAST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.north()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.SOUTH), 2);
						flag = true;
						break;
					}
				} else if (direction == 2) {
					if (world.getBlockState(blockPos.south()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.NORTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.west()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.EAST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.north()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.SOUTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.east()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.WEST), 2);
						flag = true;
						break;
					}
				} else if (direction == 3) {
					if (world.getBlockState(blockPos.west()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.EAST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.north()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.SOUTH), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.east()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.WEST), 2);
						flag = true;
						break;
					} else if (world.getBlockState(blockPos.south()).isAir()) {
						world.setBlock(blockPos, BOBlocks.GLOW_WORM_HOLE.get().defaultBlockState().setValue(GlowWormHoleBlock.FACING, Direction.NORTH), 2);
						flag = true;
						break;
					}
				}
			}	
		}
		return flag;
	}

}
