package superlord.bugs.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.common.entity.Springtail;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOItems;

public class SpringtailItem extends Item {

	public SpringtailItem(Properties p_41383_) {
		super(p_41383_);
	}

	@SuppressWarnings("deprecation")
	public InteractionResult useOn(UseOnContext p_43223_) {
		Level level = p_43223_.getLevel();
		ItemStack itemstack = p_43223_.getItemInHand();
		Item item = itemstack.getItem();
		BlockPos blockpos = p_43223_.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		if (blockstate.isSolid()) {
			if (item == BOItems.PURPLE_SPRINGTAIL.get()) {
				Springtail springtail = new Springtail(BOEntities.SPRINGTAIL.get(), level);
				springtail.setPos(p_43223_.getClickLocation().x, p_43223_.getClickLocation().y, p_43223_.getClickLocation().z);
				springtail.setPurple(true);
				level.addFreshEntity(springtail);
				itemstack.shrink(1);
			} else {
				Springtail springtail = new Springtail(BOEntities.SPRINGTAIL.get(), level);
				springtail.setPos(p_43223_.getClickLocation().x, p_43223_.getClickLocation().y, p_43223_.getClickLocation().z);
				springtail.setPurple(false);
				level.addFreshEntity(springtail);
				itemstack.shrink(1);
			}
		}
        return InteractionResult.SUCCESS;
	}

}
