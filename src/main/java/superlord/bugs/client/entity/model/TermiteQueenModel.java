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
import superlord.bugs.common.entity.TermiteQueen;

public class TermiteQueenModel extends EntityModel<TermiteQueen> {
	private final ModelPart Thorax;
	private final ModelPart Abdomen;
	private final ModelPart Abdomen2;
	private final ModelPart Abdomen3;
	private final ModelPart Abdomen4;
	private final ModelPart Abdomen5;
	@SuppressWarnings("unused")
	private final ModelPart Abdomen6;
	private final ModelPart Head;
	private final ModelPart lip_b;
	private final ModelPart lip_t;
	private final ModelPart mandible_r;
	private final ModelPart mandible_l;
	private final ModelPart antenna_r;
	private final ModelPart antenna_l;
	private final ModelPart Leg_l_1;
	private final ModelPart Leg_l_2;
	private final ModelPart Leg_l_3;
	private final ModelPart Leg_r_1;
	private final ModelPart Leg_r_2;
	private final ModelPart Leg_r_3;

	public TermiteQueenModel(ModelPart root) {
		this.Thorax = root.getChild("Thorax");
		this.Abdomen = this.Thorax.getChild("Abdomen");
		this.Abdomen2 = this.Abdomen.getChild("Abdomen2");
		this.Abdomen3 = this.Abdomen2.getChild("Abdomen3");
		this.Abdomen4 = this.Abdomen3.getChild("Abdomen4");
		this.Abdomen5 = this.Abdomen4.getChild("Abdomen5");
		this.Abdomen6 = this.Abdomen5.getChild("Abdomen6");
		this.Head = this.Thorax.getChild("Head");
		this.lip_b = this.Head.getChild("lip_b");
		this.lip_t = this.Head.getChild("lip_t");
		this.mandible_r = this.Head.getChild("mandible_r");
		this.mandible_l = this.Head.getChild("mandible_l");
		this.antenna_r = this.Head.getChild("antenna_r");
		this.antenna_l = this.Head.getChild("antenna_l");
		this.Leg_l_1 = this.Thorax.getChild("Leg_l_1");
		this.Leg_l_2 = this.Thorax.getChild("Leg_l_2");
		this.Leg_l_3 = this.Thorax.getChild("Leg_l_3");
		this.Leg_r_1 = this.Thorax.getChild("Leg_r_1");
		this.Leg_r_2 = this.Thorax.getChild("Leg_r_2");
		this.Leg_r_3 = this.Thorax.getChild("Leg_r_3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thorax = partdefinition.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(86, 81).addBox(-3.5F, -2.0F, -6.0F, 7.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -17.0F));

		PartDefinition Box_r1 = Thorax.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(38, 118).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 1.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Box_r2 = Thorax.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(54, 90).addBox(-4.5F, -1.0F, 0.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, -5.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Abdomen = Thorax.addOrReplaceChild("Abdomen", CubeListBuilder.create().texOffs(66, 25).addBox(-6.0F, -4.25F, 0.0F, 12.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 7.25F));

		PartDefinition Abdomen2 = Abdomen.addOrReplaceChild("Abdomen2", CubeListBuilder.create().texOffs(0, 65).addBox(-7.0F, -2.25F, 0.0F, 14.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 9.0F));

		PartDefinition Abdomen3 = Abdomen2.addOrReplaceChild("Abdomen3", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -1.25F, 0.0F, 20.0F, 15.0F, 18.0F, new CubeDeformation(0.01F)), PartPose.offset(1.0F, -2.0F, 10.0F));

		PartDefinition Abdomen4 = Abdomen3.addOrReplaceChild("Abdomen4", CubeListBuilder.create().texOffs(0, 33).addBox(-10.5F, -1.25F, -1.0F, 19.0F, 15.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 18.0F));

		PartDefinition Abdomen5 = Abdomen4.addOrReplaceChild("Abdomen5", CubeListBuilder.create().texOffs(56, 48).addBox(-10.0F, -0.25F, -2.0F, 18.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1F, 16.0F));

		PartDefinition Abdomen6 = Abdomen5.addOrReplaceChild("Abdomen6", CubeListBuilder.create().texOffs(77, 3).addBox(-7.0F, 1.75F, -3.0F, 14.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -0.1F, 17.0F));

		PartDefinition Head = Thorax.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -1.0F, -11.0F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, -5.75F, 0.2618F, 0.0F, 0.0F));

		PartDefinition eye_r1 = Head.addOrReplaceChild("eye_r1", CubeListBuilder.create().texOffs(2, 100).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 3.0F, -9.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition eye_r2 = Head.addOrReplaceChild("eye_r2", CubeListBuilder.create().texOffs(2, 100).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 3.0F, -9.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition lip_b = Head.addOrReplaceChild("lip_b", CubeListBuilder.create().texOffs(0, 124).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.9F, -11.0F));

		PartDefinition lip_t = Head.addOrReplaceChild("lip_t", CubeListBuilder.create().texOffs(18, 124).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -11.0F));

		PartDefinition mandible_r = Head.addOrReplaceChild("mandible_r", CubeListBuilder.create().texOffs(0, 118).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, -11.0F, 0.0F, 0.0873F, -0.3491F));

		PartDefinition mandible_l = Head.addOrReplaceChild("mandible_l", CubeListBuilder.create().texOffs(2, 112).addBox(-1.0F, 0.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -11.0F, 0.0F, -0.0873F, 0.3491F));

		PartDefinition antenna_r = Head.addOrReplaceChild("antenna_r", CubeListBuilder.create().texOffs(27, 84).addBox(0.0F, -9.0F, -9.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, -11.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition antenna_l = Head.addOrReplaceChild("antenna_l", CubeListBuilder.create().texOffs(27, 84).addBox(0.0F, -9.0F, -9.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, -11.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Leg_l_1 = Thorax.addOrReplaceChild("Leg_l_1", CubeListBuilder.create().texOffs(102, 120).addBox(-13.0F, -0.5F, 0.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.5F, -2.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Leg_l_2 = Thorax.addOrReplaceChild("Leg_l_2", CubeListBuilder.create().texOffs(102, 120).addBox(-13.0F, -0.5F, 0.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.5F, 4.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Leg_l_3 = Thorax.addOrReplaceChild("Leg_l_3", CubeListBuilder.create().texOffs(102, 120).addBox(-13.0F, -0.5F, 0.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.5F, 1.0F));

		PartDefinition Leg_r_1 = Thorax.addOrReplaceChild("Leg_r_1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.5F, -2.25F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Box_r3 = Leg_r_1.addOrReplaceChild("Box_r3", CubeListBuilder.create().texOffs(102, 111).addBox(2.0F, -7.5F, -2.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.0F, 2.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Leg_r_2 = Thorax.addOrReplaceChild("Leg_r_2", CubeListBuilder.create().texOffs(102, 111).addBox(0.0F, -0.5F, 0.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 1.5F, 1.0F));

		PartDefinition Leg_r_3 = Thorax.addOrReplaceChild("Leg_r_3", CubeListBuilder.create().texOffs(102, 111).addBox(0.0F, -0.5F, 0.0F, 13.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.5F, 3.75F, 0.0F, -0.3491F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(TermiteQueen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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