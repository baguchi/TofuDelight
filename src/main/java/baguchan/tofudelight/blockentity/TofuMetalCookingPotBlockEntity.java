package baguchan.tofudelight.blockentity;

import baguchan.tofudelight.menu.TofuMetalCookingPotMenu;
import baguchan.tofudelight.register.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

public class TofuMetalCookingPotBlockEntity extends CookingPotBlockEntity {
    public TofuMetalCookingPotBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory player, Player entity) {
        return new TofuMetalCookingPotMenu(id, player, this, this.cookingPotData);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.TOFU_METAL_COOKING_POT.value();
    }
}
