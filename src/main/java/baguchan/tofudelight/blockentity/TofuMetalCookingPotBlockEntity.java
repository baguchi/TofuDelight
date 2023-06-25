package baguchan.tofudelight.blockentity;

import baguchan.tofudelight.menu.TofuMetalCookingPotMenu;
import baguchan.tofudelight.register.ModBlockEntities;
import baguchan.tofudelight.register.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

public class TofuMetalCookingPotBlockEntity extends CookingPotBlockEntity {
    public TofuMetalCookingPotBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static ItemStack getMealFromItem(ItemStack cookingPotStack) {
        if (!cookingPotStack.is((Item) ModBlocks.TOFU_METAL_COOKING_POT.get().asItem())) {
            return ItemStack.EMPTY;
        } else {
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

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory player, Player entity) {
        return new TofuMetalCookingPotMenu(id, player, this, this.cookingPotData);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.TOFU_METAL_COOKING_POT.get();
    }
}
