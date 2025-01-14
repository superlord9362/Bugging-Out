package superlord.bugs.common.world.surfacedecorators;

import java.util.HashMap;

import net.minecraft.resources.ResourceLocation;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.util.FastNoise;

public class SurfaceDecorators {
	
	public static final HashMap<ResourceLocation, SurfaceDecorator> BIOME_TO_SURFACE_DECORATOR = new HashMap<>();
	private static final SurfaceDecorator DEFAULT_DECORATOR = new DefaultSurfaceDecorator();
	static FastNoise noise;
	
	static {
		register(new ResourceLocation(BuggingOut.MOD_ID, "moldy_grotto"),
				new RottenLogSurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "mossy_regrowth"),
				new RottenLogSurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "beetle_nest"),
				new RottenLogSurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "rotten_passages"),
				new RottenLogSurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "dirt_tunnels"),
				new DirtySurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "grassy_meadows"),
				new DirtySurfaceDecorator());
		register(new ResourceLocation(BuggingOut.MOD_ID, "flower_meadows"),
				new DirtySurfaceDecorator());
	}
	
	public static void setFastNoise(FastNoise noise) {
		SurfaceDecorators.noise = noise;
	}
	
	public static void register(ResourceLocation biome, SurfaceDecorator decorator) {
		BIOME_TO_SURFACE_DECORATOR.put(biome, decorator);
	}
	
	public static SurfaceDecorator getSurfaceDecorator(ResourceLocation biomeLocation) {
		return BIOME_TO_SURFACE_DECORATOR.getOrDefault(biomeLocation, DEFAULT_DECORATOR);
	}

}
