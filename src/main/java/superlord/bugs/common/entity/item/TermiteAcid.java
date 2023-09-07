package superlord.bugs.common.entity.item;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOCreatureAttributes;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOItems;

public class TermiteAcid extends ThrowableItemProjectile {

	public TermiteAcid(EntityType<? extends TermiteAcid> termiteAcid, Level world) {
		super(termiteAcid, world);
	}

	public TermiteAcid(Level world, LivingEntity thrower) {
		super(BOEntities.TERMITE_ACID.get(), thrower, world);
	}

	public TermiteAcid(Level world, double x, double y, double z) {
		super(BOEntities.TERMITE_ACID.get(), x, y, z, world);
	}

	protected Item getDefaultItem() {
		return BOItems.TERMITE_ACID.get();
	}

	@Nonnull
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	protected void onHit(HitResult result) {
		super.onHit(result);
		this.discard();
	}

	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		BlockPos pos = result.getBlockPos();
		Direction dir = result.getDirection();
		if (dir == Direction.UP) {
			this.level.setBlock(pos.above(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
		}
		if (dir == Direction.EAST && this.level.getBlockState(pos.east()).isAir() && this.level.getBlockState(pos.east().below()).isFaceSturdy(level, pos.east().above(), Direction.UP)) {
			this.level.setBlock(pos.east(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
		}
		if (dir == Direction.WEST && this.level.getBlockState(pos.west()).isAir() && this.level.getBlockState(pos.west().below()).isFaceSturdy(level, pos.west().above(), Direction.UP)) {
			this.level.setBlock(pos.west(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
		}
		if (dir == Direction.NORTH && this.level.getBlockState(pos.north()).isAir() && this.level.getBlockState(pos.north().below()).isFaceSturdy(level, pos.north().above(), Direction.UP)) {
			this.level.setBlock(pos.north(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
		}
		if (dir == Direction.SOUTH && this.level.getBlockState(pos.south()).isAir() && this.level.getBlockState(pos.south().below()).isFaceSturdy(level, pos.south().above(), Direction.UP)) {
			this.level.setBlock(pos.south(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
		}
	}

	private ParticleOptions getParticle() {
		return new BlockParticleOption(ParticleTypes.BLOCK, Blocks.GLASS.defaultBlockState());
	}

	public void handleEntityEvent(byte p_37402_) {
		if (p_37402_ == 3) {
			ParticleOptions particleoptions = this.getParticle();

			for(int i = 0; i < 8; ++i) {
				this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	protected void onHitEntity(EntityHitResult p_37404_) {
		super.onHitEntity(p_37404_);
		Entity entity = p_37404_.getEntity();
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) entity;
			if (livingEntity.getMobType() == BOCreatureAttributes.TERMITE) {
				livingEntity.hurt(DamageSource.thrown(this, this.getOwner()), 1);
			}
		}
		BlockPos pos = entity.getOnPos();
		this.level.setBlock(pos.above(), BOBlocks.ACID_SPLAT.get().defaultBlockState(), 2);
	}

}
