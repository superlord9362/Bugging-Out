package superlord.bugs.common.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.init.BOBlocks;
import superlord.bugs.init.BOEffects;

public class TermiteMushroomMyceliumBlock extends Block {

	public TermiteMushroomMyceliumBlock(Properties p_49795_) {
		super(p_49795_);
	}

	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(world, player, pos, state, blockEntity, stack);
		player.addEffect(new MobEffectInstance(BOEffects.TERMITES_VENGEANCE.get(), 600, 0, false, false, true));
	}
	
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (!world.isAreaLoaded(pos, 1)) return;
		int growChance = random.nextInt(12);
		if (world.getBlockState(pos.above()).is(Blocks.AIR)) {
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.above()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 0) {
			world.setBlock(pos.above(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.below()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 1) {
			world.setBlock(pos.below(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.north()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 2) {
			world.setBlock(pos.north(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.south()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 3) {
			world.setBlock(pos.south(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.east()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 4) {
			world.setBlock(pos.east(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		if (world.getBlockState(pos.west()).is(BOBlocks.POROUS_TERMOSTONE.get()) && growChance == 5) {
			world.setBlock(pos.west(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get().defaultBlockState(), 2);
		}
		else return;	
	}

}
