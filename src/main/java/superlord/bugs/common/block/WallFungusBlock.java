package superlord.bugs.common.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.bugs.init.BOBlocks;

public class WallFungusBlock extends HorizontalDirectionalBlock implements BonemealableBlock {

	public WallFungusBlock(Properties p_54120_) {
		super(p_54120_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_154157_) {
		p_154157_.add(FACING);
	}


	public boolean canSurvive(BlockState p_57721_, LevelReader p_57722_, BlockPos p_57723_) {
		Direction direction = p_57721_.getValue(FACING);
		BlockPos blockpos = p_57723_.relative(direction.getOpposite());
		BlockState blockstate = p_57722_.getBlockState(blockpos);
		return direction.getAxis().isHorizontal() && blockstate.isFaceSturdy(p_57722_, blockpos, direction);
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_57731_, Direction p_57732_, BlockState p_57733_, LevelAccessor p_57734_, BlockPos p_57735_, BlockPos p_57736_) {
		return p_57732_.getOpposite() == p_57731_.getValue(FACING) && !p_57731_.canSurvive(p_57734_, p_57735_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_57731_, p_57732_, p_57733_, p_57734_, p_57735_, p_57736_);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_57678_) {
		BlockState blockstate = this.defaultBlockState();
		LevelReader levelreader = p_57678_.getLevel();
		BlockPos blockpos = p_57678_.getClickedPos();
		Direction[] adirection = p_57678_.getNearestLookingDirections();

		for(Direction direction : adirection) {
			if (direction.getAxis().isHorizontal()) {
				Direction direction1 = direction.getOpposite();
				blockstate = blockstate.setValue(FACING, direction1);
				if (blockstate.canSurvive(levelreader, blockpos)) {
					return blockstate;
				}
			}
		}

		return null;
	}

	public VoxelShape getOcclusionShape(BlockState p_154170_, BlockGetter p_154171_, BlockPos p_154172_) {
		return Shapes.empty();
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		int topOrBottom = random.nextInt(2);
		Direction direction = level.getBlockState(pos).getValue(FACING);
		if (topOrBottom == 0) {
			level.setBlockAndUpdate(pos, BOBlocks.LARGE_SHELF_MUSHROOMS.get().defaultBlockState().setValue(BigShelfMushroomBlock.TYPE, BigShelfMushroomBlock.ShelfMushroomType.BOTTOM).setValue(BigShelfMushroomBlock.FACING, direction));
		} else {
			level.setBlockAndUpdate(pos, BOBlocks.LARGE_SHELF_MUSHROOMS.get().defaultBlockState().setValue(BigShelfMushroomBlock.TYPE, BigShelfMushroomBlock.ShelfMushroomType.TOP).setValue(BigShelfMushroomBlock.FACING, direction));
		}
	}

}
