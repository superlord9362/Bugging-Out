package superlord.bugs.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOItems;

public class Springtail extends PathfinderMob {
	private static final EntityDataAccessor<Boolean> PURPLE = SynchedEntityData.defineId(Springtail.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MANDIBLE_MOVING = SynchedEntityData.defineId(Springtail.class, EntityDataSerializers.BOOLEAN);
	private int jumpTicks;
	private int jumpDuration;
	private boolean wasOnGround;
	private int jumpDelayTicks;

	public Springtail(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
		super(p_21683_, p_21684_);
		this.jumpControl = new Springtail.SpringtailJumpControl(this);
		this.moveControl = new Springtail.SpringtailMoveControl(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new TemptGoal(this, 1.0D, Ingredient.of(BOItems.MOLD_SPORE_SPREADER.get(), BOItems.MOLD_CARPET.get(), BOItems.MOLD_STALKS.get()), false));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(2, new Springtail.SpringtailEatMoldGoal((double)1.2F, 12, 1));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 10.0F));
	}

	protected float getJumpPower() {
		float f = 0.3F;
		if (this.horizontalCollision || this.moveControl.hasWanted() && this.moveControl.getWantedY() > this.getY() + 0.5D) {
			f = 0.5F;
		}

		Path path = this.navigation.getPath();
		if (path != null && !path.isDone()) {
			Vec3 vec3 = path.getNextEntityPos(this);
			if (vec3.y > this.getY() + 0.5D) {
				f = 0.5F;
			}
		}
		if (this.moveControl.getSpeedModifier() <= 0.6D) {
			f = 0.2F;
		}
		return f + this.getJumpBoostPower();
	}

	public InteractionResult mobInteract(Player player, InteractionHand p_28299_) {
		Level world = player.level();
		if (this.isPurple()) {
			ItemEntity purple = new ItemEntity(world, (double) this.getX(), (double) this.getY(), (double) this.getZ(), new ItemStack(BOItems.PURPLE_SPRINGTAIL.get()));
			world.addFreshEntity(purple);
			this.remove(RemovalReason.DISCARDED);
		} else {
			ItemEntity yellow = new ItemEntity(world, (double) this.getX(), (double) this.getY(), (double) this.getZ(), new ItemStack(BOItems.YELLOW_SPRINGTAIL.get()));
			world.addFreshEntity(yellow);
			this.remove(RemovalReason.DISCARDED);
		}
		return super.mobInteract(player, p_28299_);
	}

	@SuppressWarnings("resource")
	protected void jumpFromGround() {
		super.jumpFromGround();
		double d0 = this.moveControl.getSpeedModifier();
		if (d0 > 0.0D) {
			double d1 = this.getDeltaMovement().horizontalDistanceSqr();
			if (d1 < 0.01D) {
				this.moveRelative(0.1F, new Vec3(0.0D, 0.0D, 1.0D));
			}
		}
		if (!this.level().isClientSide) {
			this.level().broadcastEntityEvent(this, (byte)1);
		}
	}

	public float getJumpCompletion(float jumpProgress) {
		return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + jumpProgress) / (float)this.jumpDuration;
	}

	public void setSpeedModifier(double p_29726_) {
		this.getNavigation().setSpeedModifier(p_29726_);
		this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), p_29726_);
	}

	public void setJumping(boolean p_29732_) {
		super.setJumping(p_29732_);
	}

	public void startJumping() {
		this.setJumping(true);
		this.jumpDuration = 10;
		this.jumpTicks = 0;
	}

	public boolean isPurple() {
		return this.entityData.get(PURPLE);
	}

	public void setPurple(boolean isPurple) {
		this.entityData.set(PURPLE, isPurple);
	}

	public boolean areMandiblesMoving() {
		return this.entityData.get(MANDIBLE_MOVING);
	}

	private void setMandiblesMoving(boolean areMandiblesMoving) {
		this.entityData.set(MANDIBLE_MOVING, areMandiblesMoving);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PURPLE, false);
		this.entityData.define(MANDIBLE_MOVING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsPurple", this.isPurple());
		compound.putBoolean("AreMandiblesMoving", this.areMandiblesMoving());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setPurple(compound.getBoolean("IsPurple"));
		this.setMandiblesMoving(compound.getBoolean("AreMandiblesMoving"));
	}

	@SuppressWarnings("deprecation")
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(2);
		if (birthNumber == 0) {
			this.setPurple(true);
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void customServerAiStep() {
		if (this.jumpDelayTicks > 0) {
			--this.jumpDelayTicks;
		}

		if (this.onGround()) {
			if (!this.wasOnGround) {
				this.setJumping(false);
				this.checkLandingDelay();
			}

			Springtail.SpringtailJumpControl springtail$springtailjumpcontrol = (Springtail.SpringtailJumpControl)this.jumpControl;
			if (!springtail$springtailjumpcontrol.wantJump()) {
				if (this.moveControl.hasWanted() && this.jumpDelayTicks == 0) {
					Path path = this.navigation.getPath();
					Vec3 vec3 = new Vec3(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());
					if (path != null && !path.isDone()) {
						vec3 = path.getNextEntityPos(this);
					}
					this.facePoint(vec3.x, vec3.z);
					this.startJumping();
				}
			} else if (!springtail$springtailjumpcontrol.canJump()) {
				this.enableJumpControl();
			}
		}

		this.wasOnGround = this.onGround();
	}

	private void facePoint(double faceX, double faceZ) {
		this.setYRot((float)(Mth.atan2(faceZ - this.getZ() , faceX - this.getX()) * (double)(180F / (float)Math.PI)) - 90.0F);
	}

	private void enableJumpControl() {
		((Springtail.SpringtailJumpControl)this.jumpControl).setCanJump(true);
	}

	private void disableJumpControl() {
		((Springtail.SpringtailJumpControl)this.jumpControl).setCanJump(false);
	}

	private void setLandingDelay() {
		if (this.moveControl.getSpeedModifier() < 2.2D) {
			this.jumpDelayTicks = 5;
		} else {
			this.jumpDelayTicks = 1;
		}
	}

	private void checkLandingDelay() {
		this.setLandingDelay();
		this.disableJumpControl();
	}

	public void aiStep() {
		super.aiStep();
		if (this.jumpTicks != this.jumpDuration) {
			++this.jumpTicks;
		} else if (this.jumpDuration != 0) {
			this.jumpTicks = 0;
			this.jumpDuration = 0;
			this.setJumping(false);
		}
		int mandibleMovementAllowed = random.nextInt(100);
		if (mandibleMovementAllowed < 2) {
			setMandiblesMoving(true);
		} else if (mandibleMovementAllowed > 95) {
			setMandiblesMoving(false);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F);
	}

	public static class SpringtailJumpControl extends JumpControl {
		private final Springtail springtail;
		private boolean canJump;

		public SpringtailJumpControl(Springtail springtail) {
			super(springtail);
			this.springtail = springtail;
		}

		public boolean wantJump() {
			return this.jump;
		}

		public boolean canJump() {
			return this.canJump;
		}

		public void setCanJump(boolean canJump) {
			this.canJump = canJump;
		}

		public void tick() {
			if (this.jump) {
				this.springtail.startJumping();
				this.jump = false;
			}
		}
	}

	static class SpringtailMoveControl extends MoveControl {
		private final Springtail springtail;
		private double nextJumpSpeed;

		public SpringtailMoveControl(Springtail springtail) {
			super(springtail);
			this.springtail = springtail;
		}

		public void tick() {
			if (this.springtail.onGround() && !this.springtail.jumping && !((Springtail.SpringtailJumpControl)this.springtail.jumpControl).wantJump()) {
				this.springtail.setSpeedModifier(0.0D);
			} else if (this.hasWanted()) {
				this.springtail.setSpeedModifier(this.nextJumpSpeed);
			}
			super.tick();
		}

		public void setWantedPosition(double p_29769_, double p_29770_, double p_29771_, double p_29772_) {
			if (this.springtail.isInWater()) {
				p_29772_ = 1.5D;
			}

			super.setWantedPosition(p_29769_, p_29770_, p_29771_, p_29772_);
			if (p_29772_ > 0.0D) {
				this.nextJumpSpeed = p_29772_;
			}

		}
	}

	public class SpringtailEatMoldGoal extends MoveToBlockGoal {
		protected int ticksWaited;

		public SpringtailEatMoldGoal(double p_28675_, int p_28676_, int p_28677_) {
			super(Springtail.this, p_28675_, p_28676_, p_28677_);
		}

		public double acceptedDistance() {
			return 2.0D;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 100 == 0;
		}

		protected boolean isValidTarget(LevelReader p_28680_, BlockPos p_28681_) {
			BlockState blockstate = p_28680_.getBlockState(p_28681_);
			return blockstate.is(BOBlocks.MOLD_CARPET.get());
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
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Springtail.this.level(), Springtail.this)) {
				BlockState blockstate = Springtail.this.level().getBlockState(this.blockPos);
				if (blockstate.is(BOBlocks.MOLD_CARPET.get())) {
					Springtail.this.level().setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
				}

			}
		}

		public boolean canUse() {
			return super.canUse();
		}

		public void start() {
			this.ticksWaited = 0;
			super.start();
		}
	}
	
	public static boolean canSpringtailSpawn(EntityType<? extends Springtail> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return random.nextFloat() > 0.95F && (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(BOBlocks.ROTTEN_LOG.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.ROTTEN_WOOD.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.MOLD_CARPET.get()) || worldIn.getBlockState(pos.below()).is(BOBlocks.MOLD_STALKS.get()));
	}

}
