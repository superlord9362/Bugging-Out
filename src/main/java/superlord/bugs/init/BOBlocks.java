package superlord.bugs.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.block.AcidSplatBlock;
import superlord.bugs.common.block.BOStandingSignBlock;
import superlord.bugs.common.block.BOWallSignBlock;
import superlord.bugs.common.block.BigShelfMushroomBlock;
import superlord.bugs.common.block.CrumblyTermostoneBlock;
import superlord.bugs.common.block.FuzzyMossBlock;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.common.block.MoldBlock;
import superlord.bugs.common.block.MoldSporeSpreaderBlock;
import superlord.bugs.common.block.MulchBlock;
import superlord.bugs.common.block.SplinterBlock;
import superlord.bugs.common.block.TNTreeBlock;
import superlord.bugs.common.block.TermiteInfestedBlock;
import superlord.bugs.common.block.TermiteMushroomBlock;
import superlord.bugs.common.block.TermiteMushroomCapBlock;
import superlord.bugs.common.block.TermiteMushroomMyceliumBlock;
import superlord.bugs.common.block.WallFungusBlock;

@SuppressWarnings("deprecation")
public class BOBlocks {

	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, BuggingOut.MOD_ID);

	public static final RegistryObject<Block> TERMOSTONE = REGISTER.register("termostone", () -> new Block(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TERMOSTONE_SLAB = REGISTER.register("termostone_slab", () -> new SlabBlock(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TERMOSTONE_STAIRS = REGISTER.register("termostone_stairs", () -> new StairBlock(TERMOSTONE.get().defaultBlockState(), Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TERMOSTONE_WALL = REGISTER.register("termostone_wall", () -> new WallBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POLISHED_TERMOSTONE = REGISTER.register("polished_termostone", () -> new Block(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POLISHED_TERMOSTONE_SLAB = REGISTER.register("polished_termostone_slab", () -> new SlabBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POLISHED_TERMOSTONE_STAIRS = REGISTER.register("polished_termostone_stairs", () -> new StairBlock(POLISHED_TERMOSTONE.get().defaultBlockState(), Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICKS = REGISTER.register("termostone_bricks", () -> new Block(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICK_SLAB = REGISTER.register("termostone_brick_slab", () -> new SlabBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICK_STAIRS = REGISTER.register("termostone_brick_stairs", () -> new StairBlock(TERMOSTONE_BRICKS.get().defaultBlockState(), Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICK_WALL = REGISTER.register("termostone_brick_wall", () -> new WallBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POROUS_TERMOSTONE = REGISTER.register("porous_termostone", () -> new Block(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> FERROUS_TERMOSTONE = REGISTER.register("ferrous_termostone", () -> new Block(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROYAL_TERMOSTONE = REGISTER.register("royal_termostone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).noLootTable()));
	public static final RegistryObject<Block> TERMITE_MUSHROOM = REGISTER.register("termite_mushroom", () -> new TermiteMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((p_50892_) -> {
		return 1;
	}), BOConfiguredFeatures.HUGE_TERMITE_MUSHROOM));
	public static final RegistryObject<Block> TERMOSTONE_GLASS = REGISTER.register("termostone_glass", () -> new GlassBlock(BlockBehaviour.Properties.of().strength(1F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(BOBlocks::never).isRedstoneConductor(BOBlocks::never).isSuffocating(BOBlocks::never).isViewBlocking(BOBlocks::never)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_BLOCK = REGISTER.register("termite_mushroom_block", () -> new TermiteMushroomCapBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_STEM = REGISTER.register("termite_mushroom_stem", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BUG_LAMP = REGISTER.register("bug_lamp", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(1F).sound(SoundType.WOOD).lightLevel((p_50872_) -> {
		return 15;
	})));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("termite_mushroom_mycelium", () -> new TermiteMushroomMyceliumBlock(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.5F).randomTicks().sound(SoundType.STONE)));
	public static final RegistryObject<Block> GLOW_WORM_HOLE = REGISTER.register("glow_worm_hole", () -> new GlowWormHoleBlock(Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CRUMBLY_TERMOSTONE = REGISTER.register("crumbly_termostone", () -> new CrumblyTermostoneBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> ACID_SPLAT = REGISTER.register("acid_splat", () -> new AcidSplatBlock(Block.Properties.of().mapColor(MapColor.WOOL).noCollission().noLootTable().strength(0).sound(SoundType.SLIME_BLOCK).randomTicks()));

	public static final RegistryObject<Block> INFESTED_POROUS_TERMOSTONE = REGISTER.register("infested_porous_termostone", () -> new TermiteInfestedBlock(POROUS_TERMOSTONE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

	public static final RegistryObject<Block> TNTREE = REGISTER.register("tntree", () -> new TNTreeBlock(Block.Properties.of().mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS)));
	
	public static final RegistryObject<Block> ROTTEN_LOG = REGISTER.register("rotten_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ROTTEN_LOG = REGISTER.register("stripped_rotten_log", () -> createLog());
	public static final RegistryObject<Block> ROTTEN_WOOD = REGISTER.register("rotten_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ROTTEN_WOOD = REGISTER.register("stripped_rotten_wood", () -> createLog());
	public static final RegistryObject<Block> ROTTEN_PLANKS = REGISTER.register("rotten_planks", () -> new Block(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ROTTEN_DOOR = REGISTER.register("rotten_door", () -> new DoorBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.5F).sound(SoundType.WOOD).noOcclusion(), BOWoodTypes.ROTTEN_TYPE));
	public static final RegistryObject<Block> ROTTEN_PRESSURE_PLATE = REGISTER.register("rotten_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.25F).sound(SoundType.WOOD), BOWoodTypes.ROTTEN_TYPE));
	public static final RegistryObject<Block> ROTTEN_FENCE = REGISTER.register("rotten_fence", () -> new FenceBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ROTTEN_TRAPDOOR = REGISTER.register("rotten_trapdoor", () -> new TrapDoorBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.5F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(BOBlocks::never), BOWoodTypes.ROTTEN_TYPE));
	public static final RegistryObject<Block> ROTTEN_FENCE_GATE = REGISTER.register("rotten_fence_gate", () -> new FenceGateBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.5F).sound(SoundType.WOOD), BOWoodTypes.ROTTEN));
	public static final RegistryObject<Block> ROTTEN_BUTTON = REGISTER.register("rotten_button", () -> new ButtonBlock(Block.Properties.of().noCollission().strength(0.25F).sound(SoundType.WOOD), BOWoodTypes.ROTTEN_TYPE, 30, true));
	public static final RegistryObject<Block> ROTTEN_SLAB = REGISTER.register("rotten_slab", () -> new SlabBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ROTTEN_STAIRS = REGISTER.register("rotten_stairs", () -> new StairBlock(ROTTEN_PLANKS.get().defaultBlockState(), Block.Properties.copy(ROTTEN_PLANKS.get())));
	public static final RegistryObject<Block> ROTTEN_SIGN = REGISTER.register("rotten_sign", () -> new BOStandingSignBlock(Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD), BOWoodTypes.ROTTEN));
	public static final RegistryObject<Block> ROTTEN_WALL_SIGN = REGISTER.register("rotten_wall_sign", () -> new BOWallSignBlock(Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD).dropsLike(ROTTEN_SIGN.get()), BOWoodTypes.ROTTEN));
	public static final RegistryObject<Block> MULCH = REGISTER.register("mulch", () -> new MulchBlock(Block.Properties.of().mapColor(MapColor.DIRT).strength(1.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ROTTEN_CHARCOAL_ORE = REGISTER.register("rotten_charcoal_ore", () -> new Block(Block.Properties.of().mapColor(MapColor.WOOD).strength(1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPLINTERS = REGISTER.register("splinters", () -> new SplinterBlock(Block.Properties.of().mapColor(MapColor.WOOD).strength(0.2F).sound(SoundType.WOOD).noCollission()));
	
	public static final RegistryObject<Block> FUZZY_MOSS = REGISTER.register("fuzzy_moss", () -> new FuzzyMossBlock(Block.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.1F).randomTicks().noOcclusion().sound(SoundType.MOSS)));
	public static final RegistryObject<Block> FUZZY_MOSS_BLOCK = REGISTER.register("fuzzy_moss_block", () -> new Block(Block.Properties.of().mapColor(MapColor.PLANT).strength(0.5F).sound(SoundType.MOSS_CARPET)));
	public static final RegistryObject<Block> SHELF_MUSHROOMS = REGISTER.register("shelf_mushrooms", () -> new WallFungusBlock(Block.Properties.of().noCollission().strength(0.2F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LARGE_SHELF_MUSHROOMS = REGISTER.register("large_shelf_mushrooms", () -> new BigShelfMushroomBlock(Block.Properties.of().strength(0.5F).sound(SoundType.GRASS).noOcclusion()));
	
	public static final RegistryObject<Block> MOLD_CARPET = REGISTER.register("mold_carpet", () -> new MoldBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MOLD_STALKS = REGISTER.register("mold_stalks", () -> new Block(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().noCollission().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MOLD_SPORE_SPREADER = REGISTER.register("mold_spore_spreader", () -> new MoldSporeSpreaderBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.5F).randomTicks().sound(SoundType.GRASS)));
	
	private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
		return (boolean)false;
	}

	private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
		return false;
	}
	
	private static RotatedPillarBlock createLog() {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F).sound(SoundType.WOOD));
	}

}
