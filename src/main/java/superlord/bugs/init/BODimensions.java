package superlord.bugs.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import superlord.bugs.BuggingOut;

public class BODimensions {
	
	//public static final DeferredRegister<PoiType> REGISTER = DeferredRegister.create(ForgeRegistries.POI_TYPES, BuggingOut.MOD_ID);
	
	public static final ResourceKey<DimensionType> BUG_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(BuggingOut.MOD_ID, "bugs"));
	public static final ResourceKey<Level> BUGS = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BuggingOut.MOD_ID, "bugs"));
	
}
