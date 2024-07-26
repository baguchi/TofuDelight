package baguchan.tofudelight.client;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.item.SoymilkBottleItem;
import baguchan.tofudelight.TofuDelight;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import vectorwing.farmersdelight.common.Configuration;

import java.util.Iterator;
import java.util.List;

@EventBusSubscriber(
        modid = TofuDelight.MODID,
        value = Dist.CLIENT
)
public class TooltipEvents {

    @SubscribeEvent
    public static void addTooltipToTofuSoups(ItemTooltipEvent event) {
        Item food = event.getItemStack().getItem();
        FoodProperties foodProperties = event.getItemStack().getFoodProperties(event.getEntity());
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (BuiltInRegistries.ITEM.getKey(food).getNamespace() == TofuCraftReload.MODID) {
                if (food instanceof SoymilkBottleItem soymilkBottleItem) {
                    List<Component> tooltip = event.getToolTip();

                    MutableComponent effectText;

                    effectText = Component.translatable(soymilkBottleItem.getEffect().value().getDescriptionId()).withStyle(soymilkBottleItem.getEffect().value().getCategory().getTooltipFormatting());
                    tooltip.add(effectText);

                    Component component2 = Component.translatable("item.tofudelight.soymilk.when_drank_more").withStyle(ChatFormatting.DARK_PURPLE);

                    Component effectText2 = Component.translatable(soymilkBottleItem.getSecondEffect().value().getDescriptionId()).withStyle(soymilkBottleItem.getSecondEffect().value().getCategory().getTooltipFormatting());
                    tooltip.add(component2);
                    tooltip.add(effectText2);
                }

                if (foodProperties != null) {
                    List<Component> tooltip = event.getToolTip();

                    MobEffectInstance effect;
                    MutableComponent effectText;
                    for (Iterator<FoodProperties.PossibleEffect> var4 = foodProperties.effects().iterator(); var4.hasNext(); tooltip.add(effectText.withStyle(effect.getEffect().value().getCategory().getTooltipFormatting()))) {
                        FoodProperties.PossibleEffect pair = var4.next();
                        effect = pair.effect();
                        effectText = Component.translatable(effect.getDescriptionId());
                        if (effect.getDuration() > 20) {
                            effectText = Component.translatable("potion.withDuration", effectText, MobEffectUtil.formatDuration(effect, 1.0F, event.getContext().tickRate()));
                        }
                    }
                }
            }
        }
    }
}
