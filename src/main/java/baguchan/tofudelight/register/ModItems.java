package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuItemTier;
import baguchan.tofudelight.TofuDelight;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TofuDelight.MODID);
    public static final RegistryObject<Item> TOFU_METAL_KNIFE = ITEMS.register("tofu_metal_knife", () -> new KnifeItem(TofuItemTier.METAL, 0.5F, -1.75F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TOFU_DIAMOND_KNIFE = ITEMS.register("tofu_diamond_knife", () -> new KnifeItem(TofuItemTier.TOFUDIAMOND, 0.5F, -2.0F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COOKED_SOYMEAT = ITEMS.register("cooked_soymeat", () -> new Item(new Item.Properties().stacksTo(1).food(Foods.COOKED_PORKCHOP)));
    public static final RegistryObject<Item> GRATIN_PUMPKIN = ITEMS.register("soy_gratin_pumpkin",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.GRATIN_PUMPKIN)));
    public static final RegistryObject<Item> SOY_CHOCOLATE_CAKE = ITEMS.register("soy_chocolate_cake",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.SOY_CHOCOLATE_CAKE)));
    public static final RegistryObject<Item> TTT_BURGER_SLICE = ITEMS.register("ttt_burger_slice",
            () -> new ConsumableItem(new Item.Properties().food(ModFoods.TTT_BURGER)));
}
