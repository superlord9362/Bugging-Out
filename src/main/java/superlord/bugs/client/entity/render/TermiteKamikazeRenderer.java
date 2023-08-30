package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteKamikazeModel;
import superlord.bugs.common.entity.TermiteKamikaze;

public class TermiteKamikazeRenderer extends MobRenderer<TermiteKamikaze, TermiteKamikazeModel> {
	
	private static final ResourceLocation TERMITE_KAMIKAZE = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_kamikaze.png");

	public TermiteKamikazeRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteKamikazeModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_KAMIKAZE)), 1.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteKamikaze entity) {
		return TERMITE_KAMIKAZE;
	}

}
