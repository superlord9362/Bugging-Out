package superlord.bugs.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import superlord.bugs.common.entity.item.AbstractSplinter;
import superlord.bugs.common.entity.item.Splinter;

public class SplinterItem extends Item {
	public SplinterItem(Item.Properties p_40512_) {
		super(p_40512_);
	}

	public AbstractSplinter createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
		Splinter splinter = new Splinter(p_40513_, p_40515_);
		return splinter;
	}

	@SuppressWarnings("deprecation")
	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
		int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == SplinterItem.class;
	}
}
