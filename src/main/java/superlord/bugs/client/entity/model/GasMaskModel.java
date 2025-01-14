package superlord.bugs.client.entity.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

@SuppressWarnings("rawtypes")
public class GasMaskModel extends HumanoidModel {

	public GasMaskModel(ModelPart root) {
		super(root);
	}

	@SuppressWarnings("unused")

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition =  HumanoidModel.createMesh(deformation, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.getChild("head");
        
		PartDefinition part1 = head.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition part2 = part1.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -4.0F));

		PartDefinition part3 = part1.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(18, 16).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition part4 = part1.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, -4.0F, 0.0F, -0.4363F, -0.0873F));

		PartDefinition part6 = part4.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(-3.7F, 0.0F, 0.0F));

		PartDefinition part41 = part1.addOrReplaceChild("part41", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -2.0F, -4.0F, 0.0F, 0.4363F, 0.0873F));

		PartDefinition part61 = part41.addOrReplaceChild("part61", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(4.3F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	
}
