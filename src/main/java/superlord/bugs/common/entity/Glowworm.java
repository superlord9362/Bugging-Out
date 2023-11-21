package superlord.bugs.common.entity;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.init.BOBlocks;

public class Glowworm extends PathfinderMob {

	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(Glowworm.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ATTACHED_TO_HOLE = SynchedEntityData.defineId(Glowworm.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ENTITY_IN_RANGE = SynchedEntityData.defineId(Glowworm.class, EntityDataSerializers.BOOLEAN);
	BlockPos holePos;

	private final GlowwormPart[] subEntities;
	private final GlowwormPart segment_2;
	private final GlowwormPart segment_1;
	private final GlowwormPart Head_shield;
	private final GlowwormPart Head;

	public Glowworm(EntityType<? extends Glowworm> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
		this.segment_2 = new GlowwormPart(this, "segment_2", 0.75F, 0.5F);
		this.segment_1 = new GlowwormPart(this, "segment_1", 0.75F, 0.5F);
		this.Head_shield = new GlowwormPart(this, "Head_shield", 0.75F, 0.5F);
		this.Head = new GlowwormPart(this, "Head", 0.75F, 0.5F);
		this.subEntities = new GlowwormPart[]{this.segment_2, this.segment_1, this.Head_shield, this.Head};
	}

	@Override
	public boolean isMultipartEntity() {
		return true;
	}

	@Override
	public net.minecraftforge.entity.PartEntity<?>[] getParts() {
		return this.subEntities;
	}

	public void recreateFromPacket(ClientboundAddEntityPacket p_149572_) {
		super.recreateFromPacket(p_149572_);
		GlowwormPart[] glowwormPart = this.getSubEntities();

		for(int i = 0; i < glowwormPart.length; ++i) {
			glowwormPart[i].setId(i + p_149572_.getId());
		}
	}

	public GlowwormPart[] getSubEntities() {
		return this.subEntities;
	}

	public boolean damagePart(GlowwormPart part, DamageSource source, float damage) {
		return this.hurt(source, damage);
	}

	public boolean areMandiblesMoving() {
		return this.entityData.get(MANDIBLE_MOVING);
	}

	private void setMandiblesMoving(boolean areMandiblesMoving) {
		this.entityData.set(MANDIBLE_MOVING, areMandiblesMoving);
	}

	public boolean isAttachedToHole() {
		return this.entityData.get(ATTACHED_TO_HOLE);
	}

	public void setAttachedToHole(boolean isAttachedToHole) {
		this.entityData.set(ATTACHED_TO_HOLE, isAttachedToHole);
	}

	public boolean isEntityInRange() {
		return this.entityData.get(ENTITY_IN_RANGE);
	}

	private void setEntityInRange(boolean isEntityInRange) {
		this.entityData.set(ENTITY_IN_RANGE, isEntityInRange);
	}


	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new GlowwormRandomLookAroundGoal(this));
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, LivingEntity.class, 6, 100, false));
		this.goalSelector.addGoal(0, new MeleeAttackGoal());
		this.targetSelector.addGoal(2, new GoToHoleGoal((double)1.2F, 12, 1));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, true));
		//		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.1D).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 3.0D);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {

		public MeleeAttackGoal() {
			super(Glowworm.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Glowworm.this.doHurtTarget(enemy);
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
			return (double)(48.0F + attackTarget.getBbWidth());
		}

	}

	protected void updateParts() {
		double f1 = this.yBodyRot * (Math.PI / 180F);
		double f2 = (Math.sin(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) / 2;
		double f3 = (Math.cos(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) / 2;
		double f4 = (Math.sin(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) * 1.5F;
		double f5 = (Math.cos(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) * 1.5F;
		double f6 = (Math.sin(f1 - 6.5F * -1.2F) * 1.25F * 1.25F);
		double f7 = (Math.cos(f1 - 6.5F * -1.2F) * 1.25F * 1.25F);
		double f8 = (Math.sin(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) * 2.5F;
		double f9 = (Math.cos(f1 - 6.5F * -1.2F) * 1.25F * 1.25F) * 2.5F;

		movePart(segment_2, f3, 0.1f, f2);
		movePart(segment_1, f7, 0.1F, f6);
		movePart(Head_shield, f5, 0.1F, f4);
		movePart(Head, f9, 0.1F, f8);
	}

	protected void movePart(GlowwormPart part, double dX, double dY, double dZ)
	{
		Vec3 lastPos = new Vec3(part.getX(), part.getY(), part.getZ());

		part.setPos(this.getX() + dX, this.getY() + dY, this.getZ() + dZ);

		part.xo = lastPos.x;
		part.yo = lastPos.y;
		part.zo = lastPos.z;
		part.xOld = lastPos.x;
		part.yOld = lastPos.y;
		part.zOld = lastPos.z;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(MANDIBLE_MOVING, false);
		this.entityData.define(ATTACHED_TO_HOLE, false);
		this.entityData.define(ENTITY_IN_RANGE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("AreMandiblesMoving", this.areMandiblesMoving());
		compound.putBoolean("IsAttachedToHole", this.isAttachedToHole());
		compound.putBoolean("EntityInRange", this.isEntityInRange());
		if (this.hasHole()) {
			compound.put("HolePos", NbtUtils.writeBlockPos(this.getHolePos()));
		}
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setMandiblesMoving(compound.getBoolean("AreMandiblesMoving"));
		this.setAttachedToHole(compound.getBoolean("IsAttachedToHole"));
		this.setEntityInRange(compound.getBoolean("EntityInRange"));
		this.holePos = null;
		if (compound.contains("HolePos")) {
			this.holePos = NbtUtils.readBlockPos(compound.getCompound("HolePos"));
		}
	}

	public boolean hasHole() {
		return this.holePos != null;
	}

	@Nullable
	public BlockPos getHolePos() {
		return this.holePos;
	}

	@SuppressWarnings("resource")
	public void aiStep() {
		super.aiStep();
		if (!level().isClientSide) {
			updateParts();
			if (!this.isHoleValid()) {
				this.setAttachedToHole(false);
				this.holePos = null;
			}
			int mandibleMovementAllowed = random.nextInt(100);
			if (this.isAttachedToHole()) {
				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
				setMandiblesMoving(false);
				for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(5, 0, 5))) {
					if (entity != null && !(entity instanceof Glowworm)) {
						if (this.holePos != null) {
							Direction direction = this.level().getBlockState(holePos).getValue(GlowWormHoleBlock.FACING);
							if (direction == Direction.SOUTH) {
								if (this.position() != new Vec3(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.999))
									this.moveTo(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.999);
							}
							if (direction == Direction.NORTH) {
								if (this.position() != new Vec3(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.001))
									this.moveTo(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.001);
							}
							if (direction == Direction.EAST) {
								if (this.position() != new Vec3(this.holePos.getX() + 0.999, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5))
									this.moveTo(this.holePos.getX() + 0.999, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5);
							}
							if (direction == Direction.WEST) {
								if (this.position() != new Vec3(this.holePos.getX() + 0.001, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5))
									this.moveTo(this.holePos.getX() + 0.001, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5F);
							}
						}
						this.setEntityInRange(true);
					} else {
						this.setEntityInRange(false);
						if (this.holePos != null) {
							Direction direction = this.level().getBlockState(holePos).getValue(GlowWormHoleBlock.FACING);
							this.lookControl.setLookAt(holePos.getX() + 0.5F, holePos.getY() + 1F, holePos.getZ() + 0.5F);
							if (direction == Direction.SOUTH) {
								if (this.position() != new Vec3(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() - 2.5)) this.moveTo(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() - 2.5);
							}
							if (direction == Direction.NORTH) {
								this.moveTo(this.holePos.getX() + 0.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 3.5);
							}
							if (direction == Direction.EAST) {
								this.moveTo(this.holePos.getX() - 2.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5);
							}
							if (direction == Direction.WEST) {
								this.moveTo(this.holePos.getX() + 3.5, this.holePos.getY() + 0.25F, this.holePos.getZ() + 0.5F);
							}
						}
					}
				}
			} else {
				if (mandibleMovementAllowed < 2) {
					setMandiblesMoving(true);
				} else if (mandibleMovementAllowed > 95) {
					setMandiblesMoving(false);
				}

				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
			}
		}
	}

	@Override
	public boolean isInWall() {
		if (this.hasHole()) {
			return false;
		} else {
			return super.isInWall();
		}
	}

	public boolean isHoleValid() {
		if (!this.hasHole()) {
			return false;
		} else {
			Block block = this.level().getBlockState(this.holePos).getBlock();
			return block == BOBlocks.GLOW_WORM_HOLE.get();
		}
	}

	public class GlowwormRandomLookAroundGoal extends RandomLookAroundGoal {

		public GlowwormRandomLookAroundGoal(Mob p_25720_) {
			super(p_25720_);
		}

		public boolean canUse() {
			return (!Glowworm.this.isAttachedToHole()) && super.canUse();
		}
	}

	public class GlowwormWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {

		public GlowwormWaterAvoidingRandomStrollGoal(PathfinderMob p_25987_, double p_25988_) {
			super(p_25987_, p_25988_);
		}

		public boolean canUse() {
			return super.canUse();
		}
	}

	public class GoToHoleGoal extends MoveToBlockGoal {
		protected int ticksWaited;

		public GoToHoleGoal(double p_28675_, int p_28676_, int p_28677_) {
			super(Glowworm.this, p_28675_, p_28676_, p_28677_);
		}

		public double acceptedDistance() {
			return 2.0D;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 100 == 0;
		}

		protected boolean isValidTarget(LevelReader p_28680_, BlockPos p_28681_) {
			BlockState blockstate = p_28680_.getBlockState(p_28681_);
			return blockstate.is(BOBlocks.GLOW_WORM_HOLE.get()) && blockstate.getValue(GlowWormHoleBlock.HAS_GLOWWORM) == false;
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
			BlockState blockstate = Glowworm.this.level().getBlockState(this.blockPos);
			if (blockstate.is(BOBlocks.GLOW_WORM_HOLE.get())) {
				this.hideInHole(blockstate);
			}
		}

		private void hideInHole(BlockState p_148929_) {
			BlockState blockState = Glowworm.this.level().getBlockState(this.blockPos);
			Glowworm.this.level().setBlock(this.blockPos, blockState.setValue(GlowWormHoleBlock.HAS_GLOWWORM, true), 2);
			Glowworm.this.holePos = blockPos;
			Glowworm.this.setAttachedToHole(true);
		}

		public boolean canUse() {
			return !Glowworm.this.hasHole() && super.canUse();
		}

		public void start() {
			this.ticksWaited = 0;
			super.start();
		}
	}

	public int getGlowwormBrightness(boolean sky) {
		BlockPos eyePos = BlockPos.containing(this.getEyePosition(1.0F));
		while (eyePos.getY() < 256 && !level().isEmptyBlock(eyePos)) {
			eyePos = eyePos.above();
		}
		int light = this.level().getBrightness(sky ? LightLayer.SKY : LightLayer.BLOCK, eyePos.above());
		return light;
	}

	public class GlowwormAttackGoal extends NearestAttackableTargetGoal<LivingEntity> {
		Glowworm glowworm;

		public GlowwormAttackGoal(Glowworm glowworm) {
			super(glowworm, LivingEntity.class, true);
			this.glowworm = glowworm;
		}

		public void tick() {
			super.tick();
			glowworm.setTarget(mob);
		}

		public boolean canUse() {
			return mob != glowworm && super.canUse();
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	public static boolean canGlowwormSpawn(EntityType<? extends Glowworm> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.CRUMBLY_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.FERROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.INFESTED_POROUS_TERMOSTONE.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.GLOW_WORM_HOLE.get()));
	}

}
