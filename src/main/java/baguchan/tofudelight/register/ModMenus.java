package baguchan.tofudelight.register;

import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.menu.TofuMetalCookingPotMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TofuDelight.MODID);
    public static final RegistryObject<MenuType<TofuMetalCookingPotMenu>> TOFU_METAL_COOKING_POT = MENU_TYPES.register("tofu_metal_cooking_pot", () -> {
        return IForgeMenuType.create(TofuMetalCookingPotMenu::new);
    });
}