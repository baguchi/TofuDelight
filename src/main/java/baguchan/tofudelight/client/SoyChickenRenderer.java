package baguchan.tofudelight.client;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.block.SoyChickenBlock;
import baguchan.tofudelight.blockentity.SoyChickenBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class SoyChickenRenderer implements BlockEntityRenderer<SoyChickenBlockEntity> {

    public static final ResourceLocation TEXTURES = ResourceLocation.fromNamespaceAndPath(TofuDelight.MODID, "textures/block/soy_chicken.png");
    private final SoyChickenModel soyChickenModel;

    public SoyChickenRenderer(BlockEntityRendererProvider.Context context) {
        this.soyChickenModel = new SoyChickenModel(context.bakeLayer(SoyChickenModel.LAYER_LOCATION));
    }

    @Override
    public void render(SoyChickenBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        float f = ((Direction) pBlockEntity.getBlockState().getValue(SoyChickenBlock.FACING)).getOpposite().toYRot();
        int i = pBlockEntity.getBlockState().getValue(SoyChickenBlock.SERVINGS);

        soyChickenModel.lava_leg_l.visible = i >= 3;
        soyChickenModel.lava_leg_r.visible = i >= 2;
        pPoseStack.pushPose();
        pPoseStack.scale(-1.0F, -1.0F, 1.0F);
        pPoseStack.translate(0.0F, -1.501F, 0.0F);
        pPoseStack.translate(-0.5F, 0.0F, 0.5F);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
        VertexConsumer var9 = pBufferSource.getBuffer(RenderType.entitySolid(TEXTURES));
        this.soyChickenModel.renderToBuffer(pPoseStack, var9, pPackedLight, pPackedOverlay);
        pPoseStack.popPose();
    }

}
