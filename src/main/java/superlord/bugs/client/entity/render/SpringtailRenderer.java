package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.SpringtailModel;
import superlord.bugs.common.entity.Springtail;

public class SpringtailRenderer extends MobRenderer<Springtail, SpringtailModel> {

	private static final ResourceLocation YELLOW_SPRINGTAIL = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/springtail/yellow_springtail.png");
	private static final ResourceLocation PINK_SPRINGTAIL = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/springtail/pink_springtail.png");
	
	public SpringtailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SpringtailModel(renderManagerIn.bakeLayer(ClientEvents.SPRINGTAIL)), 1.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Springtail entity) {
		if (entity.isPurple()) {
			return PINK_SPRINGTAIL;
		} else return YELLOW_SPRINGTAIL;
	}
	
}
