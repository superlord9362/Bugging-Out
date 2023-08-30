package superlord.bugs.common.entity;

import javax.annotation.Nullable;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import superlord.bugs.common.block.util.WoodExplosion;
import superlord.bugs.init.BOEntities;

public class TNTree extends Entity {
	private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(TNTree.class, EntityDataSerializers.INT);
	@Nullable
	private LivingEntity owner;

	public TNTree(EntityType<? extends TNTree> p_32076_, Level p_32077_) {
		super(p_32076_, p_32077_);
		this.blocksBuilding = true;
	}

	public TNTree(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
		this(BOEntities.TNTREE.get(), p_32079_);
		this.setPos(p_32080_, p_32081_, p_32082_);
		double d0 = p_32079_.random.nextDouble() * (double)((float)Math.PI * 2F);
		this.setDeltaMovement(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
		this.setFuse(80);
		this.xo = p_32080_;
		this.yo = p_32081_;
		this.zo = p_32082_;
		this.owner = p_32083_;
	}

	protected void defineSynchedData() {
		this.entityData.define(DATA_FUSE_ID, 80);
	}

	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}

	public boolean isPickable() {
		return !this.isRemoved();
	}

	public void tick() {
		if (!this.isNoGravity()) {
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
		}

		this.move(MoverType.SELF, this.getDeltaMovement());
		this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
		if (this.onGround) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
		}

		int i = this.getFuse() - 1;
		this.setFuse(i);
		if (i <= 0) {
			this.discard();
			if (!this.level.isClientSide) {
				this.explode();
			}
		} else {
			this.updateInWaterStateAndDoFluidPushing();
			if (this.level.isClientSide) {
				this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}

	protected void explode() {
		this.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, WoodExplosion.BlockInteraction.BREAK);
	}

	protected void addAdditionalSaveData(CompoundTag p_32097_) {
		p_32097_.putShort("Fuse", (short)this.getFuse());
	}

	protected void readAdditionalSaveData(CompoundTag p_32091_) {
		this.setFuse(p_32091_.getShort("Fuse"));
	}

	@Nullable
	public LivingEntity getOwner() {
		return this.owner;
	}

	protected float getEyeHeight(Pose p_32088_, EntityDimensions p_32089_) {
		return 0.15F;
	}

	public void setFuse(int p_32086_) {
		this.entityData.set(DATA_FUSE_ID, p_32086_);
	}

	public int getFuse() {
		return this.entityData.get(DATA_FUSE_ID);
	}

	public Packet<?> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this);
	}

	public WoodExplosion explode(@Nullable Entity p_46526_, @Nullable DamageSource p_46527_, @Nullable ExplosionDamageCalculator p_46528_, double p_46529_, double p_46530_, double p_46531_, float p_46532_, boolean p_46533_, WoodExplosion.BlockInteraction p_46534_) {
		WoodExplosion explosion = new WoodExplosion(this.level, p_46526_, p_46527_, p_46528_, p_46529_, p_46530_, p_46531_, p_46532_, p_46533_, p_46534_);
		if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this.level, explosion)) return explosion;
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}

	public WoodExplosion explode(@Nullable Entity p_46512_, double p_46513_, double p_46514_, double p_46515_, float p_46516_, WoodExplosion.BlockInteraction p_46517_) {
		return this.explode(p_46512_, (DamageSource)null, (ExplosionDamageCalculator)null, p_46513_, p_46514_, p_46515_, p_46516_, false, p_46517_);
	}

	public WoodExplosion explode(@Nullable Entity p_46519_, double p_46520_, double p_46521_, double p_46522_, float p_46523_, boolean p_46524_, WoodExplosion.BlockInteraction p_46525_) {
		return this.explode(p_46519_, (DamageSource)null, (ExplosionDamageCalculator)null, p_46520_, p_46521_, p_46522_, p_46523_, p_46524_, p_46525_);
	}
}