package superlord.bugs.client.entity.render.item;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import superlord.bugs.common.entity.item.TermiteAcid;

public class TermiteAcidRenderer extends ThrownItemRenderer<TermiteAcid> {

	public TermiteAcidRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}
}
