package superlord.bugs.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.world.features.HugeTermiteMushroomFeature;
import superlord.bugs.common.world.features.LandSphereReplaceFeature;

public class BOFeatures {

    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, BuggingOut.MOD_ID);

    public static final RegistryObject<HugeTermiteMushroomFeature> HUGE_TERMITE_MUSHROOM = REGISTER.register("hige_termite_mushroom", () -> new HugeTermiteMushroomFeature(NoneFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<LandSphereReplaceFeature> LAND_DISK = REGISTER.register("land_disk", () -> new LandSphereReplaceFeature(DiskConfiguration.CODEC.stable()));

    
}
