package superlord.bugs.common.item;

import java.util.function.Predicate;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import superlord.bugs.common.entity.item.AbstractSplinter;
import superlord.bugs.init.BOItems;

public class SplinterBowItem extends BOProjectileWeaponItem implements Vanishable {
	public static final int MAX_DRAW_DURATION = 20;
	public static final int DEFAULT_RANGE = 15;

	public SplinterBowItem(Item.Properties p_40660_) {
		super(p_40660_);
	}

	@SuppressWarnings("deprecation")
	public void releaseUsing(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
		if (p_40669_ instanceof Player player) {
			boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_40667_) > 0;
			ItemStack itemstack = getProjectile(player, p_40667_);

			int i = this.getUseDuration(p_40667_) - p_40670_;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40667_, p_40668_, player, i, !itemstack.isEmpty() || flag);
			if (i < 0) return;

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(BOItems.SPLINTER.get());
				}

				float f = getPowerForTime(i);
				if (!((double)f < 0.1D)) {
					boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof SplinterItem && ((SplinterItem)itemstack.getItem()).isInfinite(itemstack, p_40667_, player));
					if (!p_40668_.isClientSide) {
						SplinterItem splinteritem = (SplinterItem)(itemstack.getItem() instanceof SplinterItem ? itemstack.getItem() : BOItems.SPLINTER.get());
						AbstractSplinter abstracsplinter = splinteritem.createArrow(p_40668_, itemstack, player);
						abstracsplinter = customArrow(abstracsplinter);
						abstracsplinter.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
						if (f == 1.0F) {
							abstracsplinter.setCritArrow(true);
						}

						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, p_40667_);
						if (j > 0) {
							abstracsplinter.setBaseDamage(abstracsplinter.getBaseDamage() + (double)j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, p_40667_);
						if (k > 0) {
							abstracsplinter.setKnockback(k);
						}

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_40667_) > 0) {
							abstracsplinter.setSecondsOnFire(100);
						}

						p_40667_.hurtAndBreak(1, player, (p_289501_) -> {
							p_289501_.broadcastBreakEvent(player.getUsedItemHand());
						});
						if (flag1 || player.getAbilities().instabuild) {
							abstracsplinter.pickup = AbstractSplinter.Pickup.CREATIVE_ONLY;
						}

						p_40668_.addFreshEntity(abstracsplinter);
					}

					p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!flag1 && !player.getAbilities().instabuild) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.getInventory().removeItem(itemstack);
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}

	public static float getPowerForTime(int p_40662_) {
		float f = (float)p_40662_ / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	public int getUseDuration(ItemStack p_40680_) {
		return 72000;
	}

	public UseAnim getUseAnimation(ItemStack p_40678_) {
		return UseAnim.BOW;
	}
	
	public ItemStack getProjectile(Player player, ItemStack p_36349_) {
	      if (!(p_36349_.getItem() instanceof BOProjectileWeaponItem)) {
	         return ItemStack.EMPTY;
	      } else {
	         Predicate<ItemStack> predicate = ((BOProjectileWeaponItem)p_36349_.getItem()).getSupportedHeldProjectiles();
	         ItemStack itemstack = BOProjectileWeaponItem.getHeldProjectile(player, predicate);
	         if (!itemstack.isEmpty()) {
	            return net.minecraftforge.common.ForgeHooks.getProjectile(player, p_36349_, itemstack);
	         } else {
	            predicate = ((BOProjectileWeaponItem)p_36349_.getItem()).getAllSupportedProjectiles();

	            for(int i = 0; i < player.getInventory().getContainerSize(); ++i) {
	               ItemStack itemstack1 = player.getInventory().getItem(i);
	               if (predicate.test(itemstack1)) {
	                  return net.minecraftforge.common.ForgeHooks.getProjectile(player, p_36349_, itemstack1);
	               }
	            }

	            return net.minecraftforge.common.ForgeHooks.getProjectile(player, p_36349_, player.getAbilities().instabuild ? new ItemStack(BOItems.SPLINTER.get()) : ItemStack.EMPTY);
	         }
	      }
	   }

	public InteractionResultHolder<ItemStack> use(Level p_40672_, Player player, InteractionHand p_40674_) {
		ItemStack itemstack = player.getItemInHand(p_40674_);
		boolean flag = !getProjectile(player, itemstack).isEmpty();

		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_40672_, player, p_40674_, flag);
		if (ret != null) return ret;

		if (!player.getAbilities().instabuild && !flag) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			player.startUsingItem(p_40674_);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return SPLINTER;
	}

	public AbstractSplinter customArrow(AbstractSplinter splinter) {
		return splinter;
	}

	public int getDefaultProjectileRange() {
		return 15;
	}
}

