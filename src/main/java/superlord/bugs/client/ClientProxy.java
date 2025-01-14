package superlord.bugs.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.item.GasMaskRenderProperties;
import superlord.bugs.common.CommonProxy;
import superlord.bugs.common.particle.MoldSporeParticle;
import superlord.bugs.common.particle.TermiteMushroomSporeParticle;
import superlord.bugs.common.particle.TermostoneDustParticle;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOParticles;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

	public void commonInit() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setupParticles);
	}

	public void clientInit() {

	}

	public void setupParticles(RegisterParticleProvidersEvent registry) {
		registry.registerSpriteSet(BOParticles.TERMITE_MUSHROOM_SPORE.get(), TermiteMushroomSporeParticle.Provider::new);
		registry.registerSpriteSet(BOParticles.MOLD_SPORE.get(), MoldSporeParticle.MoldSporeAirProvider::new);
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
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.SHELF_MUSHROOMS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.LARGE_SHELF_MUSHROOMS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.MOLD_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.MOLD_STALKS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.MOLD_SPORE_SPREADER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.TERMOSTONE_GLASS.get(), translucentRenderType);
	}

	@Override
    public Object getArmorRenderProperties() {
        return new GasMaskRenderProperties();
    }
	
}
