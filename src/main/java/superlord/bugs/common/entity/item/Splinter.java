package superlord.bugs.common.entity.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOItems;

public class Splinter extends AbstractSplinter {

	public Splinter(EntityType<? extends Splinter> p_36858_, Level p_36859_) {
		super(p_36858_, p_36859_);
	}

	public Splinter(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {
		super(BOEntities.SPLINTER.get(), p_36862_, p_36863_, p_36864_, p_36861_);
	}

	public Splinter(Level p_36866_, LivingEntity p_36867_) {
		super(BOEntities.SPLINTER.get(), p_36867_, p_36866_);
	}

	protected ItemStack getPickupItem() {
		return new ItemStack(BOItems.SPLINTER.get());
	}

}
