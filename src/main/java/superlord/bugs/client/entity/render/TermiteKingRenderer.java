package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteKingModel;
import superlord.bugs.common.entity.TermiteKing;

public class TermiteKingRenderer extends MobRenderer<TermiteKing, TermiteKingModel> {
	
	private static final ResourceLocation TERMITE_KING = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_king.png");

	public TermiteKingRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteKingModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_KING)), 1);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteKing entity) {
		return TERMITE_KING;
	}

}
