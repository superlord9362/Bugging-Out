package superlord.bugs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.Glowworm;
import superlord.bugs.common.entity.TermiteNymph;
import superlord.bugs.common.entity.TermiteSoldier;
import superlord.bugs.common.entity.TermiteWorker;

public class BOEntities {
	
	public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BuggingOut.MOD_ID);

	public static final RegistryObject<EntityType<TermiteWorker>> TERMITE_WORKER = REGISTER.register("termite_worker", () -> EntityType.Builder.<TermiteWorker>of(TermiteWorker::new, MobCategory.CREATURE).sized(0.75F, 0.75F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_worker").toString()));
	public static final RegistryObject<EntityType<TermiteSoldier>> TERMITE_SOLDIER = REGISTER.register("termite_soldier", () -> EntityType.Builder.<TermiteSoldier>of(TermiteSoldier::new, MobCategory.CREATURE).sized(1F, 1F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_soldier").toString()));
	public static final RegistryObject<EntityType<TermiteNymph>> TERMITE_NYMPH = REGISTER.register("termite_nymph", () -> EntityType.Builder.<TermiteNymph>of(TermiteNymph::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_nymph").toString()));
	public static final RegistryObject<EntityType<Glowworm>> GLOWWORM = REGISTER.register("glowworm", () -> EntityType.Builder.<Glowworm>of(Glowworm::new, MobCategory.CREATURE).sized(1F, 1F).build(new ResourceLocation(BuggingOut.MOD_ID, "glowworm").toString()));

}
