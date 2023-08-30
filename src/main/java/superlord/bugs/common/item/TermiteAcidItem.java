package superlord.bugs.common.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import superlord.bugs.common.entity.item.TermiteAcid;

public class TermiteAcidItem extends Item {
	public TermiteAcidItem(Item.Properties p_43140_) {
		super(p_43140_);
	}

	public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
		ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
		if (!p_43142_.isClientSide) {
			TermiteAcid termiteAcid = new TermiteAcid(p_43142_, p_43143_);
			termiteAcid.setItem(itemstack);
			termiteAcid.shootFromRotation(p_43143_, p_43143_.getXRot(), p_43143_.getYRot(), 0.0F, 1.5F, 1.0F);
			p_43142_.addFreshEntity(termiteAcid);
		}

		p_43143_.awardStat(Stats.ITEM_USED.get(this));
		if (!p_43143_.getAbilities().instabuild) {
			itemstack.shrink(1);
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_43142_.isClientSide());
	}
}
