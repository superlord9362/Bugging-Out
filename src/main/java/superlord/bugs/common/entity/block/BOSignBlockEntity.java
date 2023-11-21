package superlord.bugs.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.bugs.init.BOBlockEntities;

public class BOSignBlockEntity extends SignBlockEntity {
	
	public BOSignBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return BOBlockEntities.SIGN.get();
	}

}
