package superlord.bugs.client;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.bugs.BuggingOut;
import superlord.bugs.client.entity.model.GlowwormModel;
import superlord.bugs.client.entity.model.TermiteNymphModel;
import superlord.bugs.client.entity.model.TermiteSoldierModel;
import superlord.bugs.client.entity.model.TermiteWorkerModel;
import superlord.bugs.client.entity.render.GlowwormRenderer;
import superlord.bugs.client.entity.render.TermiteNymphRenderer;
import superlord.bugs.client.entity.render.TermiteSoldierRenderer;
import superlord.bugs.client.entity.render.TermiteWorkerRenderer;
import superlord.bugs.common.item.BOSpawnEggItem;
import superlord.bugs.init.BOEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		ClientProxy.setUpBlockRenders();
	}
	
	public static ModelLayerLocation TERMITE_WORKER = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_worker"), "termite_worker");
	public static ModelLayerLocation TERMITE_SOLDIER = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_soldier"), "termite_soldier");
	public static ModelLayerLocation TERMITE_NYMPH = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "termite_nymph"), "termite_nymph");
	public static ModelLayerLocation GLOWWORM = new ModelLayerLocation(new ResourceLocation(BuggingOut.MOD_ID, "glowworm"), "glowworm");

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemColors(RegisterColorHandlersEvent.Item event) {
		ItemColors handler = event.getItemColors();
		ItemColor eggColor = (stack, tintIndex) -> ((BOSpawnEggItem) stack.getItem()).getColor(tintIndex);
		for (BOSpawnEggItem e : BOSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
	}
	
	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BOEntities.TERMITE_WORKER.get(), TermiteWorkerRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_SOLDIER.get(), TermiteSoldierRenderer::new);
		event.registerEntityRenderer(BOEntities.TERMITE_NYMPH.get(), TermiteNymphRenderer::new);
		event.registerEntityRenderer(BOEntities.GLOWWORM.get(), GlowwormRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(TERMITE_WORKER, TermiteWorkerModel::createBodyLayer);
		event.registerLayerDefinition(TERMITE_SOLDIER, TermiteSoldierModel::createBodyLayer);
		event.registerLayerDefinition(TERMITE_NYMPH, TermiteNymphModel::createBodyLayer);
		event.registerLayerDefinition(GLOWWORM, GlowwormModel::createBodyLayer);
	}

}
