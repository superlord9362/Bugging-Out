package superlord.bugs.common.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import superlord.bugs.common.util.ShrinkingSoupTeleporter;
import superlord.bugs.init.BODimensions;

public class ShrinkingSoupItem extends Item {

	public ShrinkingSoupItem(Item.Properties properties) {
		super(properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		ItemStack itemstack = super.finishUsingItem(stack, world, entity);
		if (entity.level() instanceof ServerLevel) {
			ServerLevel serverWorld = (ServerLevel)entity.level();
			MinecraftServer minecraftServer = serverWorld.getServer();
			ResourceKey<Level> registryKey = BODimensions.BUGS;
			ServerLevel serverWorld1 = minecraftServer.getLevel(registryKey);
			if (entity.level().dimension() != BODimensions.BUGS) {
				if (serverWorld1 != null && !entity.isPassenger()) {
					entity.setPortalCooldown();
					entity.changeDimension(serverWorld1, new ShrinkingSoupTeleporter(serverWorld1));
				}
			}
		}
		return entity instanceof Player && ((Player)entity).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
	}

}
