package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteQueenModel;
import superlord.bugs.common.entity.TermiteQueen;

public class TermiteQueenRenderer extends MobRenderer<TermiteQueen, TermiteQueenModel> {
	
	private static final ResourceLocation TERMITE_QUEEN = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_queen.png");

	public TermiteQueenRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteQueenModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_QUEEN)), 1);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteQueen entity) {
		return TERMITE_QUEEN;
	}

}
