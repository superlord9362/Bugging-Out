package superlord.bugs.client.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import superlord.bugs.client.ClientEvents;
import superlord.bugs.client.entity.model.GasMaskModel;
import superlord.bugs.init.BOItems;

public class GasMaskRenderProperties implements IClientItemExtensions {
	
	private static boolean init;
	
	public static GasMaskModel GAS_MASK_MODEL;
	
	public static void initializeModels() {
		init = true;
		GAS_MASK_MODEL = new GasMaskModel(Minecraft.getInstance().getEntityModels().bakeLayer(ClientEvents.GAS_MASK));
	}
	
	@Override
	public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
    	if(!init){
            initializeModels();
        }
    	if(itemStack.getItem() == BOItems.GAS_MASK.get()){
            return GAS_MASK_MODEL;
        }
    	return _default;
    }
}
