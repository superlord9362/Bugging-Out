package superlord.bugs.client.entity.render;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.GlowwormModel;
import superlord.bugs.client.entity.render.layer.GlowwormGlowLayer;
import superlord.bugs.common.entity.Glowworm;

public class GlowwormRenderer extends MobRenderer<Glowworm, GlowwormModel> {
	
	private static final ResourceLocation GLOWWORM = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/glowworm.png");
	private static final ResourceLocation GLOWWORM_HIDING = new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/glowworm_hiding.png");

	public GlowwormRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GlowwormModel(renderManagerIn.bakeLayer(ClientEvents.GLOWWORM)), 1F);
		this.addLayer(new GlowwormGlowLayer(this));
	}
	
	@Override
	public ResourceLocation getTextureLocation(Glowworm entity) {
		if (entity.isAttachedToHole() && !entity.isEntityInRange()) return GLOWWORM_HIDING;
		else return GLOWWORM;
	}
	
	@Override
    protected int getBlockLightLevel(Glowworm entityIn, @NotNull BlockPos partialTicks) {
        return entityIn.isOnFire() ? 15 : entityIn.getGlowwormBrightness(false);
    }

    @Override
    protected int getSkyLightLevel(Glowworm entity, @NotNull BlockPos pos) {
        return entity.getGlowwormBrightness(true);
    }

}
