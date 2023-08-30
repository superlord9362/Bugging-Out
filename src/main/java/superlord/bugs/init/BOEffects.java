package superlord.bugs.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.effect.TermitesVengeanceEffect;

public class BOEffects {

	public static final DeferredRegister<MobEffect> REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BuggingOut.MOD_ID);

	public static final RegistryObject<MobEffect> TERMITES_VENGEANCE = REGISTER.register("termites_vengeance", () -> new TermitesVengeanceEffect(MobEffectCategory.HARMFUL, 0x995D38));

}
