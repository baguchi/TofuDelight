package baguchan.tofudelight.register;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.menu.TofuMetalCookingPotMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, TofuDelight.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<TofuMetalCookingPotMenu>> TOFU_METAL_COOKING_POT = MENU_TYPES.register("tofu_metal_cooking_pot", () -> {
        return IMenuTypeExtension.create(TofuMetalCookingPotMenu::new);
    });
}