package superlord.bugs.common.block;

import java.util.OptionalInt;
import java.util.function.ToIntFunction;

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
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import superlord.bugs.init.BOBlocks;

public class MoldBlock extends MultifaceBlock implements BonemealableBlock, SimpleWaterloggedBlock {
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final BooleanProperty ATTEMPTED_STALK_CONVERSION = BooleanProperty.create("stalk_conversion");
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
	private final MultifaceSpreader spreader = new MultifaceSpreader(this);

	public MoldBlock(BlockBehaviour.Properties p_153282_) {
		super(p_153282_);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(DISTANCE, Integer.valueOf(7)).setValue(ATTEMPTED_STALK_CONVERSION, false));
	}

	public static ToIntFunction<BlockState> emission(int p_181223_) {
		return (p_181221_) -> {
			return MultifaceBlock.hasAnyFace(p_181221_) ? p_181223_ : 0;
		};
	}

	@SuppressWarnings("static-access")
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		this.spreader.spreadFromRandomFaceTowardRandomDirection(state, world, pos, random);
		int convertToStalks = random.nextInt(5);
		if (convertToStalks == 0 && state.getValue(ATTEMPTED_STALK_CONVERSION) == false && this.hasFace(state, Direction.DOWN)) {
			world.setBlock(pos, BOBlocks.MOLD_STALKS.get().defaultBlockState(), 2);
		} else {
			world.setBlockAndUpdate(pos, state.setValue(ATTEMPTED_STALK_CONVERSION, true));
		}
	}

	public boolean isRandomlyTicking(BlockState p_54449_) {
		return p_54449_.getValue(DISTANCE) != 7;
	}

	public void tick(BlockState p_221369_, ServerLevel p_221370_, BlockPos p_221371_, RandomSource p_221372_) {
		p_221370_.setBlock(p_221371_, updateDistance(p_221369_, p_221370_, p_221371_), 3);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153309_) {
		super.createBlockStateDefinition(p_153309_);
		p_153309_.add(WATERLOGGED, DISTANCE, ATTEMPTED_STALK_CONVERSION);
	}

	public BlockState updateShape(BlockState p_153302_, Direction p_153303_, BlockState p_153304_, LevelAccessor p_153305_, BlockPos p_153306_, BlockPos p_153307_) {
		if (p_153302_.getValue(WATERLOGGED)) {
			p_153305_.scheduleTick(p_153306_, Fluids.WATER, Fluids.WATER.getTickDelay(p_153305_));
		}
		int i = getDistanceAt(p_153304_) + 1;
		if (i != 1 || p_153302_.getValue(DISTANCE) != i) {
			p_153305_.scheduleTick(p_153306_, this, 1);
		}
		return super.updateShape(p_153302_, p_153303_, p_153304_, p_153305_, p_153306_, p_153307_);
	}

	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
		return !p_153300_.getItemInHand().is(BOBlocks.MOLD_CARPET.get().asItem()) || super.canBeReplaced(p_153299_, p_153300_);
	}

	private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
		int i = 7;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for(Direction direction : Direction.values()) {
			blockpos$mutableblockpos.setWithOffset(p_54438_, direction);
			i = Math.min(i, getDistanceAt(p_54437_.getBlockState(blockpos$mutableblockpos)) + 1);
			if (i == 1) {
				break;
			}
		}

		return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistanceAt(BlockState p_54464_) {
		return getOptionalDistanceAt(p_54464_).orElse(7);
	}

	public static OptionalInt getOptionalDistanceAt(BlockState p_277868_) {
		if (p_277868_.is(BOBlocks.MOLD_SPORE_SPREADER.get())) {
			return OptionalInt.of(0);
		} else {
			return p_277868_.hasProperty(DISTANCE) ? OptionalInt.of(p_277868_.getValue(DISTANCE)) : OptionalInt.empty();
		}
	}

	public boolean isValidBonemealTarget(LevelReader p_256569_, BlockPos p_153290_, BlockState p_153291_, boolean p_153292_) {
		return Direction.stream().anyMatch((p_153316_) -> {
			return this.spreader.canSpreadInAnyDirection(p_153291_, p_256569_, p_153290_, p_153316_.getOpposite());
		});
	}

	public boolean isBonemealSuccess(Level p_221264_, RandomSource p_221265_, BlockPos p_221266_, BlockState p_221267_) {
		return true;
	}

	public void performBonemeal(ServerLevel p_221259_, RandomSource p_221260_, BlockPos p_221261_, BlockState p_221262_) {
		this.spreader.spreadFromRandomFaceTowardRandomDirection(p_221262_, p_221259_, p_221261_, p_221260_);
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState p_153311_) {
		return p_153311_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153311_);
	}

	public boolean propagatesSkylightDown(BlockState p_181225_, BlockGetter p_181226_, BlockPos p_181227_) {
		return p_181225_.getFluidState().isEmpty();
	}

	public MultifaceSpreader getSpreader() {
		return this.spreader;
	}
}