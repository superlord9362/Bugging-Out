package superlord.bugs.common.world.features.config;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;

public class AbstractSphereReplaceConfig extends Feature<DiskConfiguration> {
	public AbstractSphereReplaceConfig(Codec<DiskConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
		DiskConfiguration diskconfiguration = context.config();
		BlockPos blockpos = context.origin();
		WorldGenLevel worldgenlevel = context.level();
		RandomSource randomsource = context.random();
		boolean flag = false;
		int i = blockpos.getY();
		int j = i + diskconfiguration.halfHeight();
		int k = i - diskconfiguration.halfHeight() - 1;
		int l = diskconfiguration.radius().sample(randomsource);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for(BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-l, 0, -l), blockpos.offset(l, 0, l))) {
			int i1 = blockpos1.getX() - blockpos.getX();
			int j1 = blockpos1.getZ() - blockpos.getZ();
			if (i1 * i1 + j1 * j1 <= l * l) {
				flag |= this.placeColumn(diskconfiguration, worldgenlevel, randomsource, j, k, blockpos$mutableblockpos.set(blockpos1));
			}
		}

		return flag;
	}

	protected boolean placeColumn(DiskConfiguration p_224996_, WorldGenLevel p_224997_, RandomSource p_224998_, int p_224999_, int p_225000_, BlockPos.MutableBlockPos p_225001_) {
		boolean flag = false;

		for(int i = p_224999_; i > p_225000_; --i) {
			p_225001_.setY(i);
			if (p_224996_.target().test(p_224997_, p_225001_)) {
				BlockState blockstate1 = p_224996_.stateProvider().getState(p_224997_, p_224998_, p_225001_);
				p_224997_.setBlock(p_225001_, blockstate1, 2);
				this.markAboveForPostProcessing(p_224997_, p_225001_);
				flag = true;
			}
		}

		return flag;
	}
}
