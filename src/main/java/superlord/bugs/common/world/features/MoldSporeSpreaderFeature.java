package superlord.bugs.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.bugs.common.block.MoldSporeSpreaderBlock;
import superlord.bugs.init.BOBlocks;

public class MoldSporeSpreaderFeature extends Feature<NoneFeatureConfiguration> {
   public MoldSporeSpreaderFeature(Codec<NoneFeatureConfiguration> p_66808_) {
      super(p_66808_);
   }

   public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_160341_) {
      WorldGenLevel worldgenlevel = p_160341_.level();
      BlockPos blockpos = p_160341_.origin();
      BlockState belowBlockstate = worldgenlevel.getBlockState(blockpos.below());
      BlockState originBlockState = worldgenlevel.getBlockState(blockpos);
      BlockState aboveBlockstate = worldgenlevel.getBlockState(blockpos.above());
      if ((belowBlockstate.is(BOBlocks.ROTTEN_WOOD.get()) || belowBlockstate.is(BOBlocks.MULCH.get()))&& originBlockState.is(Blocks.AIR) && aboveBlockstate.is(Blocks.AIR)) {
    	  worldgenlevel.setBlock(blockpos, BOBlocks.MOLD_SPORE_SPREADER.get().defaultBlockState().setValue(MoldSporeSpreaderBlock.HALF, DoubleBlockHalf.LOWER), 2);
    	  worldgenlevel.setBlock(blockpos.above(), BOBlocks.MOLD_SPORE_SPREADER.get().defaultBlockState().setValue(MoldSporeSpreaderBlock.HALF, DoubleBlockHalf.UPPER), 2);
         return true;
      } else {
         return false;
      }
   }
}