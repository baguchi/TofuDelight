package baguchan.tofudelight.client;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import baguchan.tofudelight.TofuDelight;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SoyChickenModel extends Model {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TofuDelight.MODID, "soy_chicken"), "main");
    public final ModelPart LavaChicken;
    public final ModelPart lava_leg_r;
    public final ModelPart lava_leg_l;

    public SoyChickenModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.LavaChicken = root.getChild("LavaChicken");
        this.lava_leg_r = this.LavaChicken.getChild("lava_leg_r");
        this.lava_leg_l = this.LavaChicken.getChild("lava_leg_l");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition LavaChicken = partdefinition.addOrReplaceChild("LavaChicken", CubeListBuilder.create().texOffs(0, 2).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 1.0F));

        PartDefinition lava_leg_r = LavaChicken.addOrReplaceChild("lava_leg_r", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 19).addBox(-2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 3.0F));

        PartDefinition lava_leg_l = LavaChicken.addOrReplaceChild("lava_leg_l", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 19).addBox(0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -6.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        LavaChicken.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);

    }
}