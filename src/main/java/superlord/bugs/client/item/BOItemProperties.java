package superlord.bugs.client.item;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.bugs.BuggingOut;
import superlord.bugs.init.BOItems;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class BOItemProperties extends ItemProperties {

	private static void register(Item p_174571_, ResourceLocation p_174572_, ClampedItemPropertyFunction p_174573_) {
		register(p_174571_, p_174572_, (ItemPropertyFunction) p_174573_);
	}

	static {
		register(BOItems.SPLINTER_BOW.get(), new ResourceLocation(BuggingOut.MOD_ID, "pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
			if (p_174637_ == null) {
				System.out.println("Hi");
				return 0.0F;
			} else {
				System.out.println("Hello");
				return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		register(BOItems.SPLINTER_BOW.get(), new ResourceLocation(BuggingOut.MOD_ID, "pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
			return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
		});
	}

}
