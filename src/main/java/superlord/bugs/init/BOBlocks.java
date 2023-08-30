package superlord.bugs.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.block.GlowWormHoleBlock;
import superlord.bugs.common.block.TermiteMushroomBlock;
import superlord.bugs.common.block.TermiteMushroomCapBlock;
import superlord.bugs.common.block.TermiteMushroomMyceliumBlock;

public class BOBlocks {

	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, BuggingOut.MOD_ID);

	public static final RegistryObject<Block> TERMOSTONE = REGISTER.register("termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POROUS_TERMOSTONE = REGISTER.register("porous_termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> FERROUS_TERMOSTONE = REGISTER.register("ferrous_termostone", () -> new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.5F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ROYAL_TERMOSTONE = REGISTER.register("royal_termostone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM = REGISTER.register("termite_mushroom", () -> new TermiteMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((p_50892_) -> {
		return 1;
	}), () -> {
		return BOConfiguredFeatures.HUGE_TERMITE_MUSHROOM.getHolder().orElseThrow();
	}));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_BLOCK = REGISTER.register("termite_mushroom_block", () -> new TermiteMushroomCapBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_STEM = REGISTER.register("termite_mushroom_stem", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOL).strength(0.2F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BUG_LAMP = REGISTER.register("bug_lamp", () -> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1F).sound(SoundType.WOOD).lightLevel((p_50872_) -> {
		return 15;
	})));
	public static final RegistryObject<Block> TERMITE_MUSHROOM_MYCELIUM = REGISTER.register("termite_mushroom_mycelium", () -> new TermiteMushroomMyceliumBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).randomTicks().sound(SoundType.STONE)));
	public static final RegistryObject<Block> GLOW_WORM_HOLE = REGISTER.register("glow_worm_hole", () -> new GlowWormHoleBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE)));
	
}
