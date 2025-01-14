package superlord.bugs.client.entity.render.item;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.item.Splinter;

public class SplinterRenderer extends AbstractSplinterRenderer<Splinter> {
	public static final ResourceLocation SPLINTER_LOCATION = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/projectiles/splinter.png");

	   public SplinterRenderer(EntityRendererProvider.Context p_174422_) {
	      super(p_174422_);
	   }

	   public ResourceLocation getTextureLocation(Splinter p_116140_) {
	      return SPLINTER_LOCATION;
	   }
	}