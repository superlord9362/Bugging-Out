package superlord.bugs.common.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import superlord.bugs.init.BOBlocks;

public class TermiteMushroomSporesItem extends Item {

	public TermiteMushroomSporesItem(Properties p_41383_) {
		super(p_41383_);
	}

	public InteractionResult useOn(UseOnContext context) {
		if (context.getLevel().getBlockState(context.getClickedPos()).is(BOBlocks.POROUS_TERMOSTONE.get())) {
			context.getLevel().setBlock(context.getClickedPos(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
			if (!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
		}
		return InteractionResult.PASS;
	}

}
