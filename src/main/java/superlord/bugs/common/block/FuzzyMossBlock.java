package superlord.bugs.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import superlord.bugs.init.BOItems;

public class FuzzyMossBlock extends MultifaceBlock {
	public static final BooleanProperty TRIMMED = BooleanProperty.create("trimmed");

	public FuzzyMossBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(TRIMMED, true));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52719_) {
	      super.createBlockStateDefinition(p_52719_);
	      p_52719_.add(TRIMMED);
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		boolean trimmed = state.getValue(TRIMMED);
		if (trimmed) {
			level.setBlockAndUpdate(pos, state.setValue(TRIMMED, false));
		}
	}


	@SuppressWarnings("deprecation")
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		if ((stack.is(Items.SHEARS) || stack.is(BOItems.MANDIBLE_SHEARS.get())) && state.getValue(TRIMMED) == false) {
			if (!player.getAbilities().instabuild) {
				stack.hurtAndBreak(1, player, (shears) -> {
					shears.broadcastBreakEvent(hand);
				});
			}
			popResource(world, pos, new ItemStack(BOItems.FUZZY_MOSS.get(), 1));
			world.setBlockAndUpdate(pos, state.setValue(TRIMMED, true));
			return InteractionResult.SUCCESS;
		} else {
			return super.use(state, world, pos, player, hand, result);
		}
	}

	@Override
	public MultifaceSpreader getSpreader() {
		return null;
	}

}
