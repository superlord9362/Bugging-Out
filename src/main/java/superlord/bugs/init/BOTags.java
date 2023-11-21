package superlord.bugs.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import superlord.bugs.BuggingOut;

public class BOTags {
	
	public static final TagKey<Block> TERMOSTONE = registerBlockTag("termostone");
	
	private static TagKey<Block> registerBlockTag(String name) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(BuggingOut.MOD_ID, name));
	}

}
