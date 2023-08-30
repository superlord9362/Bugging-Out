package superlord.bugs.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class GlowWormHoleBlock extends DirectionalBlock {

	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	public static final BooleanProperty HAS_GLOWWORM = BooleanProperty.create("has_glowworm");

	public GlowWormHoleBlock(Properties p_52591_) {
		super(p_52591_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HAS_GLOWWORM, false));
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_52669_) {
		return this.defaultBlockState().setValue(FACING, p_52669_.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState p_52716_, Rotation p_52717_) {
		return p_52716_.setValue(FACING, p_52717_.rotate(p_52716_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_52713_, Mirror p_52714_) {
		return p_52713_.rotate(p_52714_.getRotation(p_52713_.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52719_) {
		p_52719_.add(FACING, HAS_GLOWWORM);
	}

}
