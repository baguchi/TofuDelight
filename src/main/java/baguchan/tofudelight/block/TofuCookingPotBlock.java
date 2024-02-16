package baguchan.tofudelight.block;

import baguchan.tofudelight.register.ModBlockEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @javax.annotation.Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flagIn) {
        CompoundTag nbt = stack.getTagElement("BlockEntityTag");
        ItemStack mealStack = getMealFromItem(stack);
        MutableComponent textServingsOf;
        if (!mealStack.isEmpty()) {
            textServingsOf = mealStack.getCount() == 1 ? TextUtils.getTranslation("tooltip.cooking_pot.single_serving", new Object[0]) : TextUtils.getTranslation("tooltip.cooking_pot.many_servings", new Object[]{mealStack.getCount()});
            tooltip.add(textServingsOf.withStyle(ChatFormatting.GRAY));
            MutableComponent textMealName = mealStack.getHoverName().copy();
            tooltip.add(textMealName.withStyle(mealStack.getRarity().color));
        } else {
            textServingsOf = TextUtils.getTranslation("tooltip.cooking_pot.empty", new Object[0]);
            tooltip.add(textServingsOf.withStyle(ChatFormatting.GRAY));
        }

    }

    public static ItemStack getMealFromItem(ItemStack cookingPotStack) {
        CompoundTag compound = cookingPotStack.getTagElement("BlockEntityTag");
        if (compound != null) {
            CompoundTag inventoryTag = compound.getCompound("Inventory");
            if (inventoryTag.contains("Items", 9)) {

                ItemStackHandler handler = new ItemStackHandler();
                handler.deserializeNBT(inventoryTag);
                return handler.getStackInSlot(6);
            }
        }

        return ItemStack.EMPTY;
    }
}
