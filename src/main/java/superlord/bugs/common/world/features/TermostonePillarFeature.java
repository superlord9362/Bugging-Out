package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.phys.Vec3;
import superlord.bugs.common.world.features.util.TermostonePillarUtils;
import superlord.bugs.init.BOBlocks;

public class TermostonePillarFeature extends Feature<LargeDripstoneConfiguration> {
	public TermostonePillarFeature(Codec<LargeDripstoneConfiguration> p_159960_) {
		super(p_159960_);
	}

	public boolean place(FeaturePlaceContext<LargeDripstoneConfiguration> p_159967_) {
		WorldGenLevel worldgenlevel = p_159967_.level();
		BlockPos blockpos = p_159967_.origin();
		LargeDripstoneConfiguration largedripstoneconfiguration = p_159967_.config();
		Random random = p_159967_.random();
		if (!TermostonePillarUtils.isEmptyOrWater(worldgenlevel, blockpos)) {
			return false;
		} else {
			Optional<Column> optional = Column.scan(worldgenlevel, blockpos, largedripstoneconfiguration.floorToCeilingSearchRange, TermostonePillarUtils::isEmptyOrWater, TermostonePillarUtils::isDripstoneBaseOrLava);
			if (optional.isPresent() && optional.get() instanceof Column.Range) {
				Column.Range column$range = (Column.Range)optional.get();
				if (column$range.height() < 4) {
					return false;
				} else {
					int i = (int)((float)column$range.height() * largedripstoneconfiguration.maxColumnRadiusToCaveHeightRatio);
					int j = Mth.clamp(i, largedripstoneconfiguration.columnRadius.getMinValue(), largedripstoneconfiguration.columnRadius.getMaxValue());
					int k = Mth.randomBetweenInclusive(random, largedripstoneconfiguration.columnRadius.getMinValue(), j);
					TermostonePillarFeature.LargeDripstone largedripstonefeature$largedripstone = makeDripstone(blockpos.atY(column$range.ceiling() - 1), false, random, k, largedripstoneconfiguration.stalactiteBluntness, largedripstoneconfiguration.heightScale);
					TermostonePillarFeature.LargeDripstone largedripstonefeature$largedripstone1 = makeDripstone(blockpos.atY(column$range.floor() + 1), true, random, k, largedripstoneconfiguration.stalagmiteBluntness, largedripstoneconfiguration.heightScale);
					TermostonePillarFeature.WindOffsetter largedripstonefeature$windoffsetter;
					if (largedripstonefeature$largedripstone.isSuitableForWind(largedripstoneconfiguration) && largedripstonefeature$largedripstone1.isSuitableForWind(largedripstoneconfiguration)) {
						largedripstonefeature$windoffsetter = new TermostonePillarFeature.WindOffsetter(blockpos.getY(), random, largedripstoneconfiguration.windSpeed);
					} else {
						largedripstonefeature$windoffsetter = TermostonePillarFeature.WindOffsetter.noWind();
					}

					boolean flag = largedripstonefeature$largedripstone.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(worldgenlevel, largedripstonefeature$windoffsetter);
					boolean flag1 = largedripstonefeature$largedripstone1.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(worldgenlevel, largedripstonefeature$windoffsetter);
					if (flag) {
						largedripstonefeature$largedripstone.placeBlocks(worldgenlevel, random, largedripstonefeature$windoffsetter);
					}

					if (flag1) {
						largedripstonefeature$largedripstone1.placeBlocks(worldgenlevel, random, largedripstonefeature$windoffsetter);
					}

					return true;
				}
			} else {
				return false;
			}
		}
	}

	private static TermostonePillarFeature.LargeDripstone makeDripstone(BlockPos p_197109_, boolean p_197110_, Random p_197111_, int p_197112_, FloatProvider p_197113_, FloatProvider p_197114_) {
		return new TermostonePillarFeature.LargeDripstone(p_197109_, p_197110_, p_197112_, (double)p_197113_.sample(p_197111_), (double)p_197114_.sample(p_197111_));
	}

