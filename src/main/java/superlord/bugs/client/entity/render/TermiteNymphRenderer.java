package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteNymphModel;
import superlord.bugs.common.entity.TermiteNymph;

public class TermiteNymphRenderer extends MobRenderer<TermiteNymph, TermiteNymphModel> {
	
	private static final ResourceLocation TERMITE_NYMPH = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_nymph.png");

	public TermiteNymphRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteNymphModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_NYMPH)), 0.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteNymph entity) {
		return TERMITE_NYMPH;
	}

}
