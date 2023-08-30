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
import superlord.bugs.common.entity.TermiteNymph;

public class TermiteNymphModel extends EntityModel<TermiteNymph> {
	private final ModelPart body;
	private final ModelPart abdomen;
	private final ModelPart leg_1_l;
	private final ModelPart leg_2_l;
	private final ModelPart leg_3_l;
	private final ModelPart leg_1_r;
	private final ModelPart leg_2_r;
	private final ModelPart leg_3_r;
	private final ModelPart head;
	private final ModelPart antena;
	private final ModelPart antena_1;
	private final ModelPart mandible_r;
	private final ModelPart mandible_l;
	private final ModelPart jaw_b;
	private final ModelPart jaw_t;

	public TermiteNymphModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("head");
		this.leg_1_l = body.getChild("leg_1_l");
		this.leg_2_l = body.getChild("leg_2_l");
		this.leg_3_l = body.getChild("leg_3_l");
		this.leg_1_r = body.getChild("leg_1_r");
		this.leg_2_r = body.getChild("leg_2_r");
		this.leg_3_r = body.getChild("leg_3_r");
		this.abdomen = body.getChild("abdomen");
		this.antena = head.getChild("antena");
		this.antena_1 = head.getChild("antena_1");
		this.mandible_l = head.getChild("mandible_l");
		this.mandible_r = head.getChild("mandible_r");
		this.jaw_b = head.getChild("jaw_b");
		this.jaw_t = head.getChild("jaw_t");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition leg_2_l = body.addOrReplaceChild("leg_2_l", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 0.5F));

		PartDefinition leg_1_l = body.addOrReplaceChild("leg_1_l", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition leg_3_r = body.addOrReplaceChild("leg_3_r", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 2.0F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition leg_3_l = body.addOrReplaceChild("leg_3_l", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition leg_2_r = body.addOrReplaceChild("leg_2_r", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 2.0F, 0.5F));

		PartDefinition leg_1_r = body.addOrReplaceChild("leg_1_r", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 2.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition abdomen = body.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.2443F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 17).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.5F, 0.1222F, 0.0F, 0.0F));

		PartDefinition antena = head.addOrReplaceChild("antena", CubeListBuilder.create().texOffs(13, -5).mirror().addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -2.0F, -6.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition antena_1 = head.addOrReplaceChild("antena_1", CubeListBuilder.create().texOffs(13, -5).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, -6.0F, -0.0782F, -0.3491F, 0.0F));

		PartDefinition jaw_b = head.addOrReplaceChild("jaw_b", CubeListBuilder.create().texOffs(1, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -5.5F, 0.2737F, 0.0F, 0.0F));

		PartDefinition jaw_t = head.addOrReplaceChild("jaw_t", CubeListBuilder.create().texOffs(1, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.5F, -0.2737F, 0.0F, 0.0F));

		PartDefinition mandible_r = head.addOrReplaceChild("mandible_r", CubeListBuilder.create().texOffs(1, 28).mirror().addBox(-1.5F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -0.5F, -5.5F, 0.2618F, 0.3491F, 0.0F));

		PartDefinition mandible_l = head.addOrReplaceChild("mandible_l", CubeListBuilder.create().texOffs(1, 28).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, -5.5F, 0.2618F, -0.3491F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(TermiteNymph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.leg_3_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.leg_3_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15f) * walkDegree * 0.5F * limbSwingAmount));
		this.leg_2_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 5) * walkDegree * 0.5F * limbSwingAmount));
		this.leg_2_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 15) * walkDegree * 0.5F * limbSwingAmount));
		this.leg_1_l.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.5F * limbSwingAmount));
		this.leg_1_r.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.15F + 10) * walkDegree * 0.5F * limbSwingAmount));
		if (entity.getTarget() != null || entity.getLastHurtByMob() != null) {
			this.abdomen.xRot = -0.1F * Mth.sin(0.025F * ageInTicks) + 0.5F;
		} else {
			this.abdomen.xRot = -0.1F * Mth.sin(0.025F * ageInTicks) + 0.25F + (Mth.cos(1.0F + limbSwing * walkSpeed * 0.15F) * walkDegree * 0.1F * limbSwingAmount);
		}
		this.antena.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.antena_1.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
		if (entity.areMandiblesMoving()) {
			this.mandible_r.yRot = -Math.abs(-0.5F * Mth.sin(0.15F * ageInTicks));
			this.mandible_l.yRot = Math.abs(0.5F * Mth.sin(0.15F * ageInTicks + 8));
			this.jaw_b.xRot = Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0.2F;
			this.jaw_t.xRot = -Math.abs(0.25F * Mth.sin(0.025F * ageInTicks)) - 0F;
		} else {
			this.mandible_r.yRot = -0.1F;
			this.mandible_l.yRot = 0.1F;
			this.jaw_b.xRot =  -0.2F;
			this.jaw_t.xRot = 0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}