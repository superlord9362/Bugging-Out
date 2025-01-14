package superlord.bugs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import superlord.bugs.BuggingOut;
import superlord.bugs.init.BOItems;

@Mixin(ForgeGui.class)
public abstract class GasMaskOverlayMixin {

	private static final ResourceLocation GAS_MASK_LOCATION = new ResourceLocation(BuggingOut.MOD_ID, "textures/misc/gas_mask.png");

	@SuppressWarnings({ "resource" })
	@Inject(method = "renderHelmet", at = @At("HEAD"))
	void renderHelmet(float f, GuiGraphics guiGraphics, CallbackInfo ci) {
		ItemStack itemstack = Minecraft.getInstance().player.getInventory().getArmor(3);
		if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && !itemstack.isEmpty()) {
			Item item = itemstack.getItem();
			if (item == BOItems.GAS_MASK.get())
			{
				renderTextureOverlay(guiGraphics, GAS_MASK_LOCATION, 1.0F);
			}
		}

	}

	@SuppressWarnings("resource")
	void renderTextureOverlay(GuiGraphics p_282304_, ResourceLocation p_281622_, float p_281504_) {
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		p_282304_.setColor(1.0F, 1.0F, 1.0F, p_281504_);
		p_282304_.blit(p_281622_, 0, 0, -90, 0.0F, 0.0F, Minecraft.getInstance().gui.screenWidth, Minecraft.getInstance().gui.screenHeight, Minecraft.getInstance().gui.screenWidth, Minecraft.getInstance().gui.screenHeight);
		RenderSystem.depthMask(true);
		RenderSystem.enableDepthTest();
		p_282304_.setColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

}
