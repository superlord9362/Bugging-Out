package superlord.bugs.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.init.BOBlocks;

public class AttractedToGlowwormHoleGoal extends MoveToBlockGoal {
	protected int ticksWaited;
	public PathfinderMob entity;
	
	public AttractedToGlowwormHoleGoal(PathfinderMob mob, double p_25610_, int p_25611_) {
		super(mob, p_25610_, p_25611_);
		this.entity = mob;
	}
	
	public double acceptedDistance() {
		return 2.0D;
	}

	public boolean shouldRecalculatePath() {
		return this.tryTicks % 100 == 0;
	}

	protected boolean isValidTarget(LevelReader p_28680_, BlockPos p_28681_) {
		BlockState blockstate = p_28680_.getBlockState(p_28681_);
		return blockstate.is(BOBlocks.GLOW_WORM_HOLE.get()) && blockstate.getValue(GlowWormHoleBlock.HAS_GLOWWORM) == true;
	}

	public void tick() {
		if (this.isReachedTarget()) {
			if (this.ticksWaited >= 40) {
			} else {
				++this.ticksWaited;
			}
		}
		super.tick();
	}

	public boolean canUse() {
		return super.canUse();
	}

	public void start() {
		this.ticksWaited = 0;
		super.start();
	}

}
