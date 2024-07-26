package baguchan.tofudelight.client;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.register.ModBlockEntities;
import baguchan.tofudelight.register.ModMenus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import vectorwing.farmersdelight.client.gui.CookingPotScreen;

@EventBusSubscriber(modid = TofuDelight.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegistrar {
    @SubscribeEvent
    public static void registerBlockEntityRenders(RegisterMenuScreensEvent event) {
        event.register(ModMenus.TOFU_METAL_COOKING_POT.get(), CookingPotScreen::new);
    }
}
