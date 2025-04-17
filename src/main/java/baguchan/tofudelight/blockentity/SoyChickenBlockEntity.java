package baguchan.tofudelight.blockentity;

import baguchan.tofudelight.register.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SoyChickenBlockEntity extends BlockEntity {
    public SoyChickenBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SOY_CHICKEN.get(), pPos, pBlockState);
    }
}
