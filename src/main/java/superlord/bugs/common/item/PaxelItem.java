package superlord.bugs.common.item;

import java.util.Map;
import java.util.Optional;

import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.init.BOTags;

public class PaxelItem extends AxeItem {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static final Map<Block, BlockState> FLATTENABLES = Maps.newHashMap((new Builder()).putAll(ShovelItem.FLATTENABLES).build());

	public PaxelItem(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
		super(p_40521_, p_40522_, p_40523_, p_40524_);
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return (state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) && net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
	}

	@javax.annotation.Nullable
	public static BlockState getShovelPathingState(BlockState originalState) {
		return FLATTENABLES.get(originalState.getBlock());
	}

	@Override
	public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
		return net.minecraftforge.common.ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || net.minecraftforge.common.ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
	}

	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Level level = context.getLevel();
		Player player = context.getPlayer();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
		Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
		Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(context, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
		ItemStack itemstack = context.getItemInHand();
		Optional<BlockState> optional3 = Optional.empty();
		if (optional.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			optional3 = optional;
		} else if (optional1.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3005, blockpos, 0);
			optional3 = optional1;
		} else if (optional2.isPresent()) {
			level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3004, blockpos, 0);
			optional3 = optional2;
		}

		BlockState blockstate1 = blockstate.getToolModifiedState(context, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
		BlockState blockstate2 = null;
		if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
			level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
			blockstate2 = blockstate1;
		} else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
			if (!level.isClientSide()) {
				level.levelEvent((Player)null, 1009, blockpos, 0);
			}

			CampfireBlock.dowse(context.getPlayer(), level, blockpos, blockstate);
			blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
		}
		if (optional3.isPresent()) {
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
			}

			level.setBlock(blockpos, optional3.get(), 11);
			if (player != null) {
				itemstack.hurtAndBreak(1, player, (p_150686_) -> {
					p_150686_.broadcastBreakEvent(context.getHand());
				});
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		}else if (blockstate2 != null) {
			if (!level.isClientSide) {
				level.setBlock(blockpos, blockstate2, 11);
				if (player != null) {
					context.getItemInHand().hurtAndBreak(1, player, (p_43122_) -> {
						p_43122_.broadcastBreakEvent(context.getHand());
					});
				}
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		if (state.is(BlockTags.MINEABLE_WITH_AXE) || state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
			return this.speed;
		} else if (state.is(BOTags.TERMOSTONE)) {
			return this.speed + 1.5F;
		} else return 1.0F;
	}

}
