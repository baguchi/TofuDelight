package baguchan.tofudelight.register;

import baguchan.tofudelight.TofuDelight;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.stream.Stream;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TofuDelight.MODID);


    public static final Holder<CreativeModeTab> TOFU_DELIGHT = CREATIVE_MODE_TABS.register("tofu_delight", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + TofuDelight.MODID + ".main_tab"))
            .icon(() -> ModItems.GRATIN_PUMPKIN.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        ModItems.COOKED_SOYMEAT,
                        ModItems.GRATIN_PUMPKIN,
                        ModItems.SOY_CHOCOLATE_CAKE,
                        ModItems.TTT_BURGER_SLICE,
                        ModItems.TOFU_METAL_KNIFE,
                        ModItems.TOFU_DIAMOND_KNIFE
                ).map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());
                output.acceptAll(Stream.of(
                        ModBlocks.GRATIN_PUMPKIN_BLOCK,
                        ModBlocks.TTT_BURGER,
                        ModBlocks.SOY_CHOCOLATE_CAKE_BLOCK,
                        ModBlocks.TOFU_METAL_COOKING_POT
                ).map(sup -> {
                    return sup.get().asItem().getDefaultInstance();
                }).toList());
            }).build());
}