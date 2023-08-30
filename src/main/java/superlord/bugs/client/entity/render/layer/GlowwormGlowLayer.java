package superlord.bugs.client.entity.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.entity.model.GlowwormModel;
import superlord.bugs.common.entity.Glowworm;

public class GlowwormGlowLayer extends RenderLayer<Glowworm, GlowwormModel> {

	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/glowworm_glow_layer.png"));
	private final RenderLayerParent<Glowworm, GlowwormModel> glowwormRenderer;
	
	public GlowwormGlowLayer(RenderLayerParent<Glowworm, GlowwormModel> rendererIn) {
		super(rendererIn);
		this.glowwormRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, Glowworm glowworm, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(glowwormRenderer.getModel() instanceof GlowwormModel)) {
			return;
		}
		RenderType tex = TEXTURE;
		VertexConsumer ivertexbuilder = buffer.getBuffer(tex);
		this.getParentModel().renderToBuffer(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}
	
}
