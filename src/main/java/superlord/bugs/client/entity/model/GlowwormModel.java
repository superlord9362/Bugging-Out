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
import superlord.bugs.common.entity.Glowworm;

public class GlowwormModel extends EntityModel<Glowworm> {

	private final ModelPart segment_5;
	private final ModelPart segment_4;
	private final ModelPart segment_3;
	private final ModelPart segment_2;
	private final ModelPart segment_1;
	private final ModelPart Head_shield;
	private final ModelPart Head;
	private final ModelPart mandible_r;
	private final ModelPart mandible_l;
	private final ModelPart teeth_t;
	private final ModelPart teeth_b;
	private final ModelPart Leg_1_l;
	private final ModelPart Leg_1_r;
	private final ModelPart Leg_2_l;
	private final ModelPart Leg_2_r;
	private final ModelPart Leg_3_l;
	private final ModelPart Leg_3_r;
	
	public GlowwormModel(ModelPart root) {
		this.segment_5 = root.getChild("segment_5");
		this.segment_4 = segment_5.getChild("segment_4");
		this.segment_3 = segment_4.getChild("segment_3");
		this.segment_2 = segment_3.getChild("segment_2");
		this.segment_1 = segment_2.getChild("segment_1");
		this.Head_shield = segment_1.getChild("Head_shield");
		this.Leg_1_l = Head_shield.getChild("Leg_1_l");
		this.Leg_1_r = Head_shield.getChild("Leg_1_r");
		this.Leg_2_l = segment_1.getChild("Leg_2_l");
		this.Leg_2_r = segment_1.getChild("Leg_2_r");
		this.Leg_3_l = segment_1.getChild("Leg_3_l");
		this.Leg_3_r = segment_1.getChild("Leg_3_r");
		this.Head = Head_shield.getChild("Head");
		this.mandible_l = Head.getChild("mandible_l");
		this.mandible_r = Head.getChild("mandible_r");
		this.teeth_t = Head.getChild("teeth_t");
		this.teeth_b = Head.getChild("teeth_b");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition segment_5 = partdefinition.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 2.0F));

		PartDefinition segment_4 = segment_5.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition segment_3 = segment_4.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(0, 31).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition segment_2 = segment_3.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(0, 49).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition segment_1 = segment_2.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(0, 67).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition Head_shield = segment_1.addOrReplaceChild("Head_shield", CubeListBuilder.create().texOffs(22, 85).addBox(-5.0F, -4.0F, -11.0F, 10.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition Head = Head_shield.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 104).addBox(-5.0F, -2.0F, -15.0F, 10.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -12.0F));

		PartDefinition teeth_t = Head.addOrReplaceChild("teeth_t", CubeListBuilder.create().texOffs(0, 85).addBox(-3.5F, 0.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -15.0F));

		PartDefinition teeth_b = Head.addOrReplaceChild("teeth_b", CubeListBuilder.create().texOffs(0, 90).mirror().addBox(-3.5F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -15.0F));

		PartDefinition mandible_r = Head.addOrReplaceChild("mandible_r", CubeListBuilder.create().texOffs(0, 95).addBox(-3.0F, -1.0F, -5.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, -15.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition mandible_l = Head.addOrReplaceChild("mandible_l", CubeListBuilder.create().texOffs(0, 95).mirror().addBox(0.0F, -1.0F, -5.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.0F, -15.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition mouthinside = Head.addOrReplaceChild("mouthinside", CubeListBuilder.create().texOffs(46, 113).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition Leg_1_l = Head_shield.addOrReplaceChild("Leg_1_l", CubeListBuilder.create().texOffs(49, 78).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 3.0F, -3.0F));

		PartDefinition Leg_1_r = Head_shield.addOrReplaceChild("Leg_1_r", CubeListBuilder.create().texOffs(49, 78).addBox(0.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -3.0F));

		PartDefinition Leg_3_l = segment_1.addOrReplaceChild("Leg_3_l", CubeListBuilder.create().texOffs(49, 78).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 3.0F, -3.0F));

		PartDefinition Leg_2_l = segment_1.addOrReplaceChild("Leg_2_l", CubeListBuilder.create().texOffs(49, 78).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 3.0F, -8.0F));

		PartDefinition Leg_3_r = segment_1.addOrReplaceChild("Leg_3_r", CubeListBuilder.create().texOffs(49, 78).addBox(0.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -3.0F));

		PartDefinition Leg_2_r = segment_1.addOrReplaceChild("Leg_2_r", CubeListBuilder.create().texOffs(49, 78).addBox(0.0F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -7.0F));

		PartDefinition tail = segment_5.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(35, 0).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 128);
	}

	@Override
	public void setupAnim(Glowworm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.segment_4.xRot = (-(Math.abs(Mth.sin(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * 5F * limbSwingAmount))) + ((headPitch * ((float)Math.PI / 180F)) / 6);
		this.segment_3.xRot = ((Math.abs(Mth.sin(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * 5F * limbSwingAmount))) + ((headPitch * ((float)Math.PI / 180F)) / 5);
		this.segment_2.xRot = ((Math.abs(-Mth.sin(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * 5F * limbSwingAmount))) + ((headPitch * ((float)Math.PI / 180F)) / 4);
		this.segment_1.xRot = (-(Math.abs(-Mth.sin(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * 5F * limbSwingAmount))) + ((headPitch * ((float)Math.PI / 180F)) / 3);
		this.Head_shield.xRot = (headPitch * ((float)Math.PI / 180F)) / 2;
		this.Head.xRot = (headPitch * ((float)Math.PI / 180F));
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head_shield.yRot = (netHeadYaw * ((float)Math.PI / 180F)) / 2;
		this.segment_1.yRot = (netHeadYaw * ((float)Math.PI / 180F)) / 3;
		this.segment_2.yRot = (netHeadYaw * ((float)Math.PI / 180F)) / 4;
		this.segment_3.yRot = (netHeadYaw * ((float)Math.PI / 180F)) / 5;
		this.segment_4.yRot = (netHeadYaw * ((float)Math.PI / 180F)) / 6;
		this.Leg_3_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 1F + 10) * walkDegree * 1F * limbSwingAmount));
		this.Leg_3_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 1f) * walkDegree * 1F * limbSwingAmount));
		this.Leg_2_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 1F + 5) * walkDegree * 1F * limbSwingAmount));
		this.Leg_2_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 1F + 15) * walkDegree * 1F * limbSwingAmount));
		this.Leg_1_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 1F) * walkDegree * 1F * limbSwingAmount));
		this.Leg_1_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 1F + 10) * walkDegree * 1F * limbSwingAmount));
		if (entity.areMandiblesMoving()) {
			this.mandible_r.yRot = -Math.abs(-0.5F * Mth.sin(0.15F * ageInTicks));
			this.mandible_l.yRot = Math.abs(0.5F * Mth.sin(0.15F * ageInTicks + 8));
			this.teeth_b.xRot = Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0.2F;
			this.teeth_t.xRot = -Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0F;
		} else {
			this.mandible_r.yRot = -0.3F;
			this.mandible_l.yRot = 0.3F;
			this.teeth_b.xRot =  -0.2F;
			this.teeth_t.xRot = 0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		segment_5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}