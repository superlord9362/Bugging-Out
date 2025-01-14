package superlord.bugs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import superlord.bugs.BuggingOut;

public class BOWoodTypes {
	
	public static final BlockSetType ROTTEN_TYPE = BlockSetType.register(new BlockSetType(new ResourceLocation(BuggingOut.MOD_ID, "rotten").toString()));
	
	public static WoodType ROTTEN = WoodType.register(new WoodType(new ResourceLocation(BuggingOut.MOD_ID, "rotten").toString(), ROTTEN_TYPE));

}
