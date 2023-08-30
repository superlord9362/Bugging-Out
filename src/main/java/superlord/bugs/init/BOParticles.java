package superlord.bugs.init;

import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.particle.TermiteMushroomSporeParticle;

@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BOParticles {
	
	public static final SimpleParticleType TERMITE_MUSHROOM_SPORE = registerBasicParticle("termite_mushroom_spore");
	
	private static SimpleParticleType registerBasicParticle(String name) {
		return ParticleRegistry.registerParticle(name, new SimpleParticleType(false));
	}
	
	@SuppressWarnings({ "resource", "deprecation" })
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent e) {
		ParticleEngine particles = Minecraft.getInstance().particleEngine;
		particles.register(TERMITE_MUSHROOM_SPORE, TermiteMushroomSporeParticle.Provider::new);
	}
	
	@Mod.EventBusSubscriber(modid = BuggingOut.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public class ParticleRegistry {
		
		public static final List<ParticleType<?>> PARTICLE_TYPES = Lists.newArrayList();
		
		public static <T extends ParticleType<?>> T registerParticle(String name, T particle) {
			particle.setRegistryName(new ResourceLocation(BuggingOut.MOD_ID, name));
			PARTICLE_TYPES.add(particle);
			return particle;
		}
		
		@SubscribeEvent
		public static void registerParticles(RegisterEvent event) {
			IForgeRegistry<ParticleType<?>> registry = event.getForgeRegistry();
			for (ParticleType<?> particle : PARTICLE_TYPES) {
				registry.register(particle.toString(), particle);
			}
		}
		
	}

}
