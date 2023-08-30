package superlord.bugs.common.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.init.BOParticles;

public class TermiteMushroomCapBlock extends HugeMushroomBlock {

	public TermiteMushroomCapBlock(Properties p_54136_) {
		super(p_54136_);
	}
	
	public void animateTick(BlockState p_154704_, Level p_154705_, BlockPos p_154706_, Random p_154707_) {
	      int i = p_154706_.getX();
	      int j = p_154706_.getY();
	      int k = p_154706_.getZ();
	      double d0 = (double)i + p_154707_.nextDouble();
	      double d1 = (double)j - 0.2D;
	      double d2 = (double)k + p_154707_.nextDouble();
	      p_154705_.addParticle(BOParticles.TERMITE_MUSHROOM_SPORE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	   }

}
