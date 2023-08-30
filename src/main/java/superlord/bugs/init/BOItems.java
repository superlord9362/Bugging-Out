package superlord.bugs.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.item.BOItemTiers;
import superlord.bugs.common.item.BOSpawnEggItem;
import superlord.bugs.common.item.TermiteAcidItem;
import superlord.bugs.common.item.TermiteMushroomSporesItem;

public class BOItems {
	
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);

	public static final RegistryObject<BlockItem> TERMOSTONE = REGISTER.register("termostone", () -> new BlockItem(BOBlocks.TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE = REGISTER.register("polished_termostone", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICKS = REGISTER.register("termostone_bricks", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICKS.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_SLAB = REGISTER.register("termostone_slab", () -> new BlockItem(BOBlocks.TERMOSTONE_SLAB.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE_SLAB = REGISTER.register("polished_termostone_slab", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE_SLAB.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_SLAB = REGISTER.register("termostone_brick_slab", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_SLAB.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_STAIRS = REGISTER.register("termostone_stairs", () -> new BlockItem(BOBlocks.TERMOSTONE_STAIRS.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE_STAIRS = REGISTER.register("polished_termostone_stairs", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE_STAIRS.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_STAIRS = REGISTER.register("termostone_brick_stairs", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_STAIRS.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> TERMOSTONE_GLASS = REGISTER.register("termostone_glass", () -> new BlockItem(BOBlocks.TERMOSTONE_GLASS.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> ROYAL_TERMOSTONE = REGISTER.register("royal_termostone", () -> new BlockItem(BOBlocks.ROYAL_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> POROUS_TERMOSTONE = REGISTER.register("porous_termostone", () -> new BlockItem(BOBlocks.POROUS_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> FERROUS_TERMOSTONE = REGISTER.register("ferrous_termostone", () -> new BlockItem(BOBlocks.FERROUS_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> CRUMBLY_TERMOSTONE = REGISTER.register("crumbly_termostone", () -> new BlockItem(BOBlocks.CRUMBLY_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM = REGISTER.register("termite_mushroom", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.6F).nutrition(3).build()).tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_BLOCK = REGISTER.register("termite_mushroom_block", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_BLOCK.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_STEM = REGISTER.register("termite_mushroom_stem", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_STEM.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("termite_mushroom_mycelium", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get(), new Item.Properties().tab(BuggingOut.BUGS_BUILDING)));
	public static final RegistryObject<BlockItem> INFESTED_POROUS_TERMOSTONE = REGISTER.register("infested_porous_termostone", () -> new BlockItem(BOBlocks.INFESTED_POROUS_TERMOSTONE.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMOSTONE_WALL = REGISTER.register("termostone_wall", () -> new BlockItem(BOBlocks.TERMOSTONE_WALL.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_WALL = REGISTER.register("termostone_brick_wall", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_WALL.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> BUG_LAMP = REGISTER.register("bug_lamp", () -> new BlockItem(BOBlocks.BUG_LAMP.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	public static final RegistryObject<BlockItem> GLOW_WORM_HOLE = REGISTER.register("glow_worm_hole", () -> new BlockItem(BOBlocks.GLOW_WORM_HOLE.get(), new Item.Properties().tab(BuggingOut.BUGS_DECORATION)));
	
	public static final RegistryObject<Item> TERMITE_NYMPH_SPAWN_EGG = REGISTER.register("termite_nymph_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_NYMPH, 0xCDBBA4, 0xB69E85, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> TERMITE_WORKER_SPAWN_EGG = REGISTER.register("termite_worker_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_WORKER, 0xCAB99D, 0x995D38, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> TERMITE_KAMIKAZE_SPAWN_EGG = REGISTER.register("termite_kamikaze_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_KAMIKAZE, 0xA9896B, 0x73806B, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> TERMITE_SOLDIER_SPAWN_EGG = REGISTER.register("termite_soldier_spawn_egg", () -> new BOSpawnEggItem(BOEntities.TERMITE_SOLDIER, 0xB3895C, 0x673117, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));
	public static final RegistryObject<Item> GLOWWORM_SPAWN_EGG = REGISTER.register("glowworm_spawn_egg", () -> new BOSpawnEggItem(BOEntities.GLOWWORM, 0xD5C488, 0xB4FA7B, new Item.Properties().tab(BuggingOut.BUGS_SPAWN_EGGS)));

	public static final RegistryObject<Item> TNTEE = REGISTER.register("tntree", () -> new BlockItem(BOBlocks.TNTREE.get(), new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> TERMITE_MUSHROOM_SPORES = REGISTER.register("termite_mushroom_spores", () -> new TermiteMushroomSporesItem(new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> TERMITE_ACID = REGISTER.register("termite_acid", () -> new TermiteAcidItem(new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> CHITIN = REGISTER.register("chitin", () -> new Item(new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> MANDIBLE = REGISTER.register("mandible", () -> new Item(new Item.Properties().tab(BuggingOut.BUGS_MISC)));

	public static final RegistryObject<Item> MANDIBLE_HOE = REGISTER.register("mandible_hoe", () -> new HoeItem(BOItemTiers.MANDIBLE, -1, -1.5F, new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> MANDIBLE_SHOVEL = REGISTER.register("mandible_shovel", () -> new ShovelItem(BOItemTiers.MANDIBLE, 1.5F, -3, new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> MANDIBLE_PICKAXE = REGISTER.register("mandible_pickaxe", () -> new PickaxeItem(BOItemTiers.MANDIBLE, 1, -2.8F, new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> MANDBILE_AXE = REGISTER.register("mandible_axe", () -> new AxeItem(BOItemTiers.MANDIBLE, 6.5F, -3.2F, new Item.Properties().tab(BuggingOut.BUGS_MISC)));
	public static final RegistryObject<Item> MANDIBLE_SWORD = REGISTER.register("mandible_sword", () -> new SwordItem(BOItemTiers.MANDIBLE, 3, -2.4F, new Item.Properties().tab(BuggingOut.BUGS_MISC)));

}
