package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteWorkerModel;
import superlord.bugs.common.entity.TermiteWorker;

public class TermiteWorkerRenderer extends MobRenderer<TermiteWorker, TermiteWorkerModel> {
	
	private static final ResourceLocation TERMITE_WORKER = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_worker.png");

	public TermiteWorkerRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteWorkerModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_WORKER)), 1.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteWorker entity) {
		return TERMITE_WORKER;
	}

}
