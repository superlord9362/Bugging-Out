package superlord.bugs.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.init.BOBlocks;

public class PorousTermostoneCeilingBlobFeature extends Feature<NoneFeatureConfiguration> {
   public PorousTermostoneCeilingBlobFeature(Codec<NoneFeatureConfiguration> p_65865_) {
      super(p_65865_);
   }

   public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159861_) {
      WorldGenLevel worldgenlevel = p_159861_.level();
      BlockPos blockpos = p_159861_.origin();
      Random random = p_159861_.random();
      if (!worldgenlevel.isEmptyBlock(blockpos)) {
         return false;
      } else {
         BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
         if (!blockstate.is(BOBlocks.TERMOSTONE.get()) && !blockstate.is(BOBlocks.POROUS_TERMOSTONE.get()) && !blockstate.is(BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get())) {
            return false;
         } else {
            worldgenlevel.setBlock(blockpos, BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState(), 2);

            for(int i = 0; i < 1500; ++i) {
               BlockPos blockpos1 = blockpos.offset(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));
               if (worldgenlevel.getBlockState(blockpos1).isAir()) {
                  int j = 0;

                  for(Direction direction : Direction.values()) {
                     if (worldgenlevel.getBlockState(blockpos1.relative(direction)).is(BOBlocks.POROUS_TERMOSTONE.get())) {
                        ++j;
                     }

                     if (j > 1) {
                        break;
                     }
                  }

                  if (j == 1) {
                     worldgenlevel.setBlock(blockpos1, BOBlocks.POROUS_TERMOSTONE.get().defaultBlockState(), 2);
                  }
               }
            }

            return true;
         }
      }
   }
}