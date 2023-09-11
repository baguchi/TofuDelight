package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuItemTier;
import baguchan.tofudelight.TofuDelight;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TofuDelight.MODID);
    public static final RegistryObject<Item> TOFU_METAL_KNIFE = ITEMS.register("tofu_metal_knife", () -> new KnifeItem(TofuItemTier.METAL, 0.5F, -1.75F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TOFU_DIAMOND_KNIFE = ITEMS.register("tofu_diamond_knife", () -> new KnifeItem(TofuItemTier.TOFUDIAMOND, 0.5F, -2.0F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COOKED_SOYMEAT = ITEMS.register("cooked_soymeat", () -> new Item(new Item.Properties().stacksTo(1).food(Foods.COOKED_PORKCHOP)));

}
