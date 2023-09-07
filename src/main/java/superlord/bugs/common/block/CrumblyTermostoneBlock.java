package superlord.bugs.common.block;

import java.util.Random;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.bugs.init.BOCreatureAttributes;

public class CrumblyTermostoneBlock extends Block {
	protected static final VoxelShape COLLISION_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	protected static final VoxelShape OUTLINE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public static final EnumProperty<Breaking> BREAKING = EnumProperty.create("breaking", Breaking.class);
	private static final Object2IntMap<Breaking> DELAY_UNTIL_NEXT_TILT_STATE = Util.make(new Object2IntArrayMap<>(), (p_152305_) -> {
		p_152305_.defaultReturnValue(-1);
		p_152305_.put(Breaking.STABLE, 40);
		p_152305_.put(Breaking.BREAKING, 1);
		p_152305_.put(Breaking.BROKEN, 1);
	});

	public CrumblyTermostoneBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(BREAKING, Breaking.NONE));
	}

	public VoxelShape getCollisionShape(BlockState p_51176_, BlockGetter p_51177_, BlockPos p_51178_, CollisionContext p_51179_) {
		return COLLISION_SHAPE;
	}

	public VoxelShape getShape(BlockState p_51171_, BlockGetter p_51172_, BlockPos p_51173_, CollisionContext p_51174_) {
		return OUTLINE_SHAPE;
	}

	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) entityIn;
			if (entity.getMobType() != BOCreatureAttributes.TERMITE) {
				if (entity instanceof Player) {
					Player player = (Player) entity;
					if (!player.isCreative()) {
						if (state.getValue(BREAKING) == Breaking.NONE) {
							this.setBreakandScheduleTick(state, worldIn, pos, Breaking.STABLE);
						}
					}
				} else {
					if (state.getValue(BREAKING) == Breaking.NONE) {
						this.setBreakandScheduleTick(state, worldIn, pos, Breaking.STABLE);
					}
				}
			}
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52719_) {
		p_52719_.add(BREAKING);
	}

	@Override
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		Breaking breaking = state.getValue(BREAKING);
		if (breaking == Breaking.STABLE) {
			this.setBreakandScheduleTick(state, world, pos, Breaking.BREAKING);
		} else if (breaking == Breaking.BREAKING) {
			this.setBreakandScheduleTick(state, world, pos, Breaking.BROKEN);
		} else if (breaking == Breaking.BROKEN) {
			breakBlock(state, world, pos);
		}
	}

	private static void breakBlock(BlockState state, Level world, BlockPos pos) {
		world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
	}

	public int tickRate() {
		return 20;
	}

	public void animateTick(BlockState p_57494_, Level world, BlockPos pos, Random p_57497_) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;
		world.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, world.getBlockState(pos)), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

	private void setBreakandScheduleTick(BlockState state, Level world, BlockPos pos, Breaking breaking) {
		setBreaking(state, world, pos, breaking);
		int i = DELAY_UNTIL_NEXT_TILT_STATE.getInt(breaking);
		if (i != -1) {
			world.scheduleTick(pos, this, i);
		}
	}

	private static void setBreaking(BlockState p_152278_, Level p_152279_, BlockPos p_152280_, Breaking p_152281_) {
		p_152279_.setBlock(p_152280_, p_152278_.setValue(BREAKING, p_152281_), 2);
	}

	public enum Breaking implements StringRepresentable {
		STABLE("stable"),
		BREAKING("breaking"),
		BROKEN("broken"),
		NONE("none");

		private final String name;

		private Breaking(String name) {
			this.name = name;
		}

		public String getSerializedName() {
			return name;
		}
	}

}