	@SuppressWarnings("unused")
	private void placeDebugMarkers(WorldGenLevel p_159962_, BlockPos p_159963_, Column.Range p_159964_, TermostonePillarFeature.WindOffsetter p_159965_) {
		p_159962_.setBlock(p_159965_.offset(p_159963_.atY(p_159964_.ceiling() - 1)), Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
		p_159962_.setBlock(p_159965_.offset(p_159963_.atY(p_159964_.floor() + 1)), Blocks.GOLD_BLOCK.defaultBlockState(), 2);

		for(BlockPos.MutableBlockPos blockpos$mutableblockpos = p_159963_.atY(p_159964_.floor() + 2).mutable(); blockpos$mutableblockpos.getY() < p_159964_.ceiling() - 1; blockpos$mutableblockpos.move(Direction.UP)) {
			BlockPos blockpos = p_159965_.offset(blockpos$mutableblockpos);
			if (TermostonePillarUtils.isEmptyOrWater(p_159962_, blockpos) || p_159962_.getBlockState(blockpos).is(BOBlocks.TERMOSTONE.get())) {
				p_159962_.setBlock(blockpos, Blocks.CREEPER_HEAD.defaultBlockState(), 2);
			}
		}

	}

	static final class LargeDripstone {
		private BlockPos root;
		private final boolean pointingUp;
		private int radius;
		private final double bluntness;
		private final double scale;

		LargeDripstone(BlockPos p_197116_, boolean p_197117_, int p_197118_, double p_197119_, double p_197120_) {
			this.root = p_197116_;
			this.pointingUp = p_197117_;
			this.radius = p_197118_;
			this.bluntness = p_197119_;
			this.scale = p_197120_;
		}

		private int getHeight() {
			return this.getHeightAtRadius(0.0F);
		}

		@SuppressWarnings("unused")
		private int getMinY() {
			return this.pointingUp ? this.root.getY() : this.root.getY() - this.getHeight();
		}

		@SuppressWarnings("unused")
		private int getMaxY() {
			return !this.pointingUp ? this.root.getY() : this.root.getY() + this.getHeight();
		}

		boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel p_159990_, TermostonePillarFeature.WindOffsetter p_159991_) {
			while(this.radius > 1) {
				BlockPos.MutableBlockPos blockpos$mutableblockpos = this.root.mutable();
				int i = Math.min(10, this.getHeight());

				for(int j = 0; j < i; ++j) {
					if (p_159990_.getBlockState(blockpos$mutableblockpos).is(Blocks.LAVA)) {
						return false;
					}

					if (TermostonePillarUtils.isCircleMostlyEmbeddedInStone(p_159990_, p_159991_.offset(blockpos$mutableblockpos), this.radius)) {
						this.root = blockpos$mutableblockpos;
						return true;
					}

					blockpos$mutableblockpos.move(this.pointingUp ? Direction.DOWN : Direction.UP);
				}

				this.radius /= 2;
			}

			return false;
		}

		private int getHeightAtRadius(float p_159988_) {
			return (int)TermostonePillarUtils.getDripstoneHeight((double)p_159988_, (double)this.radius, this.scale, this.bluntness);
		}

		void placeBlocks(WorldGenLevel p_159993_, Random p_159994_, TermostonePillarFeature.WindOffsetter p_159995_) {
			for(int i = -this.radius; i <= this.radius; ++i) {
				for(int j = -this.radius; j <= this.radius; ++j) {
					float f = Mth.sqrt((float)(i * i + j * j));
					if (!(f > (float)this.radius)) {
						int k = this.getHeightAtRadius(f);
						if (k > 0) {
							if ((double)p_159994_.nextFloat() < 0.2D) {
								k = (int)((float)k * Mth.randomBetween(p_159994_, 0.8F, 1.0F));
							}

							BlockPos.MutableBlockPos blockpos$mutableblockpos = this.root.offset(i, 0, j).mutable();
							boolean flag = false;
							int l = this.pointingUp ? p_159993_.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos$mutableblockpos.getX(), blockpos$mutableblockpos.getZ()) : Integer.MAX_VALUE;

							for(int i1 = 0; i1 < k && blockpos$mutableblockpos.getY() < l; ++i1) {
								BlockPos blockpos = p_159995_.offset(blockpos$mutableblockpos);
								if (TermostonePillarUtils.isEmptyOrWaterOrLava(p_159993_, blockpos)) {
									flag = true;
									Block block = BOBlocks.TERMOSTONE.get();
									p_159993_.setBlock(blockpos, block.defaultBlockState(), 2);
								} else if (flag && p_159993_.getBlockState(blockpos).is(BOBlocks.TERMOSTONE.get())) {
									break;
								}

								blockpos$mutableblockpos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
							}
						}
					}
				}
			}

		}

		boolean isSuitableForWind(LargeDripstoneConfiguration p_159997_) {
			return this.radius >= p_159997_.minRadiusForWind && this.bluntness >= (double)p_159997_.minBluntnessForWind;
		}
	}

	static final class WindOffsetter {
		private final int originY;
		@Nullable
		private final Vec3 windSpeed;

		WindOffsetter(int p_160004_, Random p_160005_, FloatProvider p_160006_) {
			this.originY = p_160004_;
			float f = p_160006_.sample(p_160005_);
			float f1 = Mth.randomBetween(p_160005_, 0.0F, (float)Math.PI);
			this.windSpeed = new Vec3((double)(Mth.cos(f1) * f), 0.0D, (double)(Mth.sin(f1) * f));
		}

		private WindOffsetter() {
			this.originY = 0;
			this.windSpeed = null;
		}

		static TermostonePillarFeature.WindOffsetter noWind() {
			return new TermostonePillarFeature.WindOffsetter();
		}

		BlockPos offset(BlockPos p_160009_) {
			if (this.windSpeed == null) {
				return p_160009_;
			} else {
				int i = this.originY - p_160009_.getY();
				Vec3 vec3 = this.windSpeed.scale((double)i);
				return p_160009_.offset(vec3.x, 0.0D, vec3.z);
			}
		}
	}
}