package superlord.bugs.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.block.AcidSplatBlock;
import superlord.bugs.common.block.CrumblyTermostoneBlock;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.common.block.TNTreeBlock;
import superlord.bugs.common.block.TermiteInfestedBlock;
import superlord.bugs.common.block.TermiteMushroomBlock;
import superlord.bugs.common.block.TermiteMushroomCapBlock;
import superlord.bugs.common.block.TermiteMushroomMyceliumBlock;

public class BOBlocks {

	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, BuggingOut.MOD_ID);

	public static final RegistryObject<Block> TERMOSTONE = REGISTER.register("termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TERMOSTONE_SLAB = REGISTER.register("termostone_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> TERMOSTONE_STAIRS = REGISTER.register("termostone_stairs", () -> new StairBlock(TERMOSTONE.get().defaultBlockState(), Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TERMOSTONE_WALL = REGISTER.register("termostone_wall", () -> new WallBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POLISHED_TERMOSTONE = REGISTER.register("polished_termostone", () -> new Block(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POLISHED_TERMOSTONE_SLAB = REGISTER.register("polished_termostone_slab", () -> new SlabBlock(Block.Properties.copy(TERMOSTONE.get())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POLISHED_TERMOSTONE_STAIRS = REGISTER.register("polished_termostone_stairs", () -> new StairBlock(POLISHED_TERMOSTONE.get().defaultBlockState(), Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICKS = REGISTER.register("termostone_bricks", () -> new Block(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICK_SLAB = REGISTER.register("termostone_brick_slab", () -> new SlabBlock(Block.Properties.copy(TERMOSTONE.get())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> TERMOSTONE_BRICK_STAIRS = REGISTER.register("termostone_brick_stairs", () -> new StairBlock(TERMOSTONE_BRICKS.get().defaultBlockState(), Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> TERMOSTONE_BRICK_WALL = REGISTER.register("termostone_brick_wall", () -> new WallBlock(Block.Properties.copy(TERMOSTONE.get())));
	public static final RegistryObject<Block> POROUS_TERMOSTONE = REGISTER.register("porous_termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> FERROUS_TERMOSTONE = REGISTER.register("ferrous_termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROYAL_TERMOSTONE = REGISTER.register("royal_termostone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).noDrops()));
	public static final RegistryObject<Block> TERMITE_MUSHROOM = REGISTER.register("termite_mushroom", () -> new TermiteMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((p_50892_) -> {
		return 1;
	}), () -> {
		return BOConfiguredFeatures.HUGE_TERMITE_MUSHROOM.getHolder().orElseThrow();
	}));
	public static final RegistryObject<Block> TERMOSTONE_GLASS = REGISTER.register("termostone_glass", () -> new GlassBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(1F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(BOBlocks::never).isRedstoneConductor(BOBlocks::never).isSuffocating(BOBlocks::never).isViewBlocking(BOBlocks::never)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_BLOCK = REGISTER.register("termite_mushroom_block", () -> new TermiteMushroomCapBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_STEM = REGISTER.register("termite_mushroom_stem", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOL).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BUG_LAMP = REGISTER.register("bug_lamp", () -> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1F).sound(SoundType.WOOD).lightLevel((p_50872_) -> {
		return 15;
	})));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("termite_mushroom_mycelium", () -> new TermiteMushroomMyceliumBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).randomTicks().sound(SoundType.STONE)));
	public static final RegistryObject<Block> GLOW_WORM_HOLE = REGISTER.register("glow_worm_hole", () -> new GlowWormHoleBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CRUMBLY_TERMOSTONE = REGISTER.register("crumbly_termostone", () -> new CrumblyTermostoneBlock(Block.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(0.5F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> ACID_SPLAT = REGISTER.register("acid_splat", () -> new AcidSplatBlock(Block.Properties.of(Material.WEB).noCollission().noDrops().strength(0).sound(SoundType.SLIME_BLOCK).randomTicks()));

	public static final RegistryObject<Block> INFESTED_POROUS_TERMOSTONE = REGISTER.register("infested_porous_termostone", () -> new TermiteInfestedBlock(POROUS_TERMOSTONE.get(), BlockBehaviour.Properties.of(Material.STONE)));

	public static final RegistryObject<Block> TNTREE = REGISTER.register("tntree", () -> new TNTreeBlock(Block.Properties.of(Material.EXPLOSIVE).instabreak().sound(SoundType.GRASS)));
	
	private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
		return (boolean)false;
	}

	private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
		return false;
	}

}
