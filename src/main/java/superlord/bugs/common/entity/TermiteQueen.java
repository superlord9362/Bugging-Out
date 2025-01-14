package superlord.bugs.common.entity;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
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

public class TermiteQueen extends PathfinderMob {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(TermiteQueen.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HAS_KING = SynchedEntityData.defineId(TermiteQueen.class, EntityDataSerializers.BOOLEAN);
	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS));

	public TermiteQueen(EntityType<? extends TermiteQueen> type, Level world) {
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
	
	public boolean hasKing() {
		return this.entityData.get(HAS_KING);
	}
	
	private void setHasKing(boolean hasKing) {
		this.entityData.set(HAS_KING, hasKing);
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
			super(TermiteQueen.this, 1.25D, true);
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
		this.entityData.define(HAS_KING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("AreMandiblesMoving", this.areMandiblesMoving());
		compound.putBoolean("HasKing", this.hasKing());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setMandiblesMoving(compound.getBoolean("AreMandiblesMoving"));
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
		this.setHasKing(compound.getBoolean("HasKing"));
	}
	
	public void setCustomName(@Nullable Component p_31476_) {
		super.setCustomName(p_31476_);
		this.bossEvent.setName(this.getDisplayName());
	}
	
	protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
	}
	
	public void startSeenByPlayer(ServerPlayer p_31483_) {
	      super.startSeenByPlayer(p_31483_);
	      this.bossEvent.addPlayer(p_31483_);
	   }

	   public void stopSeenByPlayer(ServerPlayer p_31488_) {
	      super.stopSeenByPlayer(p_31488_);
	      this.bossEvent.removePlayer(p_31488_);
	   }

	@SuppressWarnings("unused")
	@Override
	public void aiStep() {
		super.aiStep();
		for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8, 4, 8))) {
			if (entity.hasEffect(BOEffects.TERMITES_VENGEANCE.get())) {
				this.setTarget(entity);
			}
		}
		for (TermiteKing entity : this.level().getEntitiesOfClass(TermiteKing.class, getBoundingBox().inflate(48, 48, 48))) {
			this.setHasKing(true);
		}
		this.setHasKing(false);
		int mandibleMovementAllowed = random.nextInt(100);
		if (mandibleMovementAllowed < 2) {
			setMandiblesMoving(true);
		} else if (mandibleMovementAllowed > 95) {
			setMandiblesMoving(false);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).add(Attributes.MOVEMENT_SPEED, 0.05D).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
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
	
	public static boolean canTermiteSpawn(EntityType<? extends TermiteSoldier> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.CRUMBLY_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.FERROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.GLOW_WORM_HOLE.get()));
    }
	
	
}
