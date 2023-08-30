package superlord.bugs.common.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AcidSplatBlock extends Block {
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

	public AcidSplatBlock(BlockBehaviour.Properties p_152915_) {
		super(p_152915_);
	}

	public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_, CollisionContext p_152920_) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_152926_, Direction p_152927_, BlockState p_152928_, LevelAccessor p_152929_, BlockPos p_152930_, BlockPos p_152931_) {
		return !p_152926_.canSurvive(p_152929_, p_152930_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152926_, p_152927_, p_152928_, p_152929_, p_152930_, p_152931_);
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		int removeTick = random.nextInt(30);
		if (removeTick == 0) {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
		}
	}

	public boolean canSurvive(BlockState p_152922_, LevelReader p_152923_, BlockPos p_152924_) {
		return !p_152923_.isEmptyBlock(p_152924_.below());
	}

	public void entityInside(BlockState p_51148_, Level p_51149_, BlockPos p_51150_, Entity p_51151_) {
		p_51151_.hurt(DamageSource.MAGIC, 1.0F);
	}

}
