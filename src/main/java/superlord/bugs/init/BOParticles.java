package superlord.bugs.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;

public class BOParticles {
	
    public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BuggingOut.MOD_ID);

    public static final RegistryObject<SimpleParticleType> TERMITE_MUSHROOM_SPORE = REGISTER.register("termite_mushroom_spore", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> TERMOSTONE_DUST = REGISTER.register("termite_dush", () -> new SimpleParticleType(false));

}
