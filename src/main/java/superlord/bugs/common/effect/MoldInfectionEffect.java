package superlord.bugs.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import superlord.bugs.common.entity.Springtail;

public class MoldInfectionEffect extends MobEffect {

	int i = 0;

	public MoldInfectionEffect(MobEffectCategory type, int liquidColor) {
		super(type, liquidColor);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int p_19468_) {
		if (entity instanceof Player player) {
			player.causeFoodExhaustion(0.05F * (float)(p_19468_ + 1));
		}
		if (i > 20) {
			if (entity instanceof Springtail springtail) {

			} else {
				entity.hurt(entity.damageSources().magic(), 1.0F);
			}
		}
	}

	public boolean isDurationEffectTick(int duration, int amplifier) {
		int k = 25 >> duration;
		if (k > 0) {
			return duration % k == 0;
		} else {
			i++;
			return true;
		}
	}

}
