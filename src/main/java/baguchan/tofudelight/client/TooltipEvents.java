package baguchan.tofudelight.client;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.item.SoymilkBottleItem;
import baguchan.tofudelight.TofuDelight;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.Configuration;

import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(
        modid = TofuDelight.MODID,
        value = Dist.CLIENT
)
public class TooltipEvents {

    @SubscribeEvent
    public static void addTooltipToTofuSoups(ItemTooltipEvent event) {
        Item food = event.getItemStack().getItem();
        FoodProperties foodProperties = food.getFoodProperties();
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (ForgeRegistries.ITEMS.getKey(food).getNamespace() == TofuCraftReload.MODID) {
                if (food instanceof SoymilkBottleItem soymilkBottleItem) {
                    List<Component> tooltip = event.getToolTip();

                    MutableComponent effectText;

                    effectText = Component.translatable(soymilkBottleItem.getEffect().getDescriptionId()).withStyle(soymilkBottleItem.getEffect().getCategory().getTooltipFormatting());
                    tooltip.add(effectText);

                    Component component2 = Component.translatable("item.tofudelight.soymilk.when_drank_more").withStyle(ChatFormatting.DARK_PURPLE);

                    Component effectText2 = Component.translatable(soymilkBottleItem.getSecondEffect().getDescriptionId()).withStyle(soymilkBottleItem.getSecondEffect().getCategory().getTooltipFormatting());
                    tooltip.add(component2);
                    tooltip.add(effectText2);
                }

                if (foodProperties != null) {
                    List<Component> tooltip = event.getToolTip();

                    MobEffectInstance effect;
                    MutableComponent effectText;
                    for (Iterator var4 = foodProperties.getEffects().iterator(); var4.hasNext(); tooltip.add(effectText.withStyle(effect.getEffect().getCategory().getTooltipFormatting()))) {
                        Pair<MobEffectInstance, Float> pair = (Pair) var4.next();
                        effect = (MobEffectInstance) pair.getFirst();
                        effectText = Component.translatable(effect.getDescriptionId());
                        if (effect.getDuration() > 20) {
                            effectText = Component.translatable("potion.withDuration", new Object[]{effectText, MobEffectUtil.formatDuration(effect, 1.0F)});
                        }
                    }
                }
            }
        }
    }
}
