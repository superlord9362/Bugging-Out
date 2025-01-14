package superlord.bugs.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import superlord.bugs.common.entity.block.BOSignBlockEntity;

public class BOStandingSignBlock extends StandingSignBlock {

	public BOStandingSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new BOSignBlockEntity(pos, state);
	}
	
}
