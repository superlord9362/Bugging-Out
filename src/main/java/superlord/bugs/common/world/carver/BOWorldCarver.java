package superlord.bugs.common.world.carver;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import net.minecraft.world.level.material.Fluids;
import superlord.bugs.init.BOBlocks;

public class BOWorldCarver extends CaveWorldCarver {

	public BOWorldCarver(Codec<CaveCarverConfiguration> p_159194_) {
		super(p_159194_);
		this.replaceableBlocks = ImmutableSet.of(BOBlocks.TERMOSTONE.get(), BOBlocks.FERROUS_TERMOSTONE.get(), BOBlocks.POROUS_TERMOSTONE.get(), BOBlocks.TERMITE_MUSHROOM_MYCELIUM.get());
		this.liquids = ImmutableSet.of(Fluids.LAVA, Fluids.WATER);
	}

}
