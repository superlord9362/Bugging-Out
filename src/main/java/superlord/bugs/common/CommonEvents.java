package superlord.bugs.common;

import com.google.common.collect.ImmutableMap;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import superlord.bugs.BuggingOut;
import superlord.bugs.init.BOBlocks;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
	
	@SubscribeEvent
	public static void init(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			compostibleBlocks();
			AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
					.put(BOBlocks.ROTTEN_LOG.get(), BOBlocks.STRIPPED_ROTTEN_LOG.get())
					.put(BOBlocks.ROTTEN_WOOD.get(), BOBlocks.STRIPPED_ROTTEN_WOOD.get()).build();
			registerFlammables();
		});
	}
	
	public static void registerFlammables() {
		registerFlammable(BOBlocks.ROTTEN_PLANKS.get(), 10, 40);
		registerFlammable(BOBlocks.ROTTEN_SLAB.get(), 10, 40);
		registerFlammable(BOBlocks.ROTTEN_FENCE.get(), 10, 40);
		registerFlammable(BOBlocks.ROTTEN_FENCE_GATE.get(), 10, 40);
		registerFlammable(BOBlocks.ROTTEN_STAIRS.get(), 10, 40);
		registerFlammable(BOBlocks.ROTTEN_LOG.get(), 10, 10);
		registerFlammable(BOBlocks.ROTTEN_WOOD.get(), 10, 10);
		registerFlammable(BOBlocks.STRIPPED_ROTTEN_LOG.get(), 10, 10);
		registerFlammable(BOBlocks.STRIPPED_ROTTEN_WOOD.get(), 10, 10);
		registerFlammable(BOBlocks.MULCH.get(), 40, 40);
	}
	
	private static void compostibleBlocks() {
		
	}
	
	@SuppressWarnings("unused")
	private static void compostibleBlock(float chance, ItemLike item) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
	
	public static void registerFlammable(Block block, int flameOdds, int burnOdds) { 
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFlammable(block, flameOdds, burnOdds);
	}
	
	

}
