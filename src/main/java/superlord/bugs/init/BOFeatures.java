package superlord.bugs.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.features.CrumblyTermiteMoundFeature;
import superlord.bugs.common.world.features.FuzzyCeilingMossFeature;
import superlord.bugs.common.world.features.FuzzyMossFeature;
import superlord.bugs.common.world.features.FuzzyWallMossFeature;
import superlord.bugs.common.world.features.GlowwormHoleFeature;
import superlord.bugs.common.world.features.HugeTermiteMushroomFeature;
import superlord.bugs.common.world.features.LandSphereReplaceFeature;
import superlord.bugs.common.world.features.PorousTermostoneCeilingBlobFeature;
import superlord.bugs.common.world.features.ShelfMushroomFeature;
import superlord.bugs.common.world.features.TermiteMoundFeature;
import superlord.bugs.common.world.features.TermiteMyceliumCeilingBlobFeature;
import superlord.bugs.common.world.features.TermostoneCeilingBlobFeature;
import superlord.bugs.common.world.features.TermostonePillarFeature;

public class BOFeatures {

	public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, BuggingOut.MOD_ID);

	public static final RegistryObject<HugeTermiteMushroomFeature> HUGE_TERMITE_MUSHROOM = REGISTER.register("hige_termite_mushroom", () -> new HugeTermiteMushroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<LandSphereReplaceFeature> LAND_DISK = REGISTER.register("land_disk", () -> new LandSphereReplaceFeature(DiskConfiguration.CODEC.stable()));
	public static final RegistryObject<TermiteMyceliumCeilingBlobFeature> TERMITE_MYCELIUM_CEILING_BLOB = REGISTER.register("termite_mycelium_ceiling_blob", () -> new TermiteMyceliumCeilingBlobFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<TermostoneCeilingBlobFeature> TERMOSTONE_CEILING_BLOB = REGISTER.register("termostone_ceiling_blob", () -> new TermostoneCeilingBlobFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<PorousTermostoneCeilingBlobFeature> POROUS_TERMOSTONE_CEILING_BLOB = REGISTER.register("porous_termostone_ceiling_blob", () -> new PorousTermostoneCeilingBlobFeature(NoneFeatureConfiguration.CODEC.stable()));

	public static final RegistryObject<GlowwormHoleFeature> GLOWWORM_HOLE = REGISTER.register("glowworm_hole", () -> new GlowwormHoleFeature(NoneFeatureConfiguration.CODEC.stable()));

	public static final RegistryObject<TermostonePillarFeature> TERMOSTONE_PILLAR = REGISTER.register("termostone_pillar", () -> new TermostonePillarFeature(LargeDripstoneConfiguration.CODEC.stable()));

	public static final RegistryObject<TermiteMoundFeature> TERMITE_MOUND = REGISTER.register("termite_mound", () -> new TermiteMoundFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<CrumblyTermiteMoundFeature> CRUMBLY_TERMITE_MOUND = REGISTER.register("crumbly_termite_mound", () -> new CrumblyTermiteMoundFeature(BlockStateConfiguration.CODEC));

	public static final RegistryObject<FuzzyMossFeature> FUZZY_MOSS = REGISTER.register("fuzzy_moss", () -> new FuzzyMossFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<FuzzyWallMossFeature> FUZZY_WALL_MOSS = REGISTER.register("fuzzy_wall_moss", () -> new FuzzyWallMossFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<FuzzyCeilingMossFeature> FUZZY_CEILING_MOSS = REGISTER.register("fuzzy_ceiling_moss", () -> new FuzzyCeilingMossFeature(NoneFeatureConfiguration.CODEC.stable()));
	public static final RegistryObject<ShelfMushroomFeature> SHELF_MUSHROOMS = REGISTER.register("shelf_mushrooms", () -> new ShelfMushroomFeature(NoneFeatureConfiguration.CODEC.stable()));
	
}
