package superlord.bugs.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {

	public final ForgeConfigSpec.IntValue glowwormInfestedTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteKamakazeInfestedTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteNymphInfestedTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteSoldierInfestedTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteWorkerInfestedTunnelsSpawnWeight;

	public final ForgeConfigSpec.IntValue glowwormTermiteTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteKamakazeTermiteTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteNymphTermiteTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteSoldierTermiteTunnelsSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteWorkerTermiteTunnelsSpawnWeight;

	public final ForgeConfigSpec.IntValue glowwormTermiteGallerySpawnWeight;
	public final ForgeConfigSpec.IntValue termiteKamakazeTermiteGallerySpawnWeight;
	public final ForgeConfigSpec.IntValue termiteNymphTermiteGallerySpawnWeight;
	public final ForgeConfigSpec.IntValue termiteSoldierTermiteGallerySpawnWeight;
	public final ForgeConfigSpec.IntValue termiteWorkerTermiteGallerySpawnWeight;

	public final ForgeConfigSpec.IntValue glowwormFungalGardenSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteKamakazeFungalGardenSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteNymphFungalGardenSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteSoldierFungalGardenSpawnWeight;
	public final ForgeConfigSpec.IntValue termiteWorkerFungalGardenSpawnWeight;
	
	public final ForgeConfigSpec.IntValue barkBeetleMoldyGrottoSpawnWeight;
	public final ForgeConfigSpec.IntValue springtailMoldyGrottoSpawnWeight;
	
	public final ForgeConfigSpec.IntValue barkBeetleBeetleNestSpawnWeight;
	public final ForgeConfigSpec.IntValue springtailBeetleNestSpawnWeight;
	
	public final ForgeConfigSpec.IntValue barkBeetleMossyRegrowthSpawnWeight;
	public final ForgeConfigSpec.IntValue springtailMossyRegrowthSpawnWeight;
	
	public final ForgeConfigSpec.IntValue barkBeetleRottenPassagesSpawnWeight;
	public final ForgeConfigSpec.IntValue springtailRottenPassagesSpawnWeight;

	public final ForgeConfigSpec.BooleanValue superSecretSettings;

	public ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("Termite Mound Settings");
		builder.push("Infested Tunnels Settings");
		this.glowwormInfestedTunnelsSpawnWeight = buildInt(builder, "Glowworm Infested Tunnels Spawn Weight", "all", 10, 0, 300, "The weight of Glowworms in vanilla's spawn rate in the Infested Tunnels biome. Default is 10.");
		this.termiteSoldierInfestedTunnelsSpawnWeight = buildInt(builder, "Termite Soldier Infested Tunnels Spawn Weight", "all", 6, 0, 300, "The weight of Termite Soldier in vanilla's spawn rate in the Infested Tunnels biome. Default is 6.");
		this.termiteKamakazeInfestedTunnelsSpawnWeight = buildInt(builder, "Termite Kamikaze Infested Tunnels Spawn Weight", "all", 4, 0, 300, "The weight of Termite Kamikazes in vanilla's spawn rate in the Infested Tunnels biome. Default is 4.");
		this.termiteWorkerInfestedTunnelsSpawnWeight = buildInt(builder, "Termite Worker Infested Tunnels Spawn Weight", "all", 0, 0, 300, "The weight of Termite Workers in vanilla's spawn rate in the Infested Tunnels biome. Default is 0.");
		this.termiteNymphInfestedTunnelsSpawnWeight = buildInt(builder, "Termite Nymph Infested Tunnels Spawn Weight", "all", 0, 0, 300, "The weight of Termite Nymphs in vanilla's spawn rate in the Infested Tunnels biome. Default is 0.");
		builder.pop();
		builder.push("Fungal Gardens Settings");
		this.glowwormFungalGardenSpawnWeight = buildInt(builder, "Glowworm Fungal Gardens Spawn Weight", "all", 0, 0, 300, "The weight of Glowworms in vanilla's spawn rate in the Fungal Gardens biome. Default is 0.");
		this.termiteSoldierFungalGardenSpawnWeight = buildInt(builder, "Termite Soldier Fungal Gardens Spawn Weight", "all", 5, 0, 300, "The weight of Termite Soldier in vanilla's spawn rate in the Fungal Gardens biome. Default is 5.");
		this.termiteKamakazeFungalGardenSpawnWeight = buildInt(builder, "Termite Kamikaze Fungal Gardens Spawn Weight", "all", 0, 0, 300, "The weight of Termite Kamikazes in vanilla's spawn rate in the Fungal Gardens biome. Default is 0.");
		this.termiteWorkerFungalGardenSpawnWeight = buildInt(builder, "Termite Worker Fungal Gardens Spawn Weight", "all", 15, 0, 300, "The weight of Termite Workers in vanilla's spawn rate in the Fungal Gardens biome. Default is 15.");
		this.termiteNymphFungalGardenSpawnWeight = buildInt(builder, "Termite Nymph Fungal Gardens Spawn Weight", "all", 8, 0, 300, "The weight of Termite Nymphs in vanilla's spawn rate in the Fungal Gardens biome. Default is 8.");
		builder.pop();
		builder.push("Termite Gallery Settings");
		this.glowwormTermiteGallerySpawnWeight = buildInt(builder, "Glowworm Termite Gallery Spawn Weight", "all", 0, 0, 300, "The weight of Glowworms in vanilla's spawn rate in the Termite Gallery biome. Default is 0.");
		this.termiteSoldierTermiteGallerySpawnWeight = buildInt(builder, "Termite Soldier Termite Gallery Spawn Weight", "all", 8, 0, 300, "The weight of Termite Soldier in vanilla's spawn rate in the Termite Gallery biome. Default is 8.");
		this.termiteKamakazeTermiteGallerySpawnWeight = buildInt(builder, "Termite Kamikaze Termite Gallery Spawn Weight", "all", 4, 0, 300, "The weight of Termite Kamikazes in vanilla's spawn rate in the Termite Gallery biome. Default is 4.");
		this.termiteWorkerTermiteGallerySpawnWeight = buildInt(builder, "Termite Worker Termite Gallery Spawn Weight", "all", 15, 0, 300, "The weight of Termite Workers in vanilla's spawn rate in the Termite Gallery biome. Default is 15.");
		this.termiteNymphTermiteGallerySpawnWeight = buildInt(builder, "Termite Nymph Termite Gallery Spawn Weight", "all", 10, 0, 300, "The weight of Termite Nymphs in vanilla's spawn rate in the Termite Gallery biome. Default is 10.");
		builder.pop();
		builder.push("Termite Tunnels Settings");
		this.glowwormTermiteTunnelsSpawnWeight = buildInt(builder, "Glowworm Termite Tunnels Spawn Weight", "all", 0, 0, 300, "The weight of Glowworms in vanilla's spawn rate in the Termite Tunnels biome. Default is 0.");
		this.termiteSoldierTermiteTunnelsSpawnWeight = buildInt(builder, "Termite Soldier Termite Tunnels Spawn Weight", "all", 6, 0, 300, "The weight of Termite Soldier in vanilla's spawn rate in the Termite Tunnels biome. Default is 6.");
		this.termiteKamakazeTermiteTunnelsSpawnWeight = buildInt(builder, "Termite Kamikaze Termite Tunnels Spawn Weight", "all", 3, 0, 300, "The weight of Termite Kamikazes in vanilla's spawn rate in the Termite Tunnels biome. Default is 3.");
		this.termiteWorkerTermiteTunnelsSpawnWeight = buildInt(builder, "Termite Worker Termite Tunnels Spawn Weight", "all", 10, 0, 300, "The weight of Termite Workers in vanilla's spawn rate in the Termite Tunnels biome. Default is 10.");
		this.termiteNymphTermiteTunnelsSpawnWeight = buildInt(builder, "Termite Nymph Termite Tunnels Spawn Weight", "all", 0, 0, 300, "The weight of Termite Nymphs in vanilla's spawn rate in the Termite Tunnels biome. Default is 0.");
		builder.pop();
		builder.pop();
		builder.push("Rotten Log Settings");
		builder.push("Beetle Nest");
		this.barkBeetleBeetleNestSpawnWeight = buildInt(builder, "Bark Beetle Beetle Nest Spawn Weight", "all", 20, 0, 300, "The weight of Bark Beetles in vanila's spawn rate in the Beetle Nest biome. Default is 20.");
		this.springtailBeetleNestSpawnWeight = buildInt(builder, "Springtail Beetle Nest Spawn Weight", "all", 0, 0, 300, "The weight of Springtails in vanilla's spawn rate in the Beetle Nest biome. Default is 0.");
		builder.pop();
		builder.push("Moldy Grotto");
		this.barkBeetleMoldyGrottoSpawnWeight = buildInt(builder, "Bark Beetle Moldy Grotto Spawn Weight", "all", 0, 0, 300, "The weight of Bark Beetles in vanila's spawn rate in the Moldy Grotto biome. Default is 0.");
		this.springtailMoldyGrottoSpawnWeight = buildInt(builder, "Springtail Moldy Grotto Spawn Weight", "all", 17, 0, 300, "The weight of Springtails in vanilla's spawn rate in the Moldy Grotto biome. Default is 17.");
		builder.pop();
		builder.push("Mossy Regrowth");
		this.barkBeetleMossyRegrowthSpawnWeight = buildInt(builder, "Bark Beetle Mossy Regrowth Spawn Weight", "all", 6, 0, 300, "The weight of Bark Beetles in vanila's spawn rate in the Mossy Regrowth biome. Default is 6.");
		this.springtailMossyRegrowthSpawnWeight = buildInt(builder, "Springtail Mossy Regrowth Spawn Weight", "all", 8, 0, 300, "The weight of Springtails in vanilla's spawn rate in the Mossy Regrowth biome. Default is 8.");
		builder.pop();
		builder.push("Rotten Passages");
		this.barkBeetleRottenPassagesSpawnWeight = buildInt(builder, "Bark Beetle Rotten Passages Spawn Weight", "all", 8, 0, 300, "The weight of Bark Beetles in vanila's spawn rate in the Rotten Passages biome. Default is 8.");
		this.springtailRottenPassagesSpawnWeight = buildInt(builder, "Springtail Rotten Passages Spawn Weight", "all", 3, 0, 300, "The weight of Springtails in vanilla's spawn rate in the Rotten Passages biome. Default is 3");
		builder.pop();
		builder.push("Misc Settings");
		this.superSecretSettings = buildBoolean(builder, "Super Secret Setting", "all", false, "Even I don't know what it does. Default is false");
		builder.pop();
	}

	private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
		return builder.comment(comment).translation(name).define(name, defaultValue);
	}

	private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment){
		return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
	}

}
