package superlord.bugs.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOItems;

public class BOBoat extends Boat {
	private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(BOBoat.class, EntityDataSerializers.INT);

	public BOBoat(EntityType<? extends Entity> entityType, Level level) {
		super(BOEntities.BOAT.get(), level);
	}

	public BOBoat(Level level, double positionX, double positionY, double positionZ) {
		super(BOEntities.BOAT.get(), level);
		this.setPos(positionX, positionY, positionZ);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = positionX;
		this.yo = positionY;
		this.zo = positionZ;
	}

	public BOBoat(PlayMessages.SpawnEntity spawnEntity, Level level) {
		this(BOEntities.BOAT.get(), level);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("WoodType", this.getBOBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("WoodType", 8)) this.setBOBoatType(BOBoatTypes.byName(compound.getString("WoodType")));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(BOAT_TYPE, BOBoatTypes.ROTTEN.ordinal());
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setBOBoatType(BOBoatTypes type) {
		this.entityData.set(BOAT_TYPE, type.ordinal());
	}

	public BOBoatTypes getBOBoatType() {
		return BOBoatTypes.byId(this.entityData.get(BOAT_TYPE));
	}

	@Override
	public Boat.Type getVariant() {
		return Boat.Type.OAK;
	}

	public void setVariant(BOBoatTypes type) {
	}

	@Override
	public Item getDropItem() {
		switch(this.getBOBoatType()) {
		case ROTTEN:
		default:
			return BOItems.ROTTEN_BOAT.get();
		}
	}
	
	public enum BOBoatTypes {
		ROTTEN(BOBlocks.ROTTEN_PLANKS.get(), "rotten");
		
		private final String name;
		private final Block planks;
		
		BOBoatTypes(Block planks, String name) {
			this.name = name;
			this.planks = planks;
		}
		
		public String getName() {
			return this.name;
		}
		
		public Block getPlanks() {
			return this.planks;
		}
		
		public String toString() {
			return this.name;
		}
		
		public static BOBoatTypes byId(int id) {
			BOBoatTypes[] boatEntityType = values();
			if (id < 0 || id >= boatEntityType.length) {
				id = 0;
			}
			return boatEntityType[id];
		}
		
		public static BOBoatTypes byName(String name) {
			BOBoatTypes[] boatEntityType = values();
			
			for (int i = 0; i < boatEntityType.length; ++i) {
				if (boatEntityType[i].getName().equals(name)) {
					return boatEntityType[i];
				}
			}
			return boatEntityType[0];
		}
		
	}
	
}
