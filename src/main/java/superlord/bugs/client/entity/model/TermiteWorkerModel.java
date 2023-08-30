package superlord.bugs.client.entity.model;
// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


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
import superlord.bugs.common.entity.TermiteWorker;

public class TermiteWorkerModel extends EntityModel<TermiteWorker> {
	private final ModelPart Thorax;
	private final ModelPart Head;
	private final ModelPart Leg_l_1;
	private final ModelPart Leg_l_2;
	private final ModelPart Leg_l_3;
	private final ModelPart Leg_r_1;
	private final ModelPart Leg_r_2;
	private final ModelPart Leg_r_3;
	private final ModelPart Abdomen;
	private final ModelPart antenna_r;
	private final ModelPart antenna_l;
	private final ModelPart mandible_r;
	private final ModelPart mandible_l;
	private final ModelPart lip_b;
	private final ModelPart lip_t;

	public TermiteWorkerModel(ModelPart root) {
		this.Thorax = root.getChild("Thorax");
		this.Head = Thorax.getChild("Head");
		this.Leg_l_1 = Thorax.getChild("Leg_l_1");
		this.Leg_l_2 = Thorax.getChild("Leg_l_2");
		this.Leg_l_3 = Thorax.getChild("Leg_l_3");
		this.Leg_r_1 = Thorax.getChild("Leg_r_1");
		this.Leg_r_2 = Thorax.getChild("Leg_r_2");
		this.Leg_r_3 = Thorax.getChild("Leg_r_3");
		this.Abdomen = Thorax.getChild("Abdomen");
		this.antenna_l = Head.getChild("antenna_l");
		this.antenna_r = Head.getChild("antenna_r");
		this.mandible_l = Head.getChild("mandible_l");
		this.mandible_r = Head.getChild("mandible_r");
		this.lip_b = Head.getChild("lip_b");
		this.lip_t = Head.getChild("lip_t");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thorax = partdefinition.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -4.0F));

		PartDefinition Abdomen = Thorax.addOrReplaceChild("Abdomen", CubeListBuilder.create().texOffs(22, 0).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.2269F, 0.0F, 0.0F));

		PartDefinition Abdomen_b = Abdomen.addOrReplaceChild("Abdomen_b", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition Head = Thorax.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(28, 20).addBox(-4.0F, -3.0F, -9.0F, 8.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition lip_b = Head.addOrReplaceChild("lip_b", CubeListBuilder.create().texOffs(13, 15).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -9.0F, -0.0782F, 0.0F, 0.0F));

		PartDefinition lip_t = Head.addOrReplaceChild("lip_t", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.1564F, 0.0F, 0.0F));

		PartDefinition mandible_r = Head.addOrReplaceChild("mandible_r", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, -9.0F, 0.4538F, -0.0873F, -0.3491F));

		PartDefinition mandible_l = Head.addOrReplaceChild("mandible_l", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -9.0F, 0.6283F, -0.0873F, 0.3491F));

		PartDefinition antenna_r = Head.addOrReplaceChild("antenna_r", CubeListBuilder.create().texOffs(46, 28).mirror().addBox(0.0F, -5.0F, -8.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -2.0F, -9.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition antenna_l = Head.addOrReplaceChild("antenna_l", CubeListBuilder.create().texOffs(46, 28).mirror().addBox(0.0F, -5.0F, -8.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -2.0F, -9.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Leg_l_1 = Thorax.addOrReplaceChild("Leg_l_1", CubeListBuilder.create().texOffs(1, 36).mirror().addBox(-10.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, 0.0F, -0.43F, 0.0F));

		PartDefinition Leg_l_2 = Thorax.addOrReplaceChild("Leg_l_2", CubeListBuilder.create().texOffs(1, 36).mirror().addBox(-10.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 6.0F, 0.0F, 0.3128F, 0.0F));

		PartDefinition Leg_l_3 = Thorax.addOrReplaceChild("Leg_l_3", CubeListBuilder.create().texOffs(1, 36).mirror().addBox(-10.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 4.0F));

		PartDefinition Leg_r_1 = Thorax.addOrReplaceChild("Leg_r_1", CubeListBuilder.create().texOffs(1, 36).addBox(0.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, 0.0F, 0.7037F, 0.0F));

		PartDefinition Leg_r_2 = Thorax.addOrReplaceChild("Leg_r_2", CubeListBuilder.create().texOffs(1, 36).addBox(0.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 4.0F));

		PartDefinition Leg_r_3 = Thorax.addOrReplaceChild("Leg_r_3", CubeListBuilder.create().texOffs(1, 36).addBox(0.0F, -1.5F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 6.0F, 0.0F, -0.391F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(TermiteWorker entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Leg_l_3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_r_3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15f) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_l_2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 5) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_r_2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 15) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_l_1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.5F * limbSwingAmount));
		this.Leg_r_1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		if (entity.getTarget() != null || entity.getLastHurtByMob() != null) {
			this.Abdomen.xRot = -0.1F * Mth.sin(0.025F * ageInTicks) + 0.5F;
		} else {
			this.Abdomen.xRot = -0.1F * Mth.sin(0.025F * ageInTicks) + 0.25F + (Mth.cos(1.0F + limbSwing * walkSpeed * 0.15F) * walkDegree * 0.1F * limbSwingAmount);
		}
		this.antenna_r.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.antenna_l.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
		if (entity.areMandiblesMoving()) {
			this.mandible_r.yRot = -Math.abs(-0.5F * Mth.sin(0.15F * ageInTicks));
			this.mandible_l.yRot = Math.abs(0.5F * Mth.sin(0.15F * ageInTicks + 8));
			this.lip_b.xRot = Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0.2F;
			this.lip_t.xRot = -Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0F;
		} else {
			this.mandible_r.yRot = -0.1F;
			this.mandible_l.yRot = 0.1F;
			this.lip_b.xRot =  -0.2F;
			this.lip_t.xRot = 0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thorax.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}