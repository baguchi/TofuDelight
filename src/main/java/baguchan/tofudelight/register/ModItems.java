package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuItemTier;
import baguchan.tofudelight.TofuDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TofuDelight.MODID);

    public static final RegistryObject<Item> TOFU_METAL_KNIFE = ITEMS.register("tofu_metal_knife", () -> new KnifeItem(TofuItemTier.METAL, 1.0F, 3.75F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TOFU_DIAMOND_KNIFE = ITEMS.register("tofu_diamond_knife", () -> new KnifeItem(TofuItemTier.TOFUDIAMOND, 1.0F, 3.5F, new Item.Properties().stacksTo(1)));

}
