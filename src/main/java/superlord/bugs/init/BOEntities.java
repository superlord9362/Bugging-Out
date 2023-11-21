package superlord.bugs.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.BOBoat;
import superlord.bugs.common.entity.Glowworm;
import superlord.bugs.common.entity.TNTree;
import superlord.bugs.common.entity.TermiteKamikaze;
import superlord.bugs.common.entity.TermiteNymph;
import superlord.bugs.common.entity.TermiteSoldier;
import superlord.bugs.common.entity.TermiteWorker;
import superlord.bugs.common.entity.item.TermiteAcid;

public class BOEntities {
	
	public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BuggingOut.MOD_ID);

	public static final RegistryObject<EntityType<TermiteWorker>> TERMITE_WORKER = REGISTER.register("termite_worker", () -> EntityType.Builder.<TermiteWorker>of(TermiteWorker::new, MobCategory.CREATURE).sized(0.75F, 0.75F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_worker").toString()));
	public static final RegistryObject<EntityType<TermiteSoldier>> TERMITE_SOLDIER = REGISTER.register("termite_soldier", () -> EntityType.Builder.<TermiteSoldier>of(TermiteSoldier::new, MobCategory.CREATURE).sized(1F, 1F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_soldier").toString()));
	public static final RegistryObject<EntityType<TermiteKamikaze>> TERMITE_KAMIKAZE = REGISTER.register("termite_kamikaze", () -> EntityType.Builder.<TermiteKamikaze>of(TermiteKamikaze::new, MobCategory.CREATURE).sized(1F, 1F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_kamikaze").toString()));
	public static final RegistryObject<EntityType<TermiteNymph>> TERMITE_NYMPH = REGISTER.register("termite_nymph", () -> EntityType.Builder.<TermiteNymph>of(TermiteNymph::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_nymph").toString()));
	public static final RegistryObject<EntityType<Glowworm>> GLOWWORM = REGISTER.register("glowworm", () -> EntityType.Builder.<Glowworm>of(Glowworm::new, MobCategory.CREATURE).sized(1F, 1F).build(new ResourceLocation(BuggingOut.MOD_ID, "glowworm").toString()));

	public static final RegistryObject<EntityType<TermiteAcid>> TERMITE_ACID = REGISTER.register("termite_acid", () -> EntityType.Builder.<TermiteAcid>of(TermiteAcid::new, MobCategory.MISC).sized(0.25F, 0.25F).build(new ResourceLocation(BuggingOut.MOD_ID, "termite_acid").toString()));
	public static final RegistryObject<EntityType<TNTree>> TNTREE = REGISTER.register("tntree", () -> EntityType.Builder.<TNTree>of(TNTree::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10).build(new ResourceLocation(BuggingOut.MOD_ID, "tntree").toString()));
	
	public static final RegistryObject<EntityType<BOBoat>> BOAT = REGISTER.register("boat", () -> EntityType.Builder.<BOBoat>of(BOBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build(new ResourceLocation(BuggingOut.MOD_ID, "boat").toString()));
	
}
