package superlord.bugs.common.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOEffects;

public class TermiteMushroomBlock extends MushroomBlock {
	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

	public TermiteMushroomBlock(Properties p_153983_, ResourceKey<ConfiguredFeature<?, ?>> p_153984_) {
		super(p_153983_, p_153984_);
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(world, player, pos, state, blockEntity, stack);
		player.addEffect(new MobEffectInstance(BOEffects.TERMITES_VENGEANCE.get(), 600, 0, false, false, true));
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 4;
	}

	protected int getAge(BlockState p_52306_) {
		return p_52306_.getValue(this.getAgeProperty());
	}

	public boolean isMaxAge(BlockState p_52308_) {
		return p_52308_.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	public boolean isRandomlyTicking(BlockState p_52288_) {
		return !this.isMaxAge(p_52288_);
	}

	public BlockState getStateForAge(int p_52290_) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(p_52290_));
	}

	@SuppressWarnings("deprecation")
	public void randomTick(BlockState p_52292_, ServerLevel p_52293_, BlockPos p_52294_, RandomSource p_52295_) {
		if (!p_52293_.isAreaLoaded(p_52294_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (p_52293_.getBlockState(p_52294_.below()).is(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())) {
			int i = this.getAge(p_52292_);
			if (i < this.getMaxAge()) {
				float f = getGrowthSpeed(this, p_52293_, p_52294_);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_52293_, p_52294_, p_52292_, p_52295_.nextInt((int)(25.0F / f) + 1) == 0)) {
					p_52293_.setBlock(p_52294_, this.getStateForAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_52293_, p_52294_, p_52292_);
				}
			}
		}
	}

	protected static float getGrowthSpeed(Block p_52273_, BlockGetter p_52274_, BlockPos p_52275_) {
		float f = 1.0F;
		BlockPos blockpos = p_52275_.below();

		for(int i = -1; i <= 1; ++i) {
			for(int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState blockstate = p_52274_.getBlockState(blockpos.offset(i, 0, j));
				if (blockstate.canSustainPlant(p_52274_, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) p_52273_)) {
					f1 = 1.0F;
					if (blockstate.isFertile(p_52274_, p_52275_.offset(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = p_52275_.north();
		BlockPos blockpos2 = p_52275_.south();
		BlockPos blockpos3 = p_52275_.west();
		BlockPos blockpos4 = p_52275_.east();
		boolean flag = p_52274_.getBlockState(blockpos3).is(p_52273_) || p_52274_.getBlockState(blockpos4).is(p_52273_);
		boolean flag1 = p_52274_.getBlockState(blockpos1).is(p_52273_) || p_52274_.getBlockState(blockpos2).is(p_52273_);
		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = p_52274_.getBlockState(blockpos3.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.south()).is(p_52273_) || p_52274_.getBlockState(blockpos3.south()).is(p_52273_);
			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52286_) {
		p_52286_.add(AGE);
	}

	public boolean canSurvive(BlockState p_54880_, LevelReader p_54881_, BlockPos p_54882_) {
		BlockPos blockpos = p_54882_.below();
		BlockState blockstate = p_54881_.getBlockState(blockpos);
		if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return blockstate.canSustainPlant(p_54881_, blockpos, net.minecraft.core.Direction.UP, this);
		}
	}

}
