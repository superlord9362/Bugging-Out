package superlord.bugs.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.TermiteSoldierModel;
import superlord.bugs.common.entity.TermiteSoldier;

public class TermiteSoldierRenderer extends MobRenderer<TermiteSoldier, TermiteSoldierModel> {
	
	private static final ResourceLocation TERMITE_SOLDIER = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/termite_soldier.png");

	public TermiteSoldierRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TermiteSoldierModel(renderManagerIn.bakeLayer(ClientEvents.TERMITE_SOLDIER)), 1.25F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TermiteSoldier entity) {
		return TERMITE_SOLDIER;
	}

}
