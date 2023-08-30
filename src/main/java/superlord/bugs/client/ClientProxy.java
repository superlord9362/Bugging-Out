package superlord.bugs.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.CommonProxy;
import superlord.bugs.init.BOBlocks;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public void init() {
	}
	
	public static void setUpBlockRenders() {
		RenderType cutoutRenderType = RenderType.cutout();
		RenderType translucentRenderType = RenderType.translucent();
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.TERMITE_MUSHROOM.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.ACID_SPLAT.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BOBlocks.TERMOSTONE_GLASS.get(), translucentRenderType);
	}

}
