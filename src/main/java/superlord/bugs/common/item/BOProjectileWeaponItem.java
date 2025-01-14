package superlord.bugs.common.item;

import java.util.function.Predicate;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import superlord.bugs.init.BOItems;

public abstract class BOProjectileWeaponItem extends Item {
	public static final Predicate<ItemStack> SPLINTER = (p_43017_) -> {
		return p_43017_.is(BOItems.SPLINTER.get());
	};

	public BOProjectileWeaponItem(Item.Properties p_43009_) {
		super(p_43009_);
	}

	public Predicate<ItemStack> getSupportedHeldProjectiles() {
		return this.getAllSupportedProjectiles();
	}

	public abstract Predicate<ItemStack> getAllSupportedProjectiles();

	public static ItemStack getHeldProjectile(LivingEntity p_43011_, Predicate<ItemStack> p_43012_) {
		if (p_43012_.test(p_43011_.getItemInHand(InteractionHand.OFF_HAND))) {
			return p_43011_.getItemInHand(InteractionHand.OFF_HAND);
		} else {
			return p_43012_.test(p_43011_.getItemInHand(InteractionHand.MAIN_HAND)) ? p_43011_.getItemInHand(InteractionHand.MAIN_HAND) : ItemStack.EMPTY;
		}
	}

	public int getEnchantmentValue() {
		return 1;
	}

	public abstract int getDefaultProjectileRange();
}
