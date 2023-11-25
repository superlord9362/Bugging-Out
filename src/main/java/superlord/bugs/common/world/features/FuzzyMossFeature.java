package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.common.block.FuzzyMossBlock;
import superlord.bugs.init.BOBlocks;

public class FuzzyMossFeature extends Feature<NoneFeatureConfiguration> {

	public FuzzyMossFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		context.config();
		if (!worldgenlevel.isEmptyBlock(blockpos)) {
			return false;
		} else {
			for(Direction direction : Direction.values()) {
				if (FuzzyMossBlock.canAttachTo(worldgenlevel, direction, blockpos.relative(direction), worldgenlevel.getBlockState(blockpos.relative(direction)))) {
					worldgenlevel.setBlock(blockpos, BOBlocks.FUZZY_MOSS.get().defaultBlockState().setValue(FuzzyMossBlock.getFaceProperty(direction), Boolean.valueOf(true)), 2);
					return true;
				}
			}

			return false;
		}
	}
}
