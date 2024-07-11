package baguchan.tofudelight.register;

import baguchan.tofucraft.registry.TofuEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoods {
    public static final FoodProperties GRATIN_PUMPKIN = stew(6).effect(new MobEffectInstance(ModEffects.COMFORT.get(), 3600), 1F).build();
    public static final FoodProperties SOY_CHOCOLATE_CAKE = stew(4).effect(new MobEffectInstance(TofuEffects.SOY_HEALTHY.get(), 600), 1F).build();

    public static final FoodProperties TTT_BURGER = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.65F).build();

    private static FoodProperties.Builder stew(int p_150384_) {
        return (new FoodProperties.Builder()).nutrition(p_150384_).saturationMod(0.6F);
    }
}
