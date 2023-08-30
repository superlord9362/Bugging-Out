package superlord.bugs.common.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.registries.RegistryObject;

public class BOSpawnEggItem extends SpawnEggItem {
	
	public static final List<BOSpawnEggItem> UNADDED_EGGS = new ArrayList<BOSpawnEggItem>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;
	
	@SuppressWarnings("deprecation")
	public BOSpawnEggItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}
	
	@SuppressWarnings("deprecation")
	public BOSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
	}
	
	@Override
	public EntityType<?> getType(CompoundTag nbt) {
		return this.entityTypeSupplier.get();
	}

}
