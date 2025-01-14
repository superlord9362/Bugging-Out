package superlord.bugs.common.entity;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.common.block.BarkBeetleInfestedBlock;
import superlord.bugs.init.BOBlocks;

public class BarkBeetle extends PathfinderMob {
	@Nullable
	private BarkBeetleWakeUpFriendsGoal friendsGoal;

	public BarkBeetle(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
		super(p_21683_, p_21684_);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.friendsGoal = new BarkBeetleWakeUpFriendsGoal(this);
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 6));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(0, new MeleeAttackGoal());
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal(this, true));
		this.goalSelector.addGoal(5, new BarkBeetleMergeWithRottenWoodGoal(this));
		this.goalSelector.addGoal(0, this.friendsGoal);
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {

		public MeleeAttackGoal() {
			super(BarkBeetle.this, 1.25D, true);
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

	public static boolean canBarkBeetleSpawn(EntityType<? extends BarkBeetle> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.ROTTEN_LOG.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.ROTTEN_WOOD.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.MULCH.get()));
	}

	static class BarkBeetleMergeWithRottenWoodGoal extends RandomStrollGoal {
		@Nullable
		private Direction selectedDirection;
		private boolean doMerge;

		public BarkBeetleMergeWithRottenWoodGoal(BarkBeetle p_33558_) {
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
					if (BarkBeetleInfestedBlock.isCompatibleHostBlock(blockstate)) {
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
				if (BarkBeetleInfestedBlock.isCompatibleHostBlock(blockstate)) {
					levelaccessor.setBlock(blockpos, BarkBeetleInfestedBlock.infestedStateByHost(blockstate), 3);
					this.mob.spawnAnim();
					this.mob.discard();
				}

			}
		}
	}

	public boolean hurt(DamageSource p_33527_, float p_33528_) {
		if (this.isInvulnerableTo(p_33527_)) {
			return false;
		} else {
			if ((p_33527_.getEntity() != null || p_33527_.is(DamageTypeTags.ALWAYS_TRIGGERS_SILVERFISH)) && this.friendsGoal != null) {
				this.friendsGoal.notifyHurt();
			}

			return super.hurt(p_33527_, p_33528_);
		}
	}

	static class BarkBeetleWakeUpFriendsGoal extends Goal {
		private final BarkBeetle barkBeetle;
		private int lookForFriends;

		public BarkBeetleWakeUpFriendsGoal(BarkBeetle barkBeetle) {
			this.barkBeetle = barkBeetle;
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
				Level level = this.barkBeetle.level();
				RandomSource random = this.barkBeetle.getRandom();
				BlockPos blockpos = this.barkBeetle.blockPosition();

				for(int i = 0; i <= 5 && i >= -5; i = (i <= 0 ? 1 : 0) - i) {
					for(int j = 0; j <= 10 && j >= -10; j = (j <= 0 ? 1 : 0) - j) {
						for(int k = 0; k <= 10 && k >= -10; k = (k <= 0 ? 1 : 0) - k) {
							BlockPos blockpos1 = blockpos.offset(j, i, k);
							BlockState blockstate = level.getBlockState(blockpos1);
							Block block = blockstate.getBlock();
							if (block instanceof BarkBeetleInfestedBlock) {
								if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, this.barkBeetle)) {
									level.destroyBlock(blockpos1, true, this.barkBeetle);
								} else {
									level.setBlock(blockpos1, ((BarkBeetleInfestedBlock)block).hostStateByInfested(level.getBlockState(blockpos1)), 3);
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

}
