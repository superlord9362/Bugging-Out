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
import superlord.bugs.common.entity.Springtail;

public class SpringtailModel extends EntityModel<Springtail> {
	private final ModelPart Butt;
	private final ModelPart Head;
	private final ModelPart Antena_l;
	private final ModelPart Antena_r;
	private final ModelPart furcula;
	private final ModelPart furcula1;
	private final ModelPart mandible;
	private final ModelPart mandible1;
	private float jumpRotation;

	public SpringtailModel(ModelPart root) {
		this.Butt = root.getChild("Butt");
		this.Head = Butt.getChild("Head");
		this.Antena_l = Head.getChild("Antena_l");
		this.Antena_r = Head.getChild("Antena_r");
		this.furcula = Butt.getChild("furcula");
		this.furcula1 = Butt.getChild("furcula1");
		this.mandible = Head.getChild("mandible");
		this.mandible1 = Head.getChild("mandible1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Butt = partdefinition.addOrReplaceChild("Butt", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition Head = Butt.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Antena_l = Head.addOrReplaceChild("Antena_l", CubeListBuilder.create().texOffs(8, 5).mirror().addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Antena_r = Head.addOrReplaceChild("Antena_r", CubeListBuilder.create().texOffs(8, 5).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition mandible = Head.addOrReplaceChild("mandible", CubeListBuilder.create().texOffs(14, -1).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, -2.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition mandible1 = Head.addOrReplaceChild("mandible1", CubeListBuilder.create().texOffs(14, -1).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 2.0F, -2.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition legg_mid_l = Butt.addOrReplaceChild("legg_mid_l", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 1.0F));

		PartDefinition legg_front_r = Butt.addOrReplaceChild("legg_front_r", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition legg_mid_r = Butt.addOrReplaceChild("legg_mid_r", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 1.0F));

		PartDefinition legg_front_l = Butt.addOrReplaceChild("legg_front_l", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.6283F, 0.0F));

		PartDefinition legg_back_l = Butt.addOrReplaceChild("legg_back_l", CubeListBuilder.create().texOffs(4, 11).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition legg_back_r = Butt.addOrReplaceChild("legg_back_r", CubeListBuilder.create().texOffs(4, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, 0.0F, 0.6283F, 0.0F));

		PartDefinition furcula = Butt.addOrReplaceChild("furcula", CubeListBuilder.create().texOffs(-3, 0).addBox(-1.2F, 0.0F, 0.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -2.7925F, 0.0F, 0.0F));

		PartDefinition furcula1 = Butt.addOrReplaceChild("furcula1", CubeListBuilder.create().texOffs(-3, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -2.7925F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Springtail entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks - (float)entity.tickCount;
		this.Antena_r.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.Antena_l.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
		this.jumpRotation = Mth.sin(entity.getJumpCompletion(f) * (float)Math.PI);
		this.furcula.xRot = (this.jumpRotation * 50.0F - 2.7925F) * ((float)Math.PI / 180F) - 2.7925F;
		this.furcula1.xRot = (this.jumpRotation * 50.0F - 2.7925F) * ((float)Math.PI / 180F) - 2.7925F;
		if (entity.areMandiblesMoving()) {
			this.mandible.zRot = -Math.abs(-0.5F * Mth.sin(0.15F * ageInTicks));
			this.mandible1.zRot = Math.abs(0.5F * Mth.sin(0.15F * ageInTicks + 8));
		} else {
			this.mandible.zRot = -0.8727F;
			this.mandible1.zRot = 0.8727F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Butt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}