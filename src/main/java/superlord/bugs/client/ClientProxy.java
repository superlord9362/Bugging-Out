package superlord.bugs.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.CommonProxy;
import superlord.bugs.common.particle.TermiteMushroomSporeParticle;
import superlord.bugs.common.particle.TermostoneDustParticle;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOParticles;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public void init() {
	}
	
	public static void setupPartciles(RegisterParticleProvidersEvent registry) {
		registry.registerSpriteSet(BOParticles.TERMITE_MUSHROOM_SPORE.get(), TermiteMushroomSporeParticle.Provider::new);
		registry.registerSpriteSet(BOParticles.TERMOSTONE_DUST.get(), TermostoneDustParticle.Provider::new);
	}
	
	@SuppressWarnings("deprecation")
	public static void setUpBlockRenders() {
		RenderType cutoutRenderType = RenderType.cutout();
		RenderType translucentRenderType = RenderType.translucent();
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.TERMITE_MUSHROOM.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.ACID_SPLAT.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.SPLINTERS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.ROTTEN_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.ROTTEN_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.FUZZY_MOSS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.TERMOSTONE_GLASS.get(), translucentRenderType);
	}

}
