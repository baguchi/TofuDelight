package baguchan.tofudelight;

import baguchan.tofudelight.register.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TofuDelight.MODID)
public class TofuDelight
{
    public static final String MODID = "tofudelight";

    public TofuDelight(ModContainer modContainer, IEventBus modEventBus) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::clientSetup);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModMenus.MENU_TYPES.register(modEventBus);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
}
