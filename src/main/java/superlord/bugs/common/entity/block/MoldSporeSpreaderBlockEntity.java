package superlord.bugs.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import superlord.bugs.init.BOBlockEntities;
import superlord.bugs.init.BOEffects;

public class MoldSporeSpreaderBlockEntity extends BlockEntity {
	
	public MoldSporeSpreaderBlockEntity(BlockPos pos, BlockState state) {
		super(BOBlockEntities.MOLD_SPORE_SPREADER.get(), pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return BOBlockEntities.MOLD_SPORE_SPREADER.get();
	}
	
	public static void tick(Level level, BlockPos pos, BlockState state, MoldSporeSpreaderBlockEntity moldSporeSpreader) {
		MobEffect effect = BOEffects.MOLD_INFECTION.get();
		for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, new AABB(moldSporeSpreader.worldPosition).inflate(8))) {
			MobEffectInstance activeEffect = entity.getEffect(effect);
			if (activeEffect == null || activeEffect.getDuration() <= 25) {
				entity.addEffect(new MobEffectInstance(effect, 600, 0, false, false, false));
			}
		}
	}

}
