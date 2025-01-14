package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.BarkBeetleModel;
import superlord.bugs.common.entity.BarkBeetle;

public class BarkBeetleRenderer extends MobRenderer<BarkBeetle, BarkBeetleModel> {
	
	private static final ResourceLocation BARK_BEETLE = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/bark_beetle.png");

	public BarkBeetleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BarkBeetleModel(renderManagerIn.bakeLayer(ClientEvents.BARK_BEETLE)), 1.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(BarkBeetle entity) {
		return BARK_BEETLE;
	}

}
