package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuCreativeModeTabs;
import baguchan.tofudelight.TofuDelight;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TofuDelight.MODID)
public class ModCreativeTabs {
    @SubscribeEvent
    public static void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == TofuCreativeModeTabs.TOFU_BUILDING_BLOCKS.getKey()) {
            event.accept(ModBlocks.TOFU_METAL_COOKING_POT.get());
        }
    }
}