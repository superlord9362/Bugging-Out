package superlord.bugs.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.common.block.TermiteMushroomBlock;
import superlord.bugs.common.entity.goal.AttractedToGlowwormHoleGoal;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOCreatureAttributes;
import superlord.bugs.init.BOEffects;

public class TermiteWorker extends Animal {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(TermiteWorker.class, EntityDataSerializers.BOOLEAN);

	public TermiteWorker(EntityType<? extends TermiteWorker> type, Level world) {
		super(type, world);
	}
	
	public MobType getMobType() {
		return BOCreatureAttributes.TERMITE;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	public boolean areMandiblesMoving() {
		return this.entityData.get(MANDIBLE_MOVING);
	}

	private void setMandiblesMoving(boolean areMandiblesMoving) {
		this.entityData.set(MANDIBLE_MOVING, areMandiblesMoving);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 6));
		this.goalSelector.addGoal(0, new MeleeAttackGoal());
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal(this, true));
		this.goalSelector.addGoal(2, new TermiteEatMushroomGoal((double)1.2F, 12, 1));
		this.goalSelector.addGoal(2, new AttractedToGlowwormHoleGoal(this, 1.0F, 6));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {

		public MeleeAttackGoal() {
			super(TermiteWorker.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if(this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(8.0F + attackTarget.getBbWidth());
		}

	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(MANDIBLE_MOVING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("AreMandiblesMoving", this.areMandiblesMoving());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setMandiblesMoving(compound.getBoolean("AreMandiblesMoving"));
	}

	@Override
	public void aiStep() {
		super.aiStep();
		for (LivingEntity entity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8, 4, 8))) {
			if (entity.hasEffect(BOEffects.TERMITES_VENGEANCE.get())) {
				this.setTarget(entity);
			}
		}
		int mandibleMovementAllowed = random.nextInt(100);
		if (mandibleMovementAllowed < 2) {
			setMandiblesMoving(true);
		} else if (mandibleMovementAllowed > 95) {
			setMandiblesMoving(false);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	public class TermiteEatMushroomGoal extends MoveToBlockGoal {
		protected int ticksWaited;

		public TermiteEatMushroomGoal(double p_28675_, int p_28676_, int p_28677_) {
			super(TermiteWorker.this, p_28675_, p_28676_, p_28677_);
		}

		public double acceptedDistance() {
			return 2.0D;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 100 == 0;
		}

		protected boolean isValidTarget(LevelReader p_28680_, BlockPos p_28681_) {
			BlockState blockstate = p_28680_.getBlockState(p_28681_);
			return blockstate.is(BOBlocks.TERMITE_MUSHROOM.get()) && blockstate.getValue(TermiteMushroomBlock.AGE) >= 4;
		}

		public void tick() {
			if (this.isReachedTarget()) {
				if (this.ticksWaited >= 40) {
					this.onReachedTarget();
				} else {
					++this.ticksWaited;
				}
			}

			super.tick();
		}

		protected void onReachedTarget() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(TermiteWorker.this.level, TermiteWorker.this)) {
				BlockState blockstate = TermiteWorker.this.level.getBlockState(this.blockPos);
				if (blockstate.is(BOBlocks.TERMITE_MUSHROOM.get())) {
					this.pickMushroom(blockstate);
				}

			}
		}

		private void pickMushroom(BlockState p_148929_) {
			TermiteWorker.this.level.setBlock(this.blockPos, Blocks.AIR.defaultBlockState(), 2);
		}

		public boolean canUse() {
			return !TermiteWorker.this.isSleeping() && super.canUse();
		}

		public void start() {
			this.ticksWaited = 0;
			super.start();
		}
	}
	
	public boolean isAlliedTo(Entity entity) {
		if (super.isAlliedTo(entity)) {
			return true;
		} else if (entity instanceof LivingEntity && ((LivingEntity)entity).getMobType() == BOCreatureAttributes.TERMITE) {
			return this.getTeam() == null && entity.getTeam() == null;
		} else {
			return false;
		}
	}

}
