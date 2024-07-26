package baguchan.tofudelight.block;

import baguchan.tofudelight.register.ModBlockEntities;
import baguchan.tofudelight.register.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;
import vectorwing.farmersdelight.common.registry.ModDataComponents;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class TofuCookingPotBlock extends CookingPotBlock {

    public TofuCookingPotBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.TOFU_METAL_COOKING_POT.get().create(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        return level.isClientSide ? createTickerHelper(blockEntity, (BlockEntityType) ModBlockEntities.TOFU_METAL_COOKING_POT.get(), CookingPotBlockEntity::animationTick) : createTickerHelper(blockEntity, (BlockEntityType) ModBlockEntities.TOFU_METAL_COOKING_POT.get(), CookingPotBlockEntity::cookingTick);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        ItemStack mealStack = getMealFromItem(pStack);
        MutableComponent textServingsOf;
        if (!mealStack.isEmpty()) {
            textServingsOf = mealStack.getCount() == 1 ? TextUtils.getTranslation("tooltip.cooking_pot.single_serving") : TextUtils.getTranslation("tooltip.cooking_pot.many_servings", mealStack.getCount());
            pTooltipComponents.add(textServingsOf.withStyle(ChatFormatting.GRAY));
            MutableComponent textMealName = mealStack.getHoverName().copy();
            pTooltipComponents.add(textMealName.withStyle(mealStack.getRarity().color()));
        } else {
            textServingsOf = TextUtils.getTranslation("tooltip.cooking_pot.empty");
            pTooltipComponents.add(textServingsOf.withStyle(ChatFormatting.GRAY));
        }
    }

    public static ItemStack getMealFromItem(ItemStack cookingPotStack) {
        return !cookingPotStack.is(ModBlocks.TOFU_METAL_COOKING_POT.get().asItem()) ? ItemStack.EMPTY : cookingPotStack.getOrDefault(ModDataComponents.MEAL, ItemStackWrapper.EMPTY).getStack();
    }
}
