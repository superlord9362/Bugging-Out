package superlord.bugs.common.entity;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.common.block.TermiteInfestedBlock;
import superlord.bugs.common.block.TermiteMushroomBlock;
import superlord.bugs.common.entity.goal.AttractedToGlowwormHoleGoal;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOCreatureAttributes;
import superlord.bugs.init.BOEffects;
import superlord.bugs.init.BOEntities;

public class TermiteNymph extends PathfinderMob {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(TermiteNymph.class, EntityDataSerializers.BOOLEAN);

	public TermiteNymph(EntityType<? extends TermiteNymph> type, Level world) {
		super(type, world);
	}

	@Override
	public MobType getMobType() {
		return BOCreatureAttributes.TERMITE;
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
		this.goalSelector.addGoal(5, new TermiteMergeWithPorousTermostoneGoal(this));
		this.goalSelector.addGoal(1, new TermiteNymph.TermiteNymphWakeUpFriendsGoal(this));
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
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(TermiteNymph.this.level(), TermiteNymph.this)) {
				BlockState blockstate = TermiteNymph.this.level().getBlockState(this.blockPos);
				if (blockstate.is(BOBlocks.TERMITE_MUSHROOM.get())) {
					this.pickMushroom(blockstate);
				}

			}
		}

		private void pickMushroom(BlockState p_148929_) {
			int growthChance = TermiteNymph.this.random.nextInt(50);
			TermiteNymph.this.level().setBlock(this.blockPos, Blocks.AIR.defaultBlockState(), 2);
			if (growthChance == 0) {
				BlockPos pos = TermiteNymph.this.blockPosition();
				Level level = TermiteNymph.this.level();
				TermiteWorker worker = new TermiteWorker(BOEntities.TERMITE_WORKER.get(), level);
				TermiteNymph.this.remove(RemovalReason.DISCARDED);
				level.addFreshEntity(worker);
				worker.setPos(pos.getX(), pos.getY(), pos.getZ());
			}
			if (growthChance == 1) {
				BlockPos pos = TermiteNymph.this.blockPosition();
				Level level = TermiteNymph.this.level();
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

	static class TermiteMergeWithPorousTermostoneGoal extends RandomStrollGoal {
		@Nullable
		private Direction selectedDirection;
		private boolean doMerge;

		public TermiteMergeWithPorousTermostoneGoal(TermiteNymph p_33558_) {
			super(p_33558_, 1.0D, 10);
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (this.mob.getTarget() != null) {
				return false;
			} else if (!this.mob.getNavigation().isDone()) {
				return false;
			} else {
				RandomSource random = this.mob.getRandom();
				if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.mob.level(), this.mob) && random.nextInt(10) == 0) {
					this.selectedDirection = Direction.getRandom(random);
					BlockPos blockpos = (BlockPos.containing(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ())).relative(this.selectedDirection);
					BlockState blockstate = this.mob.level().getBlockState(blockpos);
					if (TermiteInfestedBlock.isCompatibleHostBlock(blockstate)) {
						this.doMerge = true;
						return true;
					}
				}

				this.doMerge = false;
				return super.canUse();
			}
		}

		public boolean canContinueToUse() {
			return this.doMerge ? false : super.canContinueToUse();
		}

		public void start() {
			if (!this.doMerge) {
				super.start();
			} else {
				LevelAccessor levelaccessor = this.mob.level();
				BlockPos blockpos = (BlockPos.containing(this.mob.getX(), this.mob.getY() + 0.5D, this.mob.getZ())).relative(this.selectedDirection);
				BlockState blockstate = levelaccessor.getBlockState(blockpos);
				if (TermiteInfestedBlock.isCompatibleHostBlock(blockstate)) {
					levelaccessor.setBlock(blockpos, TermiteInfestedBlock.infestedStateByHost(blockstate), 3);
					this.mob.spawnAnim();
					this.mob.discard();
				}

			}
		}
	}

	static class TermiteNymphWakeUpFriendsGoal extends Goal {
		private final TermiteNymph termiteNymph;
		private int lookForFriends;

		public TermiteNymphWakeUpFriendsGoal(TermiteNymph p_33565_) {
			this.termiteNymph = p_33565_;
		}

		public void notifyHurt() {
			if (this.lookForFriends == 0) {
				this.lookForFriends = this.adjustedTickDelay(20);
			}

		}

		public boolean canUse() {
			return this.lookForFriends > 0;
		}

		public void tick() {
			--this.lookForFriends;
			if (this.lookForFriends <= 0) {
				Level level = this.termiteNymph.level();
				RandomSource random = this.termiteNymph.getRandom();
				BlockPos blockpos = this.termiteNymph.blockPosition();

				for(int i = 0; i <= 5 && i >= -5; i = (i <= 0 ? 1 : 0) - i) {
					for(int j = 0; j <= 10 && j >= -10; j = (j <= 0 ? 1 : 0) - j) {
						for(int k = 0; k <= 10 && k >= -10; k = (k <= 0 ? 1 : 0) - k) {
							BlockPos blockpos1 = blockpos.offset(j, i, k);
							BlockState blockstate = level.getBlockState(blockpos1);
							Block block = blockstate.getBlock();
							if (block instanceof TermiteInfestedBlock) {
								if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, this.termiteNymph)) {
									level.destroyBlock(blockpos1, true, this.termiteNymph);
								} else {
									level.setBlock(blockpos1, ((TermiteInfestedBlock)block).hostStateByInfested(level.getBlockState(blockpos1)), 3);
								}

								if (random.nextBoolean()) {
									return;
								}
							}
						}
					}
				}
			}

		}
	}

	public static boolean canTermiteSpawn(EntityType<? extends TermiteNymph> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.CRUMBLY_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.FERROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.GLOW_WORM_HOLE.get()));
	}

}
