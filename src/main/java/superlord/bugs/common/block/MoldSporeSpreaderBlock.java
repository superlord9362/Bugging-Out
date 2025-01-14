package superlord.bugs.common.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.bugs.common.entity.block.MoldSporeSpreaderBlockEntity;
import superlord.bugs.init.BOBlockEntities;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOParticles;

public class MoldSporeSpreaderBlock extends BaseEntityBlock {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	public static final VoxelShape SHAPE_STALK = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
	public static final VoxelShape SHAPE_BULB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
	public static final VoxelShape SHAPE = Shapes.or(SHAPE_STALK, SHAPE_BULB);

	public MoldSporeSpreaderBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
	}

	public VoxelShape getOcclusionShape(BlockState p_54584_, BlockGetter p_54585_, BlockPos p_54586_) {
		if (p_54584_.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_STALK;
		} else return SHAPE_BULB;
	}

	public VoxelShape getCollisionShape(BlockState p_54577_, BlockGetter p_54578_, BlockPos p_54579_, CollisionContext p_54580_) {
		if (p_54577_.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_STALK;
		} else return SHAPE_BULB;
	}

	public VoxelShape getShape(BlockState p_54561_, BlockGetter p_54562_, BlockPos p_54563_, CollisionContext p_54564_) {
		if (p_54561_.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_STALK;
		} else return SHAPE_BULB;
	}

	protected boolean mayPlaceOn(BlockState p_54894_, BlockGetter p_54895_, BlockPos p_54896_) {
		return p_54894_.isSolidRender(p_54895_, p_54896_);
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_52894_, Direction p_52895_, BlockState p_52896_, LevelAccessor p_52897_, BlockPos p_52898_, BlockPos p_52899_) {
		DoubleBlockHalf doubleblockhalf = p_52894_.getValue(HALF);
		if (p_52895_.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (p_52895_ == Direction.UP) || p_52896_.is(this) && p_52896_.getValue(HALF) != doubleblockhalf) {
			return doubleblockhalf == DoubleBlockHalf.LOWER && p_52895_ == Direction.DOWN && !p_52894_.canSurvive(p_52897_, p_52898_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_52894_, p_52895_, p_52896_, p_52897_, p_52898_, p_52899_);
		} else {
			return Blocks.AIR.defaultBlockState();
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_52863_) {
		BlockPos blockpos = p_52863_.getClickedPos();
		Level level = p_52863_.getLevel();
		return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(p_52863_) ? super.getStateForPlacement(p_52863_) : null;
	}

	public void setPlacedBy(Level p_52872_, BlockPos p_52873_, BlockState p_52874_, LivingEntity p_52875_, ItemStack p_52876_) {
		BlockPos blockpos = p_52873_.above();
		p_52872_.setBlock(blockpos, copyWaterloggedFrom(p_52872_, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
	}

	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState p_52887_, LevelReader p_52888_, BlockPos p_52889_) {
		if (p_52887_.getValue(HALF) != DoubleBlockHalf.UPPER) {
			BlockPos blockpos = p_52889_.below();
			BlockState blockstate = p_52888_.getBlockState(blockpos);
			return mayPlaceOn(blockstate, p_52888_, blockpos);
		} else {
			BlockState blockstate = p_52888_.getBlockState(p_52889_.below());
			if (p_52887_.getBlock() != this) return super.canSurvive(p_52887_, p_52888_, p_52889_); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
			return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
		}
	}

	public static void placeAt(LevelAccessor p_153174_, BlockState p_153175_, BlockPos p_153176_, int p_153177_) {
		BlockPos blockpos = p_153176_.above();
		p_153174_.setBlock(p_153176_, copyWaterloggedFrom(p_153174_, p_153176_, p_153175_.setValue(HALF, DoubleBlockHalf.LOWER)), p_153177_);
		p_153174_.setBlock(blockpos, copyWaterloggedFrom(p_153174_, blockpos, p_153175_.setValue(HALF, DoubleBlockHalf.UPPER)), p_153177_);
	}

	public static BlockState copyWaterloggedFrom(LevelReader p_182454_, BlockPos p_182455_, BlockState p_182456_) {
		return p_182456_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_182456_.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(p_182454_.isWaterAt(p_182455_))) : p_182456_;
	}

	public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
		if (!p_52878_.isClientSide) {
			if (p_52881_.isCreative()) {
				preventCreativeDropFromBottomPart(p_52878_, p_52879_, p_52880_, p_52881_);
			} else {
				dropResources(p_52880_, p_52878_, p_52879_, (BlockEntity)null, p_52881_, p_52881_.getMainHandItem());
			}
		}

		super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
	}

	public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
		super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
	}

	protected static void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
		DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = p_52905_.below();
			BlockState blockstate = p_52904_.getBlockState(blockpos);
			if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				p_52904_.setBlock(blockpos, blockstate1, 35);
				p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
			}
		}

	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		int spreadDirection = random.nextInt(4);
		if (spreadDirection == 0) {
			if (world.getBlockState(pos.north().below()).isSolidRender(world, pos.north().below()) && !world.getBlockState(pos.north()).canBeReplaced() && (!world.getBlockState(pos.north()).is(BOBlocks.MOLD_STALKS.get()) || !world.getBlockState(pos.north()).is(this) || !world.getBlockState(pos.north()).is(BOBlocks.MOLD_CARPET.get()))) {
				world.setBlock(pos.north(), BOBlocks.MOLD_CARPET.get().defaultBlockState().setValue(MoldBlock.DISTANCE, 1).setValue(PipeBlock.DOWN, true), 2);
			}
		}
		if (spreadDirection == 1) {
			if (world.getBlockState(pos.east().below()).isSolidRender(world, pos.east().below()) && !world.getBlockState(pos.east()).canBeReplaced() && (!world.getBlockState(pos.east()).is(BOBlocks.MOLD_STALKS.get()) || !world.getBlockState(pos.east()).is(this) || !world.getBlockState(pos.east()).is(BOBlocks.MOLD_CARPET.get()))) {
				world.setBlock(pos.east(), BOBlocks.MOLD_CARPET.get().defaultBlockState().setValue(MoldBlock.DISTANCE, 1).setValue(PipeBlock.DOWN, true), 2);
			}
		}
		if (spreadDirection == 2) {
			if (world.getBlockState(pos.south().below()).isSolidRender(world, pos.south().below()) && !world.getBlockState(pos.south()).canBeReplaced() && (!world.getBlockState(pos.south()).is(BOBlocks.MOLD_STALKS.get()) || !world.getBlockState(pos.south()).is(this) || !world.getBlockState(pos.south()).is(BOBlocks.MOLD_CARPET.get()))) {
				world.setBlock(pos.south(), BOBlocks.MOLD_CARPET.get().defaultBlockState().setValue(MoldBlock.DISTANCE, 1).setValue(PipeBlock.DOWN, true), 2);
			}
		}
		if (spreadDirection == 3) {
			if (world.getBlockState(pos.west().below()).isSolidRender(world, pos.west().below()) && !world.getBlockState(pos.west()).canBeReplaced() && (!world.getBlockState(pos.west()).is(BOBlocks.MOLD_STALKS.get()) || !world.getBlockState(pos.west()).is(this) || !world.getBlockState(pos.west()).is(BOBlocks.MOLD_CARPET.get()))) {
				world.setBlock(pos.west(), BOBlocks.MOLD_CARPET.get().defaultBlockState().setValue(MoldBlock.DISTANCE, 1).setValue(PipeBlock.DOWN, true), 2);
			}
		}
	}
	public void animateTick(BlockState p_154704_, Level p_154705_, BlockPos p_154706_, RandomSource p_154707_) {
		int i = p_154706_.getX();
		int j = p_154706_.getY();
		int k = p_154706_.getZ();
		double d0 = (double)i + p_154707_.nextDouble();
		double d1 = (double)j + p_154707_.nextDouble();
		double d2 = (double)k + p_154707_.nextDouble();
		p_154705_.addParticle(BOParticles.MOLD_SPORE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52901_) {
		p_52901_.add(HALF);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> blockEntity) {
		return world.isClientSide ? null : createTickerHelper(blockEntity, BOBlockEntities.MOLD_SPORE_SPREADER.get(), MoldSporeSpreaderBlockEntity::serverTick);
	}

	public RenderShape getRenderShape(BlockState p_48727_) {
		return RenderShape.MODEL;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new MoldSporeSpreaderBlockEntity(p_153215_, p_153216_);
	}

}
