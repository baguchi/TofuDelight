package baguchan.tofudelight.block;

import baguchan.tofudelight.blockentity.SoyChickenBlockEntity;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Map;
import java.util.function.Supplier;

public class SoyChickenBlock extends FeastBlock implements EntityBlock {
    protected static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 7, 14);

    public static final VoxelShape SHAPE_NORTHSOUTH = Block.box(4, 0, 3, 12, 7, 13);
    public static final VoxelShape SHAPE_EASTWEST = Block.box(3.0, 0.0, 4.0, 13.0, 7.0, 12.0);
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(
            ImmutableMap.of(Direction.NORTH, SHAPE_NORTHSOUTH, Direction.SOUTH, SHAPE_NORTHSOUTH, Direction.EAST, SHAPE_EASTWEST, Direction.WEST, SHAPE_EASTWEST)
    );

    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 3);

    public SoyChickenBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(this.getServingsProperty(), this.getMaxServings()));
    }


    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        VoxelShape voxelshape = AABBS.get(pState.getValue(FACING));
        return voxelshape == null ? SHAPE : voxelshape;
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    public int getMaxServings() {
        return 3;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SoyChickenBlockEntity(pPos, pState);
    }
}