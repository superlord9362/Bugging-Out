package superlord.bugs.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import superlord.bugs.common.entity.BarkBeetle;

public class BarkBeetleModel extends EntityModel<BarkBeetle> {
	private final ModelPart Abdomen;
	private final ModelPart Thorax;
	private final ModelPart Head;
	private final ModelPart RAntenne;
	private final ModelPart LAntenne;
	private final ModelPart Leg_1_l;
	private final ModelPart Leg_2_l;
	private final ModelPart Leg_3_l;
	private final ModelPart Leg_1_r;
	private final ModelPart Leg_2_r;
	private final ModelPart Leg_3_r;

	public BarkBeetleModel(ModelPart root) {
		this.Abdomen = root.getChild("Abdomen");
		this.Thorax = this.Abdomen.getChild("Thorax");
		this.Head = this.Thorax.getChild("Head");
		this.RAntenne = this.Head.getChild("RAntenne");
		this.LAntenne = this.Head.getChild("LAntenne");
		this.Leg_1_l = this.Abdomen.getChild("Leg_1_l");
		this.Leg_2_l = this.Abdomen.getChild("Leg_2_l");
		this.Leg_3_l = this.Abdomen.getChild("Leg_3_l");
		this.Leg_1_r = this.Abdomen.getChild("Leg_1_r");
		this.Leg_2_r = this.Abdomen.getChild("Leg_2_r");
		this.Leg_3_r = this.Abdomen.getChild("Leg_3_r");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Abdomen = partdefinition.addOrReplaceChild("Abdomen", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -2.0F));

		PartDefinition Thorax = Abdomen.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, -0.5F, -4.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Thorax.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.6F, -2.1F));

		PartDefinition RAntenne = Head.addOrReplaceChild("RAntenne", CubeListBuilder.create().texOffs(3, 7).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.0F, -2.0F, 0.1745F, 0.0F, -0.3491F));

		PartDefinition LAntenne = Head.addOrReplaceChild("LAntenne", CubeListBuilder.create().texOffs(-2, 7).addBox(0.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -2.0F, 0.1745F, 0.0F, 0.3491F));

		PartDefinition Leg_1_l = Abdomen.addOrReplaceChild("Leg_1_l", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 0.0F, 0.0F, -0.9774F, 0.0F));

		PartDefinition Leg_2_l = Abdomen.addOrReplaceChild("Leg_2_l", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 5.0F, 2.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Leg_3_l = Abdomen.addOrReplaceChild("Leg_3_l", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 5.0F, 4.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition Leg_1_r = Abdomen.addOrReplaceChild("Leg_1_r", CubeListBuilder.create().texOffs(9, 16).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 4.0F, 0.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition Leg_2_r = Abdomen.addOrReplaceChild("Leg_2_r", CubeListBuilder.create().texOffs(9, 21).addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 2.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition Leg_3_r = Abdomen.addOrReplaceChild("Leg_3_r", CubeListBuilder.create().texOffs(9, 25).addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 5.0F, 4.0F, 0.0F, -0.8727F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(BarkBeetle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Leg_3_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_3_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15f) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_2_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 5) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_2_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 15) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_1_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_1_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.Abdomen.xRot = (Mth.cos(1.0F + limbSwing * walkSpeed * 0.15F) * walkDegree * 0.1F * limbSwingAmount);
		this.RAntenne.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.LAntenne.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Abdomen.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}