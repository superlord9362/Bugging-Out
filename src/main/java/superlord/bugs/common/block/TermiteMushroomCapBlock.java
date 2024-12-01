package superlord.bugs.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.init.BOParticles;

public class TermiteMushroomCapBlock extends HugeMushroomBlock {

	public TermiteMushroomCapBlock(Properties p_54136_) {
		super(p_54136_);
	}

	@Override
	public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
		double d0 = pos.getX() + random.nextDouble();
		double d1 = pos.getY() - 0.2D;
		double d2 = pos.getZ() + random.nextDouble();
		world.addParticle(BOParticles.TERMITE_MUSHROOM_SPORE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		//world.addParticle(BOParticles.TERMITE_MUSHROOM_SPORE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

}
