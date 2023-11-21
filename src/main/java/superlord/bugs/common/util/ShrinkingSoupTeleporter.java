package superlord.bugs.common.util;

import java.util.function.Function;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.ITeleporter;

public class ShrinkingSoupTeleporter implements ITeleporter {
	
	
	public ShrinkingSoupTeleporter(ServerLevel world) {
	}
	
	@Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
		return repositionEntity.apply(false);
    }

}
