package superlord.bugs.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class MoldInfectionEffect extends MobEffect {

	int i = 0;
	
	public MoldInfectionEffect(MobEffectCategory type, int liquidColor) {
		super(type, liquidColor);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int p_19468_) {
        ((Player)entity).causeFoodExhaustion(0.05F * (float)(p_19468_ + 1));
        if (i > 20) {
            entity.hurt(entity.damageSources().magic(), 1.0F);
        }
	}

	public boolean isDurationEffectTick(int duration, int amplifier) {
		int k = 25 >> amplifier;
		if (k > 0) {
			return duration % k == 0;
		} else {
			i++;
			return true;
		}
	}
	
}
