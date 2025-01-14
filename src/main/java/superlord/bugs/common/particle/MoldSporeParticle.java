package superlord.bugs.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoldSporeParticle extends TextureSheetParticle {
	MoldSporeParticle(ClientLevel p_172403_, SpriteSet p_172404_, double p_172405_, double p_172406_, double p_172407_) {
		super(p_172403_, p_172405_, p_172406_ - 0.125D, p_172407_);
		this.setSize(0.01F, 0.01F);
		this.pickSprite(p_172404_);
		this.quadSize *= this.random.nextFloat() * 0.6F + 0.2F;
		this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
		this.hasPhysics = false;
		this.friction = 1.0F;
		this.gravity = 0.0F;
	}

	MoldSporeParticle(ClientLevel p_172409_, SpriteSet p_172410_, double p_172411_, double p_172412_, double p_172413_, double p_172414_, double p_172415_, double p_172416_) {
		super(p_172409_, p_172411_, p_172412_ - 0.125D, p_172413_, p_172414_, p_172415_, p_172416_);
		this.setSize(0.01F, 0.01F);
		this.pickSprite(p_172410_);
		this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
		this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
		this.hasPhysics = false;
		this.friction = 1.0F;
		this.gravity = 0.0F;
	}

	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class MoldSporeAirProvider implements ParticleProvider<SimpleParticleType> {

		private final SpriteSet sprite;

		public MoldSporeAirProvider(SpriteSet p_172419_) {
			this.sprite = p_172419_;
		}

		public Particle createParticle(SimpleParticleType p_172430_, ClientLevel p_172431_, double p_172432_, double p_172433_, double p_172434_, double p_172435_, double p_172436_, double p_172437_) {
			MoldSporeParticle suspendedparticle = new MoldSporeParticle(p_172431_, this.sprite, p_172432_, p_172433_, p_172434_, 0.0D, (double)-0.8F, 0.0D);
			suspendedparticle.lifetime = Mth.randomBetweenInclusive(p_172431_.random, 500, 1000);
			suspendedparticle.gravity = 0.01F;
			suspendedparticle.pickSprite(sprite);
			return suspendedparticle;
		}
	}
}