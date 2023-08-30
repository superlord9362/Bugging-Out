package superlord.bugs.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.item.BOSpawnEggItem;
import superlord.bugs.common.item.TermiteMushroomSporesItem;

public class BOItems {
	
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);

	public static final RegistryObject<BlockItem> TERMOSTONE = REGISTER.register("termostone", () -> new BlockItem(BOBlocks.TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> ROYAL_TERMOSTONE = REGISTER.register("royal_termostone", () -> new BlockItem(BOBlocks.ROYAL_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> POROUS_TERMOSTONE = REGISTER.register("porous_termostone", () -> new BlockItem(BOBlocks.POROUS_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> FERROUS_TERMOSTONE = REGISTER.register("ferrous_termostone", () -> new BlockItem(BOBlocks.FERROUS_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));

	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM = REGISTER.register("termite_mushroom", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.6F).nutrition(3).build()).tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_BLOCK = REGISTER.register("termite_mushroom_block", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_BLOCK.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_STEM = REGISTER.register("termite_mushroom_stem", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_STEM.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("termite_mushroom_mycelium", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> BUG_LAMP = REGISTER.register("bug_lamp", () -> new BlockItem(BOBlocks.BUG_LAMP.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> GLOW_WORM_HOLE = REGISTER.register("glow_worm_hole", () -> new BlockItem(BOBlocks.GLOW_WORM_HOLE.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	
	public static final RegistryObject<Item> TERMITE_NYMPH_SPAWN_EGG = REGISTER.register("termite_nymph_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_NYMPH, 0xCDBBA4, 0xB69E85, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> TERMITE_WORKER_SPAWN_EGG = REGISTER.register("termite_worker_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_WORKER, 0xCAB99D, 0x995D38, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> TERMITE_SOLDIER_SPAWN_EGG = REGISTER.register("termite_soldier_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_SOLDIER, 0xB3895C, 0x673117, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> GLOWWORM_SPAWN_EGG = REGISTER.register("glowworm_spawn_egg", () -> new BOSpawnEggItem(BOEntities.GLOWWORM, 0xD5C488, 0xB4FA7B, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));

	public static final RegistryObject<Item> TERMITE_MUSHROOM_SPORES = REGISTER.register("termite_mushroom_spores", () -> new TermiteMushroomSporesItem(new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	
}
