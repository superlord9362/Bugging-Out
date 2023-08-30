package superlord.bugs.common.block.util;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class WoodExplosion extends Explosion {
	private final boolean fire;
	private final Explosion.BlockInteraction blockInteraction;
	private final Random random = new Random();
	private final Level level;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity source;
	private final float radius;
	private final List<BlockPos> toBlow = Lists.newArrayList();

	public WoodExplosion(Level p_46051_, Entity p_46052_, DamageSource p_46053_, ExplosionDamageCalculator p_46054_, double p_46055_, double p_46056_, double p_46057_, float p_46058_, boolean p_46059_, BlockInteraction p_46060_) {
		super(p_46051_, p_46052_, p_46053_, p_46054_, p_46055_, p_46056_, p_46057_, p_46058_, p_46059_, p_46060_);
		this.level = p_46051_;
		this.source = p_46052_;
		this.radius = p_46058_;
		this.x = p_46055_;
		this.y = p_46056_;
		this.z = p_46057_;
		this.fire = p_46059_;
		this.blockInteraction = p_46060_;
	}

	@Override
	public void finalizeExplosion(boolean p_46076_) {
		if (this.level.isClientSide) {
			this.level.playLocalSound(this.x, this.y, this.z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F, false);
		}

		boolean flag = this.blockInteraction != Explosion.BlockInteraction.NONE;
		if (p_46076_) {
			if (!(this.radius < 2.0F) && flag) {
				this.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D);
			} else {
				this.level.addParticle(ParticleTypes.EXPLOSION, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D);
			}
		}

		if (flag) {
			ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();
			Collections.shuffle(this.toBlow, this.level.random);

			for(BlockPos blockpos : this.toBlow) {
				BlockState blockstate = this.level.getBlockState(blockpos);
				if (!blockstate.isAir() && (blockstate.is(BlockTags.LOGS) || blockstate.is(BlockTags.PLANKS) || blockstate.is(BlockTags.WOODEN_BUTTONS) || blockstate.is(BlockTags.WOODEN_DOORS) || blockstate.is(BlockTags.WOODEN_FENCES) || blockstate.is(BlockTags.WOODEN_PRESSURE_PLATES) || blockstate.is(BlockTags.WOODEN_SLABS) || blockstate.is(BlockTags.WOODEN_STAIRS) || blockstate.is(BlockTags.WOODEN_TRAPDOORS))) {
					BlockPos blockpos1 = blockpos.immutable();
					this.level.getProfiler().push("explosion_blocks");
					if (blockstate.canDropFromExplosion(this.level, blockpos, this) && this.level instanceof ServerLevel) {
						BlockEntity blockentity = blockstate.hasBlockEntity() ? this.level.getBlockEntity(blockpos) : null;
						LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerLevel)this.level)).withRandom(this.level.random).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockpos)).withParameter(LootContextParams.TOOL, ItemStack.EMPTY).withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockentity).withOptionalParameter(LootContextParams.THIS_ENTITY, this.source);
						if (this.blockInteraction == Explosion.BlockInteraction.DESTROY) {
							lootcontext$builder.withParameter(LootContextParams.EXPLOSION_RADIUS, this.radius);
						}

						blockstate.getDrops(lootcontext$builder).forEach((p_46074_) -> {
							addBlockDrops(objectarraylist, p_46074_, blockpos1);
						});
					}

					blockstate.onBlockExploded(this.level, blockpos, this);
					this.level.getProfiler().pop();
				}
			}

			for(Pair<ItemStack, BlockPos> pair : objectarraylist) {
				Block.popResource(this.level, pair.getSecond(), pair.getFirst());
			}
		}

		if (this.fire) {
			for(BlockPos blockpos2 : this.toBlow) {
				if (this.random.nextInt(3) == 0 && this.level.getBlockState(blockpos2).isAir() && this.level.getBlockState(blockpos2.below()).isSolidRender(this.level, blockpos2.below())) {
					this.level.setBlockAndUpdate(blockpos2, BaseFireBlock.getState(this.level, blockpos2));
				}
			}
		}

	}
}
