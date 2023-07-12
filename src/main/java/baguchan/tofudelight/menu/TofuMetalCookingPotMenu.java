package baguchan.tofudelight.menu;

import baguchan.tofudelight.register.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotMenu;

import java.util.Objects;

public class TofuMetalCookingPotMenu extends CookingPotMenu {
    private final ContainerLevelAccess canInteractWithCallable;

    public TofuMetalCookingPotMenu(int windowId, Inventory playerInventory, CookingPotBlockEntity tileEntity, ContainerData cookingPotDataIn) {
        super(windowId, playerInventory, tileEntity, cookingPotDataIn);
        this.canInteractWithCallable = ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos());

    }

    public TofuMetalCookingPotMenu(int windowId, Inventory playerInventory, FriendlyByteBuf data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data), new SimpleContainerData(4));
    }

    private static CookingPotBlockEntity getTileEntity(Inventory playerInventory, FriendlyByteBuf data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        BlockEntity tileAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof CookingPotBlockEntity) {
            return (CookingPotBlockEntity) tileAtPos;
        } else {
            throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
        }
    }

    public boolean stillValid(Player playerIn) {
        return stillValid(this.canInteractWithCallable, playerIn, (Block) baguchan.tofudelight.register.ModBlocks.TOFU_METAL_COOKING_POT.get());
    }

    @Override
    public MenuType<?> getType() {
        return ModMenus.TOFU_METAL_COOKING_POT.get();
    }
}
