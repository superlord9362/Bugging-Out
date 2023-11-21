package superlord.bugs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

public class BOTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuggingOut.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BUILDING_TAB = REGISTER.register("bugging_out_building_item_group", () -> CreativeModeTab.builder().icon(() -> new ItemStack(BOBlocks.TERMOSTONE.get()))
			.title(Component.translatable("itemGroup.bugging_out_building_item_group"))
			.displayItems((pParameters, pOutput) -> {
				for (var block : BOItems.BUILDING.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> DECORATION_TAB = REGISTER.register("bugging_out_decorations_item_group", () -> CreativeModeTab.builder().icon(() -> new ItemStack(BOBlocks.TERMITE_MUSHROOM.get()))
			.title(Component.translatable("itemGroup.bugging_out_decorations_item_group"))
			.displayItems((pParameters, pOutput) -> {
				for (var block : BOItems.DECORATIONS.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> SPAWN_EGGS_TAB = REGISTER.register("bugging_out_spawn_eggs_item_group", () -> CreativeModeTab.builder().icon(() -> new ItemStack(BOItems.TERMITE_WORKER_SPAWN_EGG.get()))
			.title(Component.translatable("itemGroup.bugging_out_spawn_eggs_item_group"))
			.displayItems((pParameters, pOutput) -> {
				for (var block : BOItems.SPAWN_EGGS.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> MISC_TAB = REGISTER.register("bugging_out_misc_item_group", () -> CreativeModeTab.builder().icon(() -> new ItemStack(BOItems.TERMITE_MUSHROOM_SPORES.get()))
			.title(Component.translatable("itemGroup.bugging_out_misc_item_group"))
			.displayItems((pParameters, pOutput) -> {
				for (var block : BOItems.MISC.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
}
