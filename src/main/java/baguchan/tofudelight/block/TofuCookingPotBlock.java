package baguchan.tofudelight.block;

import baguchan.tofudelight.register.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

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
}
