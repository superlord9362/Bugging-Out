package superlord.bugs.config;

import net.minecraftforge.fml.config.ModConfig;
import superlord.bugs.BuggingOut;

public class BuggingOutConfig {
	
	//Infested Tunnels Spawns
	public static int glowwormInfestedTunnelsSpawnWeight = 10;
	public static int termiteKamakazeInfestedTunnelsSpawnWeight = 4;
	public static int termiteNymphInfestedTunnelsSpawnWeight = 0;
	public static int termiteSoldierInfestedTunnelsSpawnWeight = 6;
	public static int termiteWorkerInfestedTunnelsSpawnWeight = 0;
	//Termite Tunnels Spawns
	public static int glowwormTermiteTunnelsSpawnWeight = 0;
	public static int termiteKamakazeTermiteTunnelsSpawnWeight = 3;
	public static int termiteNymphTermiteTunnelsSpawnWeight = 0;
	public static int termiteSoldierTermiteTunnelsSpawnWeight = 6;
	public static int termiteWorkerTermiteTunnelsSpawnWeight = 10;
	//Termite Gallery Spawns
	public static int glowwormTermiteGallerySpawnWeight = 0;
	public static int termiteKamakazeTermiteGallerySpawnWeight = 4;
	public static int termiteNymphTermiteGallerySpawnWeight = 10;
	public static int termiteSoldierTermiteGallerySpawnWeight = 8;
	public static int termiteWorkerTermiteGallerySpawnWeight = 15;
	//Fungal Gardens Spawns
	public static int glowwormFungalGardenSpawnWeight = 0;
	public static int termiteKamakazeFungalGardenSpawnWeight = 0;
	public static int termiteNymphFungalGardenSpawnWeight = 8;
	public static int termiteSoldierFungalGardenSpawnWeight = 5;
	public static int termiteWorkerFungalGardenSpawnWeight = 15;
	//Moldy Grotto
	public static int barkBeetleMoldyGrottoSpawnWeight = 0;
	public static int springtailMoldyGrottoSpawnWeight = 17;
	//Beetle Nest
	public static int barkBeetleBeetleNestSpawnWeight = 20;
	public static int springtailBeetleNestSpawnWeight = 0;
	//Mossy Regrowth
	public static int barkBeetleMossyRegrowthSpawnWeight = 6;
	public static int springtailMossyRegrowthSpawnWeight  = 8;
	//Rotten Passages
	public static int barkBeetleRottenPassagesSpawnWeight = 8;
	public static int springtailRottenPassagesSpawnWeight = 3;
	//Misc settings
	public static boolean superSecretSettings = false;
	
	public static void bakeClient(final ModConfig config) {
	}
	
	public static void bakeServer(final ModConfig config) {
		try {
			glowwormInfestedTunnelsSpawnWeight = BOConfigHolder.SERVER.glowwormInfestedTunnelsSpawnWeight.get();
			termiteKamakazeInfestedTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteKamakazeInfestedTunnelsSpawnWeight.get();
			termiteNymphInfestedTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteNymphInfestedTunnelsSpawnWeight.get();
			termiteSoldierInfestedTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteSoldierInfestedTunnelsSpawnWeight.get();
			termiteWorkerInfestedTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteWorkerInfestedTunnelsSpawnWeight.get();
			glowwormTermiteTunnelsSpawnWeight = BOConfigHolder.SERVER.glowwormTermiteTunnelsSpawnWeight.get();
			termiteKamakazeTermiteTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteKamakazeTermiteTunnelsSpawnWeight.get();
			termiteNymphTermiteTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteNymphTermiteTunnelsSpawnWeight.get();
			termiteSoldierTermiteTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteSoldierTermiteTunnelsSpawnWeight.get();
			termiteWorkerTermiteTunnelsSpawnWeight = BOConfigHolder.SERVER.termiteWorkerTermiteTunnelsSpawnWeight.get();
			glowwormTermiteGallerySpawnWeight = BOConfigHolder.SERVER.glowwormTermiteGallerySpawnWeight.get();
			termiteKamakazeTermiteGallerySpawnWeight = BOConfigHolder.SERVER.termiteKamakazeTermiteGallerySpawnWeight.get();
			termiteNymphTermiteGallerySpawnWeight = BOConfigHolder.SERVER.termiteNymphTermiteGallerySpawnWeight.get();
			termiteSoldierTermiteGallerySpawnWeight = BOConfigHolder.SERVER.termiteSoldierTermiteGallerySpawnWeight.get();
			termiteWorkerTermiteGallerySpawnWeight = BOConfigHolder.SERVER.termiteWorkerTermiteGallerySpawnWeight.get();
			glowwormFungalGardenSpawnWeight = BOConfigHolder.SERVER.glowwormFungalGardenSpawnWeight.get();
			termiteKamakazeFungalGardenSpawnWeight = BOConfigHolder.SERVER.termiteKamakazeFungalGardenSpawnWeight.get();
			termiteNymphFungalGardenSpawnWeight = BOConfigHolder.SERVER.termiteNymphFungalGardenSpawnWeight.get();
			termiteSoldierFungalGardenSpawnWeight = BOConfigHolder.SERVER.termiteSoldierFungalGardenSpawnWeight.get();
			termiteWorkerFungalGardenSpawnWeight = BOConfigHolder.SERVER.termiteWorkerFungalGardenSpawnWeight.get();
			barkBeetleMoldyGrottoSpawnWeight = BOConfigHolder.SERVER.barkBeetleMoldyGrottoSpawnWeight.get();
			springtailMoldyGrottoSpawnWeight = BOConfigHolder.SERVER.springtailMoldyGrottoSpawnWeight.get();
			barkBeetleBeetleNestSpawnWeight = BOConfigHolder.SERVER.barkBeetleBeetleNestSpawnWeight.get();
			springtailBeetleNestSpawnWeight = BOConfigHolder.SERVER.springtailBeetleNestSpawnWeight.get();
			barkBeetleMossyRegrowthSpawnWeight = BOConfigHolder.SERVER.barkBeetleMossyRegrowthSpawnWeight.get();
			springtailMossyRegrowthSpawnWeight = BOConfigHolder.SERVER.springtailMossyRegrowthSpawnWeight.get();
			barkBeetleRottenPassagesSpawnWeight = BOConfigHolder.SERVER.barkBeetleRottenPassagesSpawnWeight.get();
			springtailRottenPassagesSpawnWeight = BOConfigHolder.SERVER.springtailRottenPassagesSpawnWeight.get();
			superSecretSettings = BOConfigHolder.SERVER.superSecretSettings.get();
		} catch (Exception e) {
			BuggingOut.LOGGER.warn("An exception was caused trying to load the config for Bugging Out!");
			e.printStackTrace();
		}
	}
	
}
