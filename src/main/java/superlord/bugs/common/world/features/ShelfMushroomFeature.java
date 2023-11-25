package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.common.block.WallFungusBlock;
import superlord.bugs.init.BOBlocks;

public class ShelfMushroomFeature extends Feature<NoneFeatureConfiguration> {
	public ShelfMushroomFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos blockpos = context.origin();
		int xPos = blockpos.getX();
		int yPos = blockpos.getY();
		int zPos = blockpos.getZ();
		boolean flag = false;
		RandomSource random = context.random();
		context.config();
		for (int i = yPos; i < 320; i++) {
			MutableBlockPos blockPos = new MutableBlockPos(xPos, i, zPos);
			if (!world.isEmptyBlock(blockPos)) {
				blockPos.move(Direction.UP);
			} else {
				if (random.nextInt(5) == 0) {
					for(Direction direction : Direction.Plane.HORIZONTAL) {
						if (world.getBlockState(blockPos.relative(direction)).isFaceSturdy(world, blockPos.relative(direction), direction)) {
							world.setBlock(blockPos, BOBlocks.SHELF_MUSHROOMS.get().defaultBlockState().setValue(WallFungusBlock.FACING, direction.getOpposite()), 0);
							flag = true;
							if (random.nextInt(25) == 0) {
								break;
							}
						}
					}
				}
			}
			blockPos.move(Direction.UP);
		}
		return flag;
	}
}
