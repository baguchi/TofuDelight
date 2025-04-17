package baguchan.tofudelight.client;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.register.ModBlockEntities;
import baguchan.tofudelight.register.ModBlocks;
import baguchan.tofudelight.register.ModMenus;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import vectorwing.farmersdelight.client.gui.CookingPotScreen;

@EventBusSubscriber(modid = TofuDelight.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegistrar {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.TOFU_METAL_COOKING_POT.get(), CookingPotScreen::new);
    }

    @SubscribeEvent
    public static void registerBlockEntityRenderEvents(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SOY_CHICKEN.get(), SoyChickenRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModel(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SoyChickenModel.LAYER_LOCATION, SoyChickenModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityModel(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new SoyChickenCustomRender();
            }
        }, ModBlocks.SOY_CHICKEN.get());
    }
}
