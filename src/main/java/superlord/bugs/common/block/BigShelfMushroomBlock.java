package superlord.bugs.common.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigShelfMushroomBlock extends HorizontalDirectionalBlock {

	public static final EnumProperty<ShelfMushroomType> TYPE = EnumProperty.create("type", ShelfMushroomType.class);
	protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public BigShelfMushroomBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(TYPE, ShelfMushroomType.BOTTOM).setValue(FACING, Direction.NORTH));
	}

	public boolean useShapeForLightOcclusion(BlockState p_56395_) {
		return p_56395_.getValue(TYPE) != ShelfMushroomType.DOUBLE;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56388_) {
		p_56388_.add(TYPE, FACING);
	}

	public boolean canSurvive(BlockState p_57721_, LevelReader p_57722_, BlockPos p_57723_) {
		Direction direction = p_57721_.getValue(FACING);
		BlockPos blockpos = p_57723_.relative(direction.getOpposite());
		BlockState blockstate = p_57722_.getBlockState(blockpos);
		return direction.getAxis().isHorizontal() && blockstate.isFaceSturdy(p_57722_, blockpos, direction);
	}

	public VoxelShape getShape(BlockState p_56390_, BlockGetter p_56391_, BlockPos p_56392_, CollisionContext p_56393_) {
		ShelfMushroomType slabtype = p_56390_.getValue(TYPE);
		switch (slabtype) {
		case DOUBLE:
			return Shapes.block();
		case TOP:
			return TOP_AABB;
		default:
			return BOTTOM_AABB;
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_56361_) {
		BlockPos blockpos = p_56361_.getClickedPos();
		BlockState blockstate = p_56361_.getLevel().getBlockState(blockpos);
		Direction[] adirection = p_56361_.getNearestLookingDirections();
		LevelReader levelreader = p_56361_.getLevel();
		if (blockstate.is(this)) {
			return blockstate.setValue(TYPE, ShelfMushroomType.DOUBLE);
		} else {
			for (Direction direction : adirection) {
				if (direction.getAxis().isHorizontal()) {
					Direction direction1 = direction.getOpposite();
					if (blockstate.canSurvive(levelreader, blockpos)) {
						if (p_56361_.getClickLocation().y - (double)blockpos.getY() > 0.5D) {
							return this.defaultBlockState().setValue(TYPE, ShelfMushroomType.TOP).setValue(FACING, direction1);
						} else return this.defaultBlockState().setValue(TYPE, ShelfMushroomType.BOTTOM).setValue(FACING, direction1);
					}
				}
			}
			return null;
		}
	}

	public VoxelShape getOcclusionShape(BlockState p_154170_, BlockGetter p_154171_, BlockPos p_154172_) {
		return Shapes.empty();
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_57731_, Direction p_57732_, BlockState p_57733_, LevelAccessor p_57734_, BlockPos p_57735_, BlockPos p_57736_) {
		return p_57732_.getOpposite() == p_57731_.getValue(FACING) && !p_57731_.canSurvive(p_57734_, p_57735_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_57731_, p_57732_, p_57733_, p_57734_, p_57735_, p_57736_);
	}

	public boolean canBeReplaced(BlockState p_56373_, BlockPlaceContext p_56374_) {
		ItemStack itemstack = p_56374_.getItemInHand();
		ShelfMushroomType slabtype = p_56373_.getValue(TYPE);
		if (slabtype != ShelfMushroomType.DOUBLE && itemstack.is(this.asItem())) {
			if (p_56374_.replacingClickedOnBlock()) {
				boolean flag = p_56374_.getClickLocation().y - (double)p_56374_.getClickedPos().getY() > 0.5D;
				Direction direction = p_56374_.getClickedFace();
				if (slabtype == ShelfMushroomType.BOTTOM) {
					return direction == Direction.UP || flag && direction.getAxis().isHorizontal();
				} else {
					return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal();
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public enum ShelfMushroomType implements StringRepresentable {
		TOP("top"),
		BOTTOM("bottom"),
		DOUBLE("double");

		private final String name;

		private ShelfMushroomType(String p_61775_) {
			this.name = p_61775_;
		}

		public String toString() {
			return this.name;
		}

		public String getSerializedName() {
			return this.name;
		}
	}

}
