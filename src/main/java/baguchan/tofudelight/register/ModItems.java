package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuItemTier;
import baguchan.tofudelight.TofuDelight;
import baguchan.tofudelight.item.TofuKnifeItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, TofuDelight.MODID);
    public static final DeferredHolder<Item, Item> TOFU_METAL_KNIFE = ITEMS.register("tofu_metal_knife", () -> new TofuKnifeItem(TofuItemTier.METAL, knifeItem(TofuItemTier.METAL).stacksTo(1)));
    public static final DeferredHolder<Item, Item> TOFU_DIAMOND_KNIFE = ITEMS.register("tofu_diamond_knife", () -> new TofuKnifeItem(TofuItemTier.TOFUDIAMOND, knifeItem(TofuItemTier.TOFUDIAMOND).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COOKED_SOYMEAT = ITEMS.register("cooked_soymeat", () -> new Item(new Item.Properties().stacksTo(1).food(Foods.COOKED_PORKCHOP)));
    public static final DeferredHolder<Item, Item> GRATIN_PUMPKIN = ITEMS.register("soy_gratin_pumpkin",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.GRATIN_PUMPKIN)));
    public static final DeferredHolder<Item, Item> SOY_CHOCOLATE_CAKE = ITEMS.register("soy_chocolate_cake",
            () -> new ConsumableItem(bowlFoodItem(ModFoods.SOY_CHOCOLATE_CAKE)));
    public static final DeferredHolder<Item, Item> TTT_BURGER_SLICE = ITEMS.register("ttt_burger_slice",
            () -> new ConsumableItem(new Item.Properties().food(ModFoods.TTT_BURGER)));


    public static Item.Properties knifeItem(Tier tier) {
        return new Item.Properties().attributes(KnifeItem.createAttributes(tier, 0.5F, -2.0F));
    }
}
