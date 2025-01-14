package superlord.bugs.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import superlord.bugs.common.entity.goal.AttractedToGlowwormHoleGoal;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOCreatureAttributes;
import superlord.bugs.init.BOEffects;

public class TermiteKamikaze extends PathfinderMob {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(TermiteKamikaze.class, EntityDataSerializers.BOOLEAN);
	int blowUpTicks = 0;

	public TermiteKamikaze(EntityType<? extends TermiteKamikaze> type, Level world) {
		super(type, world);
	}

	public MobType getMobType() {
		return BOCreatureAttributes.TERMITE;
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
		this.goalSelector.addGoal(2, new AttractedToGlowwormHoleGoal(this, 1.0F, 6));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {

		public MeleeAttackGoal() {
			super(TermiteKamikaze.this, 1.25D, true);
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
		for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8, 4, 8))) {
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
		int blowSelfUp = random.nextInt(100);
		if (this.getTarget() != null && blowSelfUp == 0 || blowUpTicks != 0) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
			blowUpTicks++;
			Level world = this.level();
			BlockPos pos = this.getOnPos();
			int acid1 = random.nextInt(2);
			int acid2 = random.nextInt(2);
			int acid3 = random.nextInt(2);
			int acid4 = random.nextInt(2);
			int acid5 = random.nextInt(2);
			int acid6 = random.nextInt(2);
			int acid7 = random.nextInt(2);
			int acid8 = random.nextInt(2);
			int acid9 = random.nextInt(2);
			if (blowUpTicks >= 60) {
				if (world.isEmptyBlock(pos.above()) && world.getBlockState(pos.above()).canBeReplaced() && world.getBlockState(pos).isFaceSturdy(world, pos, Direction.UP) && acid1 == 0) {
					world.setBlock(pos.above(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().east()) && world.getBlockState(pos.east().above()).canBeReplaced() && world.getBlockState(pos.east()).isFaceSturdy(world, pos.east(), Direction.UP) && acid2 == 0) {
					world.setBlock(pos.above().east(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().west()) && world.getBlockState(pos.west().above()).canBeReplaced() && world.getBlockState(pos.west()).isFaceSturdy(world, pos.west(), Direction.UP) && acid3 == 0) {
					world.setBlock(pos.above().west(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().north()) && world.getBlockState(pos.north().above()).canBeReplaced() && world.getBlockState(pos.north()).isFaceSturdy(world, pos.north(), Direction.UP) && acid4 == 0) {
					world.setBlock(pos.above().north(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().south()) && world.getBlockState(pos.south().above()).canBeReplaced() && world.getBlockState(pos.south()).isFaceSturdy(world, pos.south(), Direction.UP) && acid5 == 0) {
					world.setBlock(pos.above().south(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().north().west()) && world.getBlockState(pos.north().west().above()).canBeReplaced() && world.getBlockState(pos.north().west()).isFaceSturdy(world, pos.north().west(), Direction.UP) && acid6 == 0) {
					world.setBlock(pos.above().north().west(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().north().east()) && world.getBlockState(pos.north().east().above()).canBeReplaced() && world.getBlockState(pos.north().east()).isFaceSturdy(world, pos.north().east(), Direction.UP) && acid7 == 0) {
					world.setBlock(pos.above().north().east(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().south().west()) && world.getBlockState(pos.south().west().above()).canBeReplaced() && world.getBlockState(pos.south().west()).isFaceSturdy(world, pos.south().west(), Direction.UP) && acid8 == 0) {
					world.setBlock(pos.above().south().west(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				if (world.isEmptyBlock(pos.above().south().east()) && world.getBlockState(pos.south().east().above()).canBeReplaced() && world.getBlockState(pos.south().east()).isFaceSturdy(world, pos.south().east(), Direction.UP) && acid9 == 0) {
					world.setBlock(pos.above().south().east(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
				}
				level().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + 0.2F, this.getZ(), 0, 0, 0);
				this.remove(RemovalReason.KILLED);
			}
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
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

	public static boolean canTermiteSpawn(EntityType<? extends TermiteKamikaze> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.CRUMBLY_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.FERROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.GLOW_WORM_HOLE.get()));
	}

}
