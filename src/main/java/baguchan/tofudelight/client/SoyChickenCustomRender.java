package baguchan.tofudelight.client;

import baguchan.tofudelight.blockentity.SoyChickenBlockEntity;
import baguchan.tofudelight.register.ModBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class SoyChickenCustomRender extends BlockEntityWithoutLevelRenderer {
    public SoyChickenCustomRender() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    public void renderByItem(ItemStack pStack, ItemDisplayContext pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pOverlay) {
        Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(new SoyChickenBlockEntity(BlockPos.ZERO, ModBlocks.SOY_CHICKEN.get().defaultBlockState()), pPoseStack, pBuffer, pPackedLight, pOverlay);
    }
}
