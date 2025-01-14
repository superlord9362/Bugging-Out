package superlord.bugs.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.bugs.init.BOBlocks;

public class MoldStalksBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	private static final BooleanProperty ATTEMPTED_STALK_CONVERSION = BooleanProperty.create("stalk_conversion");

	public MoldStalksBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(ATTEMPTED_STALK_CONVERSION, false));
	}

	public boolean isRandomlyTicking(BlockState p_54449_) {
		return p_54449_.getValue(ATTEMPTED_STALK_CONVERSION) == false;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153309_) {
		super.createBlockStateDefinition(p_153309_);
		p_153309_.add(ATTEMPTED_STALK_CONVERSION);
	}

	public VoxelShape getShape(BlockState p_58169_, BlockGetter p_58170_, BlockPos p_58171_, CollisionContext p_58172_) {
		return SHAPE;
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		int convertToStalks = random.nextInt(5);
		if (convertToStalks == 0 && state.getValue(ATTEMPTED_STALK_CONVERSION) == false) {
			world.setBlockAndUpdate(pos, BOBlocks.MOLD_SPORE_SPREADER.get().defaultBlockState().setValue(MoldSporeSpreaderBlock.HALF, DoubleBlockHalf.LOWER));
			world.setBlockAndUpdate(pos.above(), BOBlocks.MOLD_SPORE_SPREADER.get().defaultBlockState().setValue(MoldSporeSpreaderBlock.HALF, DoubleBlockHalf.UPPER));
		} else {
			world.setBlockAndUpdate(pos, state.setValue(ATTEMPTED_STALK_CONVERSION, true));
		}
	}
	
	protected boolean mayPlaceOn(BlockState p_54894_, BlockGetter p_54895_, BlockPos p_54896_) {
	      return p_54894_.isSolidRender(p_54895_, p_54896_);
	   }

	   public boolean canSurvive(BlockState p_54880_, LevelReader p_54881_, BlockPos p_54882_) {
	      BlockPos blockpos = p_54882_.below();
	      BlockState blockstate = p_54881_.getBlockState(blockpos);
	      return mayPlaceOn(blockstate, p_54881_, blockpos);
	   }


}
