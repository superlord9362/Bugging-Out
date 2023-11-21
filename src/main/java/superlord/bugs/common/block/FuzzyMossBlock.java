package superlord.bugs.common.block;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.bugs.init.BOItems;

public class FuzzyMossBlock extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	public static final BooleanProperty TRIMMED = BooleanProperty.create("trimmed");
	private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	private final Map<BlockState, VoxelShape> shapesCache;

	public FuzzyMossBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(TRIMMED, true));
		this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), FuzzyMossBlock::calculateShape)));
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection());
	}

	public BlockState rotate(BlockState p_52716_, Rotation p_52717_) {
		return p_52716_.setValue(FACING, p_52717_.rotate(p_52716_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_52713_, Mirror p_52714_) {
		return p_52713_.rotate(p_52714_.getRotation(p_52713_.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52719_) {
		p_52719_.add(FACING, TRIMMED);
	}

	private static VoxelShape calculateShape(BlockState state) {
		VoxelShape shape = Shapes.empty();
		if (state.getValue(FACING) == Direction.UP) {
			shape = UP_AABB;
		}
		if (state.getValue(FACING) == Direction.DOWN) {
			shape = DOWN_AABB;
		}
		if (state.getValue(FACING) == Direction.EAST) {
			shape = EAST_AABB;
		}
		if (state.getValue(FACING) == Direction.WEST) {
			shape = WEST_AABB;
		}
		if (state.getValue(FACING) == Direction.NORTH) {
			shape = NORTH_AABB;
		}
		if (state.getValue(FACING) == Direction.SOUTH) {
			shape = SOUTH_AABB;
		}
		return shape.isEmpty() ? Shapes.block() : shape;
	}

	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos) {
		return this.shapesCache.get(state);
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		boolean trimmed = state.getValue(TRIMMED);
		if (trimmed) {
			level.setBlockAndUpdate(pos, state.setValue(TRIMMED, false));
		}
	}


	@SuppressWarnings("deprecation")
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		if (stack.is(Items.SHEARS) && state.getValue(TRIMMED) == false) {
			if (!player.getAbilities().instabuild) {
				stack.hurtAndBreak(1, player, (shears) -> {
					shears.broadcastBreakEvent(hand);
				});
			}
			popResource(world, pos, new ItemStack(BOItems.FUZZY_MOSS.get(), 1));
			world.setBlockAndUpdate(pos, state.setValue(TRIMMED, true));
			return InteractionResult.SUCCESS;
		} else {
			return super.use(state, world, pos, player, hand, result);
		}
	}
	
}
