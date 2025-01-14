package superlord.bugs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import superlord.bugs.init.BOItems;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin {
		
	@SuppressWarnings({ "resource", "rawtypes" })
	@Inject(method = "getFieldOfViewModifier", at = @At("RETURN"))
	public float getFieldOfViewModifier(CallbackInfoReturnable ci) {
		AbstractClientPlayer player = Minecraft.getInstance().player;
		float f = 1.0F;
	      if (player.getAbilities().flying) {
	         f *= 1.1F;
	      }

	      f *= ((float)player.getAttributeValue(Attributes.MOVEMENT_SPEED) / player.getAbilities().getWalkingSpeed() + 1.0F) / 2.0F;
	      if (player.getAbilities().getWalkingSpeed() == 0.0F || Float.isNaN(f) || Float.isInfinite(f)) {
	         f = 1.0F;
	      }

	      ItemStack itemstack = player.getUseItem();
	      if (player.isUsingItem()) {
	         if (itemstack.is(Items.BOW) || itemstack.is(BOItems.SPLINTER_BOW.get())) {
	            int i = player.getTicksUsingItem();
	            float f1 = (float)i / 20.0F;
	            if (f1 > 1.0F) {
	               f1 = 1.0F;
	            } else {
	               f1 *= f1;
	            }

	            f *= 1.0F - f1 * 0.15F;
	         } else if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && player.isScoping()) {
	            return 0.1F;
	         }
	      }

	      return net.minecraftforge.client.ForgeHooksClient.getFieldOfViewModifier(player, f);
	}


}
