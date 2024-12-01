package superlord.bugs.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.BOBoat;
import superlord.bugs.common.item.BOArmorMaterials;
import superlord.bugs.common.item.BOBoatItem;
import superlord.bugs.common.item.BOItemTiers;
import superlord.bugs.common.item.GasMaskItem;
import superlord.bugs.common.item.PaxelItem;
import superlord.bugs.common.item.ShrinkingSoupItem;
import superlord.bugs.common.item.SplinterBowItem;
import superlord.bugs.common.item.SplinterItem;
import superlord.bugs.common.item.SpringtailItem;
import superlord.bugs.common.item.TermiteAcidItem;
import superlord.bugs.common.item.TermiteMushroomSporesItem;

public class BOItems {
	
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);
	public static final DeferredRegister<Item> BUILDING = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);
	public static final DeferredRegister<Item> DECORATIONS = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);
	public static final DeferredRegister<Item> MISC = DeferredRegister.create(ForgeRegistries.ITEMS, BuggingOut.MOD_ID);

	public static final RegistryObject<BlockItem> TERMOSTONE = BUILDING.register("termostone", () -> new BlockItem(BOBlocks.TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE = BUILDING.register("polished_termostone", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICKS = BUILDING.register("termostone_bricks", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICKS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_SLAB = BUILDING.register("termostone_slab", () -> new BlockItem(BOBlocks.TERMOSTONE_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE_SLAB = BUILDING.register("polished_termostone_slab", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_SLAB = BUILDING.register("termostone_brick_slab", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_STAIRS = BUILDING.register("termostone_stairs", () -> new BlockItem(BOBlocks.TERMOSTONE_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> POLISHED_TERMOSTONE_STAIRS = BUILDING.register("polished_termostone_stairs", () -> new BlockItem(BOBlocks.POLISHED_TERMOSTONE_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_STAIRS = BUILDING.register("termostone_brick_stairs", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_GLASS = BUILDING.register("termostone_glass", () -> new BlockItem(BOBlocks.TERMOSTONE_GLASS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROYAL_TERMOSTONE = BUILDING.register("royal_termostone", () -> new BlockItem(BOBlocks.ROYAL_TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> POROUS_TERMOSTONE = BUILDING.register("porous_termostone", () -> new BlockItem(BOBlocks.POROUS_TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> FERROUS_TERMOSTONE = BUILDING.register("ferrous_termostone", () -> new BlockItem(BOBlocks.FERROUS_TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> CRUMBLY_TERMOSTONE = BUILDING.register("crumbly_termostone", () -> new BlockItem(BOBlocks.CRUMBLY_TERMOSTONE.get(), new Item.Properties()));
	
	public static final RegistryObject<BlockItem> ROTTEN_LOG = BUILDING.register("rotten_log", () -> new BlockItem(BOBlocks.ROTTEN_LOG.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> STRIPPED_ROTTEN_LOG = BUILDING.register("stripped_rotten_log", () -> new BlockItem(BOBlocks.STRIPPED_ROTTEN_LOG.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_WOOD = BUILDING.register("rotten_wood", () -> new BlockItem(BOBlocks.ROTTEN_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> STRIPPED_ROTTEN_WOOD = BUILDING.register("stripped_rotten_wood", () -> new BlockItem(BOBlocks.STRIPPED_ROTTEN_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_PLANKS = BUILDING.register("rotten_planks", () -> new BlockItem(BOBlocks.ROTTEN_PLANKS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_STAIRS = BUILDING.register("rotten_stairs", () -> new BlockItem(BOBlocks.ROTTEN_STAIRS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_SLAB = BUILDING.register("rotten_slab", () -> new BlockItem(BOBlocks.ROTTEN_SLAB.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> MULCH = BUILDING.register("mulch", () -> new BlockItem(BOBlocks.MULCH.get(), new Item.Properties()));
	
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM = DECORATIONS.register("termite_mushroom", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM.get(), new Item.Properties().food(new FoodProperties.Builder().saturationMod(0.6F).nutrition(3).build())));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_BLOCK = DECORATIONS.register("termite_mushroom_block", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_STEM = DECORATIONS.register("termite_mushroom_stem", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_STEM.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMITE_MUSHROOM_MYCELIUM = DECORATIONS.register("termite_mushroom_mycelium", () -> new BlockItem(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> INFESTED_POROUS_TERMOSTONE = DECORATIONS.register("infested_porous_termostone", () -> new BlockItem(BOBlocks.INFESTED_POROUS_TERMOSTONE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_WALL = DECORATIONS.register("termostone_wall", () -> new BlockItem(BOBlocks.TERMOSTONE_WALL.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> TERMOSTONE_BRICK_WALL = DECORATIONS.register("termostone_brick_wall", () -> new BlockItem(BOBlocks.TERMOSTONE_BRICK_WALL.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> BUG_LAMP = DECORATIONS.register("bug_lamp", () -> new BlockItem(BOBlocks.BUG_LAMP.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> GLOW_WORM_HOLE = DECORATIONS.register("glow_worm_hole", () -> new BlockItem(BOBlocks.GLOW_WORM_HOLE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> INFESTED_ROTTEN_WOOD = DECORATIONS.register("infested_rotten_wood", () -> new BlockItem(BOBlocks.INFESTED_ROTTEN_WOOD.get(), new Item.Properties()));
	public static final RegistryObject<Item> ROTTEN_SIGN = DECORATIONS.register("rotten_sign", () -> new SignItem(new Item.Properties().stacksTo(16), BOBlocks.ROTTEN_SIGN.get(), BOBlocks.ROTTEN_WALL_SIGN.get()));
	public static final RegistryObject<BlockItem> ROTTEN_DOOR = DECORATIONS.register("rotten_door", () -> new BlockItem(BOBlocks.ROTTEN_DOOR.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_TRAPDOOR = DECORATIONS.register("rotten_trapdoor", () -> new BlockItem(BOBlocks.ROTTEN_TRAPDOOR.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_FENCE = DECORATIONS.register("rotten_fence", () -> new BlockItem(BOBlocks.ROTTEN_FENCE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_FENCE_GATE = DECORATIONS.register("rotten_fence_gate", () -> new BlockItem(BOBlocks.ROTTEN_FENCE_GATE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_BUTTON = DECORATIONS.register("rotten_button", () -> new BlockItem(BOBlocks.ROTTEN_BUTTON.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_PRESSURE_PLATE = DECORATIONS.register("rotten_pressure_plate", () -> new BlockItem(BOBlocks.ROTTEN_PRESSURE_PLATE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> SPLINTERS = DECORATIONS.register("splinters", () -> new BlockItem(BOBlocks.SPLINTERS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> ROTTEN_CHARCOAL_ORE = DECORATIONS.register("rotten_charcoal_ore", () -> new BlockItem(BOBlocks.ROTTEN_CHARCOAL_ORE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> SAP_RESIN_ORE = DECORATIONS.register("sap_resin_ore", () -> new BlockItem(BOBlocks.SAP_RESIN_ORE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> FUZZY_MOSS_BLOCk = DECORATIONS.register("fuzzy_moss_block", () -> new BlockItem(BOBlocks.FUZZY_MOSS_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> FUZZY_MOSS = DECORATIONS.register("fuzzy_moss", () -> new BlockItem(BOBlocks.FUZZY_MOSS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> SHELF_MUSHROOMS = DECORATIONS.register("shelf_mushrooms", () -> new BlockItem(BOBlocks.SHELF_MUSHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> LARGE_SHELF_MUSHROOMS = DECORATIONS.register("large_shelf_mushrooms", () -> new BlockItem(BOBlocks.LARGE_SHELF_MUSHROOMS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> MOLD_CARPET = DECORATIONS.register("mold_carpet", () -> new BlockItem(BOBlocks.MOLD_CARPET.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> MOLD_STALKS = DECORATIONS.register("mold_stalks", () -> new BlockItem(BOBlocks.MOLD_STALKS.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> MOLD_SPORE_SPREADER = DECORATIONS.register("mold_spore_spreader", () -> new BlockItem(BOBlocks.MOLD_SPORE_SPREADER.get(), new Item.Properties()));
	
	public static final RegistryObject<Item> TERMITE_NYMPH_SPAWN_EGG = SPAWN_EGGS.register("termite_nymph_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.TERMITE_NYMPH, 0xCDBBA4, 0xB69E85, new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_WORKER_SPAWN_EGG = SPAWN_EGGS.register("termite_worker_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.TERMITE_WORKER, 0xCAB99D, 0x995D38, new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_KAMIKAZE_SPAWN_EGG = SPAWN_EGGS.register("termite_kamikaze_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.TERMITE_KAMIKAZE, 0xA9896B, 0x73806B, new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_SOLDIER_SPAWN_EGG = SPAWN_EGGS.register("termite_soldier_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.TERMITE_SOLDIER, 0xB3895C, 0x673117, new Item.Properties()));
	public static final RegistryObject<Item> GLOWWORM_SPAWN_EGG = SPAWN_EGGS.register("glowworm_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.GLOWWORM, 0xD5C488, 0xB4FA7B, new Item.Properties()));
	public static final RegistryObject<Item> BARK_BEETLE_SPAWN_EGG = SPAWN_EGGS.register("bark_beetle_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.BARK_BEETLE, 0x893A24, 0x442015, new Item.Properties()));
	public static final RegistryObject<Item> SPRINGTAIL_SPAWN_EGG = SPAWN_EGGS.register("springtail_spawn_egg", () -> new ForgeSpawnEggItem(BOEntities.SPRINGTAIL, 0xD7C336, 0xA46D9B, new Item.Properties()));
	
	public static final RegistryObject<Item> TNTEE = MISC.register("tntree", () -> new BlockItem(BOBlocks.TNTREE.get(), new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_MUSHROOM_SPORES = MISC.register("termite_mushroom_spores", () -> new TermiteMushroomSporesItem(new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_ACID = MISC.register("termite_acid", () -> new TermiteAcidItem(new Item.Properties()));
	public static final RegistryObject<Item> CHITIN = MISC.register("chitin", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> MANDIBLE = MISC.register("mandible", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> MANDIBLE_HOE = MISC.register("mandible_hoe", () -> new HoeItem(BOItemTiers.MANDIBLE, -1, -1.5F, new Item.Properties()));
	public static final RegistryObject<Item> MANDIBLE_SHOVEL = MISC.register("mandible_shovel", () -> new ShovelItem(BOItemTiers.MANDIBLE, 1.5F, -3, new Item.Properties()));
	public static final RegistryObject<Item> MANDIBLE_PICKAXE = MISC.register("mandible_pickaxe", () -> new PickaxeItem(BOItemTiers.MANDIBLE, 1, -2.8F, new Item.Properties()));
	public static final RegistryObject<Item> MANDBILE_AXE = MISC.register("mandible_axe", () -> new AxeItem(BOItemTiers.MANDIBLE, 6.5F, -3.2F, new Item.Properties()));
	public static final RegistryObject<Item> MANDIBLE_SWORD = MISC.register("mandible_sword", () -> new SwordItem(BOItemTiers.MANDIBLE, 3, -2.4F, new Item.Properties()));
	public static final RegistryObject<Item> TERMITE_PAXEL = MISC.register("termite_paxel", () -> new PaxelItem(BOItemTiers.TERMITE, 4, -2.5F, new Item.Properties()));
	public static final RegistryObject<Item> SPLINTER_BOW = MISC.register("splinter_bow", () -> new SplinterBowItem(new Item.Properties().stacksTo(1).durability(384)));
	public static final RegistryObject<Item> SPLINTER = MISC.register("splinter", () -> new SplinterItem(new Item.Properties()));
	public static final RegistryObject<Item> SAP_RESIN = MISC.register("sap_resin", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GAS_MASK = MISC.register("gas_mask", () -> new GasMaskItem(BOArmorMaterials.GAS_MASK, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(384)));
	public static final RegistryObject<Item> PURPLE_SPRINGTAIL = MISC.register("purple_springtail", () -> new SpringtailItem(new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_SPRINGTAIL = MISC.register("yellow_springtail", () -> new SpringtailItem(new Item.Properties()));
	
	public static final RegistryObject<Item> MANDIBLE_SHEARS = MISC.register("mandible_shears", () -> new ShearsItem(new Item.Properties().durability(238)));
	
	public static final RegistryObject<Item> SHRINKING_SOUP = MISC.register("shrinking_soup", () -> new ShrinkingSoupItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.8F).alwaysEat().build())));
	
	public static final RegistryObject<BOBoatItem> ROTTEN_BOAT = MISC.register("rotten_boat", () -> new BOBoatItem(BOBoat.BOBoatTypes.ROTTEN, new Item.Properties().stacksTo(1)));
	
}
