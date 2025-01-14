package superlord.bugs.client.entity.render;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import superlord.bugs.BuggingOut;
import superlord.bugs.common.entity.BOBoat;
import superlord.bugs.common.entity.BOBoat.BOBoatTypes;

public class BOBoatRenderer extends BoatRenderer {
	private final Map<BOBoatTypes, Pair<ResourceLocation, ListModel<Boat>>> modBoatResources;

    public BOBoatRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoot) {
        super(renderContext, isChestBoot);
        modBoatResources = Stream.of(BOBoatTypes.values()).collect(ImmutableMap.toImmutableMap((boatType) -> {
            return boatType;
        }, (boatType) -> {
            return Pair.of(
                new ResourceLocation(BuggingOut.MOD_ID, "textures/entity/boat/" + boatType.getName() + ".png"),
                new BoatModel(renderContext.bakeLayer(
                    new ModelLayerLocation(
                        new ResourceLocation("boat/oak"),
                        "main"
                    )
                ))
            );
        }));
    }

    public BOBoatRenderer(EntityRendererProvider.Context renderContext) {
        this(renderContext, false);
    }
    
    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        BOBoat moddedBoat = (BOBoat) boat;
        return modBoatResources.get(moddedBoat.getBOBoatType());
    }

	
}