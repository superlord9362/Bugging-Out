package superlord.bugs.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.entity.model.GlowwormModel;
import superlord.bugs.client.entity.model.TermiteKamikazeModel;
import superlord.bugs.client.entity.model.TermiteNymphModel;
import superlord.bugs.client.entity.model.TermiteSoldierModel;
import superlord.bugs.client.entity.model.TermiteWorkerModel;
import superlord.bugs.client.entity.render.BOBoatRenderer;
import superlord.bugs.client.entity.render.GlowwormRenderer;
import superlord.bugs.client.entity.render.TermiteKamikazeRenderer;
import superlord.bugs.client.entity.render.TermiteNymphRenderer;
import superlord.bugs.client.entity.render.TermiteSoldierRenderer;
import superlord.bugs.client.entity.render.TermiteWorkerRenderer;
import superlord.bugs.client.entity.render.item.SplinterRenderer;
import superlord.bugs.client.entity.render.item.TNTreeRenderer;
import superlord.bugs.client.entity.render.item.TermiteAcidRenderer;
import superlord.bugs.init.BOBlockEntities;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOItems;
import superlord.bugs.init.BOWoodTypes;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		BlockEntityRenderers.register(BOBlockEntities.SIGN.get(), SignRenderer::new);
		event.enqueueWork(() -> {
			Sheets.addWoodType(BOWoodTypes.ROTTEN);
		});
		ClientProxy.setUpBlockRenders();
		ItemProperties.register(BOItems.SPLINTER_BOW.get(), new ResourceLocation(BuggingOut.MOD_ID, "pulling"), (stack, world, player, i) -> {
			return player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F;
		});
		ItemProperties.register(BOItems.SPLINTER_BOW.get(), new ResourceLocation(BuggingOut.MOD_ID, "pull"), (stack, world, player, i) -> {
			if (player == null) {
				return 0.0F;
			} else {
				return player.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - player.getUseItemRemainingTicks()) / 20.0F;
			}
		});
	}
	
	public static ModelLayerLocation TERMITE_WORKER = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_worker"), "termite_worker");
	public static ModelLayerLocation TERMITE_SOLDIER = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_soldier"), "termite_soldier");
	public static ModelLayerLocation TERMITE_KAMIKAZE = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_kamikaze"), "termite_kamikaze");
	public static ModelLayerLocation TERMITE_NYMPH = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_nymph"), "termite_nymph");
	public static ModelLayerLocation GLOWWORM = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "glowworm"), "glowworm");
	
	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BOEntities.TERMITE_WORKER.get(), TermiteWorkerRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_SOLDIER.get(), TermiteSoldierRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_KAMIKAZE.get(), TermiteKamikazeRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_NYMPH.get(), TermiteNymphRenderer::new);
		event.registerEntityRenderer(BOEntities.GLOWWORM.get(), GlowwormRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_ACID.get(), TermiteAcidRenderer::new);
		event.registerEntityRenderer(BOEntities.TNTREE.get(), TNTreeRenderer::new);
		event.registerEntityRenderer(BOEntities.BOAT.get(), BOBoatRenderer::new);
		event.registerEntityRenderer(BOEntities.SPLINTER.get(), SplinterRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(TERMITE_WORKER, TermiteWorkerModel::createBodyLayer);
		event.registerLayerDefinition(TERMITE_SOLDIER, TermiteSoldierModel::createBodyLayer);
		event.registerLayerDefinition(TERMITE_KAMIKAZE, TermiteKamikazeModel::createBodyLayer);
		event.registerLayerDefinition(TERMITE_NYMPH, TermiteNymphModel::createBodyLayer);
		event.registerLayerDefinition(GLOWWORM, GlowwormModel::createBodyLayer);
	}

}
