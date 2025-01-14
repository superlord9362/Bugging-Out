package superlord.bugs.common.item;

import javax.annotation.Nullable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.bugs.BuggingOut;

public class GasMaskItem extends ArmorItem {

	public GasMaskItem(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
		super(p_40386_, p_266831_, p_40388_);
	}
	
	@Override
	public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
		consumer.accept((net.minecraftforge.client.extensions.common.IClientItemExtensions) BuggingOut.PROXY.getArmorRenderProperties());
	}
	
	@Override
	@Nullable
	@OnlyIn(Dist.CLIENT) 
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return "bugging_out:textures/models/armor/gas_mask.png";
	}

}
