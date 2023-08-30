package superlord.bugs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.bugs.client.ClientProxy;
import superlord.bugs.common.CommonProxy;
import superlord.bugs.common.entity.Glowworm;
import superlord.bugs.common.entity.TermiteKamikaze;
import superlord.bugs.common.entity.TermiteNymph;
import superlord.bugs.common.entity.TermiteSoldier;
import superlord.bugs.common.entity.TermiteWorker;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOConfiguredFeatures;
import superlord.bugs.init.BOConfiguredWorldCarvers;
import superlord.bugs.init.BOEffects;
import superlord.bugs.init.BOEntities;
import superlord.bugs.init.BOFeatures;
import superlord.bugs.init.BOItems;
import superlord.bugs.init.BOPlacedFeatures;
import superlord.bugs.init.BOWorldCarvers;

@Mod(BuggingOut.MOD_ID)
public class BuggingOut {
	
	public static final String MOD_ID = "bugging_out";
	public static final Logger LOGGER = LogManager.getLogger();

	@SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

	public BuggingOut() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BOBlocks.REGISTER.register(bus);
		BOItems.REGISTER.register(bus);
		BOFeatures.REGISTER.register(bus);
		BOConfiguredFeatures.REGISTER.register(bus);
		BOEntities.REGISTER.register(bus);
		BOEffects.REGISTER.register(bus);
		BOPlacedFeatures.REGISTER.register(bus);
		BOWorldCarvers.REGISTER.register(bus);
		BOConfiguredWorldCarvers.REGISTER.register(bus);
		
		bus.addListener(this::registerEntityAttributes);
	}
	
	public final static CreativeModeTab BUGS_BUILDING = new CreativeModeTab("bugs_building_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOBlocks.TERMOSTONE.get());
		}
	};
	
	public final static CreativeModeTab BUGS_DECORATION = new CreativeModeTab("bugs_decoration_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOBlocks.TERMITE_MUSHROOM.get());
		}
	};
	
	public final static CreativeModeTab BUGS_SPAWN_EGGS = new CreativeModeTab("bugs_spawn_eggs_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOItems.TERMITE_WORKER_SPAWN_EGG.get());
		}
	};
	
	public final static CreativeModeTab BUGS_MISC = new CreativeModeTab("bugs_misc_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BOItems.TERMITE_MUSHROOM_SPORES.get());
		}
	};
	
	private void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(BOEntities.TERMITE_WORKER.get(), TermiteWorker.createAttributes().build());
		event.put(BOEntities.TERMITE_SOLDIER.get(), TermiteSoldier.createAttributes().build());
		event.put(BOEntities.TERMITE_NYMPH.get(), TermiteNymph.createAttributes().build());
		event.put(BOEntities.TERMITE_KAMIKAZE.get(), TermiteKamikaze.createAttributes().build());
		event.put(BOEntities.GLOWWORM.get(), Glowworm.createAttributes().build());
	}
	
}
