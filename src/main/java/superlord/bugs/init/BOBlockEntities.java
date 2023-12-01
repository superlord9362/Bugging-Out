package superlord.bugs.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.block.BOSignBlockEntity;
import superlord.bugs.common.entity.block.MoldSporeSpreaderBlockEntity;

public class BOBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BuggingOut.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<BOSignBlockEntity>> SIGN = REGISTER.register("sign", () -> BlockEntityType.Builder.of(BOSignBlockEntity::new, 
			BOBlocks.ROTTEN_SIGN.get(), BOBlocks.ROTTEN_WALL_SIGN.get()
			).build(null));
	public static final RegistryObject<BlockEntityType<MoldSporeSpreaderBlockEntity>> MOLD_SPORE_SPREADER = REGISTER.register("mold_spore_spreader", () -> BlockEntityType.Builder.of(MoldSporeSpreaderBlockEntity::new, BOBlocks.MOLD_SPORE_SPREADER.get()).build(null));
	
}
