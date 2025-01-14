package superlord.bugs.common.world.surfacedecorators;

import java.util.Random;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.bugs.init.BOBlocks;

public class RottenLogSurfaceDecorator extends SurfaceDecorator {
	
	public RottenLogSurfaceDecorator() {
		
	}
	
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings) {
		Random random = new Random();
		chunk.setBlockState(pos, BOBlocks.ROTTEN_WOOD.get().defaultBlockState(), false);
		int y = pos.getY();
		pos.move(Direction.DOWN);
		for (int i = 0; i < y +- random.nextInt(4); i++) {
			//if (chunk.getBlockState(pos) == settings.defaultBlock()) {
				if (pos.getY() < 4) {
					if (chunk.getBlockState(pos) == Blocks.AIR.defaultBlockState()) {
						chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
					} else chunk.setBlockState(pos, BOBlocks.MULCH.get().defaultBlockState(), false);
				} else {
					if (chunk.getBlockState(pos) == Blocks.AIR.defaultBlockState()) {
						chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
					} else chunk.setBlockState(pos, BOBlocks.ROTTEN_WOOD.get().defaultBlockState(), false);
				}
                pos.move(Direction.DOWN);
			//}
		}
	}

}
