package superlord.bugs.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.block.BOSignBlockEntity;

public class BOBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BuggingOut.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<BOSignBlockEntity>> SIGN = REGISTER.register("sign", () -> BlockEntityType.Builder.of(BOSignBlockEntity::new, 
			BOBlocks.ROTTEN_SIGN.get(), BOBlocks.ROTTEN_WALL_SIGN.get()
			).build(null));

}
