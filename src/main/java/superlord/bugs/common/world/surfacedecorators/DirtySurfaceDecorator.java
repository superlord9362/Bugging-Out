package superlord.bugs.common.world.surfacedecorators;

import java.util.Random;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class DirtySurfaceDecorator extends SurfaceDecorator {


	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings) {
		Random random = new Random();
		chunk.setBlockState(pos, Blocks.DIRT.defaultBlockState(), false);
		int y = pos.getY();
		pos.move(Direction.DOWN);
		for (int i = 0; i < y +- random.nextInt(4); i++) {
			if (chunk.getBlockState(pos) == settings.defaultBlock()) {
				chunk.setBlockState(pos, Blocks.DIRT.defaultBlockState(), false);
                pos.move(Direction.DOWN);
			} else return;
		}
	}
}
