package superlord.bugs.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.entity.PartEntity;

public class GlowwormPart extends PartEntity<Glowworm> {

	public final Glowworm parentMob;
	public final String name;
	private final EntityDimensions size;

	public GlowwormPart(Glowworm glowworm, String name, float width, float height) {
		super(glowworm);
		this.size = EntityDimensions.scalable(width, height);
		this.refreshDimensions();
		this.parentMob = glowworm;
		this.name = name;
	}

	protected void defineSynchedData() {
	}

	protected void readAdditionalSaveData(CompoundTag p_31025_) {
	}

	protected void addAdditionalSaveData(CompoundTag p_31028_) {
	}

	public boolean isPickable() {
		return true;
	}

	public boolean hurt(DamageSource p_31020_, float p_31021_) {
		return this.isInvulnerableTo(p_31020_) ? false : this.parentMob.damagePart(this, p_31020_, p_31021_);
	}

	public boolean is(Entity p_31031_) {
		return this == p_31031_ || this.parentMob == p_31031_;
	}

	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		throw new UnsupportedOperationException();
	}

	public EntityDimensions getDimensions(Pose p_31023_) {
		return this.size;
	}

	public boolean shouldBeSaved() {
		return false;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D);
	}

}
