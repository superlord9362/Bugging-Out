package superlord.bugs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import superlord.bugs.init.BOItems;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRenderMixin {

	@SuppressWarnings("rawtypes")
	@Inject(method = "evaluateWhichHandsToRender", at = @At("RETURN"))
	private static ItemInHandRenderer.HandRenderSelection checkItemIsSplinterBow(LocalPlayer p_172915_, CallbackInfoReturnable ci) {
		ItemStack itemstack = p_172915_.getMainHandItem();
		ItemStack itemstack1 = p_172915_.getOffhandItem();
		boolean flag = itemstack.is(Items.BOW) || itemstack1.is(Items.BOW);
		boolean flag1 = itemstack.is(Items.CROSSBOW) || itemstack1.is(Items.CROSSBOW);
		boolean flag2 = itemstack.is(BOItems.SPLINTER_BOW.get()) || itemstack1.is(BOItems.SPLINTER_BOW.get());
		if (!flag && !flag1 && !flag2) {
			return ItemInHandRenderer.HandRenderSelection.RENDER_BOTH_HANDS;
		} else if (p_172915_.isUsingItem()) {
			return selectionUsingItemWhileHoldingBowLike(p_172915_);
		} else {
			return isChargedCrossbow(itemstack) ? ItemInHandRenderer.HandRenderSelection.RENDER_MAIN_HAND_ONLY : ItemInHandRenderer.HandRenderSelection.RENDER_BOTH_HANDS;
		}
	}

	private static ItemInHandRenderer.HandRenderSelection selectionUsingItemWhileHoldingBowLike(LocalPlayer p_172917_) {
		ItemStack itemstack = p_172917_.getUseItem();
		InteractionHand interactionhand = p_172917_.getUsedItemHand();
		if (!itemstack.is(Items.BOW) && !itemstack.is(Items.CROSSBOW) && !itemstack.is(BOItems.SPLINTER_BOW.get())) {
			return interactionhand == InteractionHand.MAIN_HAND && isChargedCrossbow(p_172917_.getOffhandItem()) ? ItemInHandRenderer.HandRenderSelection.RENDER_MAIN_HAND_ONLY : ItemInHandRenderer.HandRenderSelection.RENDER_BOTH_HANDS;
		} else {
			return ItemInHandRenderer.HandRenderSelection.onlyForHand(interactionhand);
		}
	}

	private static boolean isChargedCrossbow(ItemStack p_172913_) {
		return p_172913_.is(Items.CROSSBOW) && CrossbowItem.isCharged(p_172913_);
	}

}
