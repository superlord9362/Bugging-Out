package superlord.bugs.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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
import superlord.bugs.init.BOEntities;

public class TermiteNymph extends Animal {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(TermiteNymph.class, EntityDataSerializers.BOOLEAN);

	public TermiteNymph(EntityType<? extends TermiteNymph> type, Level world) {
		super(type, world);
	}

	public MobType getCreatureAttribute() {
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

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 6));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new TermiteEatMushroomGoal((double)1.2F, 12, 1));
		this.goalSelector.addGoal(2, new AttractedToGlowwormHoleGoal(this, 1.0F, 6));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {

		public MeleeAttackGoal() {
			super(TermiteNymph.this, 1.25D, true);
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
		int mandibleMovementAllowed = random.nextInt(100);
		if (mandibleMovementAllowed < 2) {
			setMandiblesMoving(true);
		} else if (mandibleMovementAllowed > 95) {
			setMandiblesMoving(false);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	public boolean hurt(DamageSource source, float damage) {
		if (source.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) source.getEntity();
			entity.addEffect(new MobEffectInstance(BOEffects.TERMITES_VENGEANCE.get(), 600, 0, false, false, true));
		}
		return super.hurt(source, damage);
	}

	public class TermiteEatMushroomGoal extends MoveToBlockGoal {
		protected int ticksWaited;

		public TermiteEatMushroomGoal(double p_28675_, int p_28676_, int p_28677_) {
			super(TermiteNymph.this, p_28675_, p_28676_, p_28677_);
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
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(TermiteNymph.this.level, TermiteNymph.this)) {
				BlockState blockstate = TermiteNymph.this.level.getBlockState(this.blockPos);
				if (blockstate.is(BOBlocks.TERMITE_MUSHROOM.get())) {
					this.pickMushroom(blockstate);
				}

			}
		}

		private void pickMushroom(BlockState p_148929_) {
			int growthChance = TermiteNymph.this.random.nextInt(50);
			TermiteNymph.this.level.setBlock(this.blockPos, Blocks.AIR.defaultBlockState(), 2);
			if (growthChance == 0) {
				BlockPos pos = TermiteNymph.this.blockPosition();
				Level level = TermiteNymph.this.getLevel();
				TermiteWorker worker = new TermiteWorker(BOEntities.TERMITE_WORKER.get(), level);
				TermiteNymph.this.remove(RemovalReason.DISCARDED);
				level.addFreshEntity(worker);
				worker.setPos(pos.getX(), pos.getY(), pos.getZ());
			}
			if (growthChance == 1) {
				BlockPos pos = TermiteNymph.this.blockPosition();
				Level level = TermiteNymph.this.getLevel();
				TermiteSoldier soldier = new TermiteSoldier(BOEntities.TERMITE_SOLDIER.get(), level);
				TermiteNymph.this.remove(RemovalReason.DISCARDED);
				level.addFreshEntity(soldier);
				soldier.setPos(pos.getX(), pos.getY(), pos.getZ());
			}
		}

		public boolean canUse() {
			return !TermiteNymph.this.isSleeping() && super.canUse();
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
