package com.gmail.bmdetra.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

@SuppressWarnings("ALL")
public class Empty_Tome extends Block {

public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    //<editor-fold desc="Voxel Shapes">
    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(5, 0, 3, 8, 16, 13),
            Block.makeCuboidShape(8, 0, 3, 11, 16, 13),
            Block.makeCuboidShape(11, 0, 3, 11.600000000000001, 16, 14),
            Block.makeCuboidShape(4.399999999999999, 0, 3, 5, 16, 14),
            Block.makeCuboidShape(4.4, 0, 2, 11.6, 16, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(3, 0, 5, 13, 16, 8),
            Block.makeCuboidShape(3, 0, 8, 13, 16, 11),
            Block.makeCuboidShape(2, 0, 11, 13, 16, 11.600000000000001),
            Block.makeCuboidShape(2, 0, 4.399999999999999, 13, 16, 5),
            Block.makeCuboidShape(13, 0, 4.4, 14, 16, 11.6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(8, 0, 3, 11, 16, 13),
            Block.makeCuboidShape(5, 0, 3, 8, 16, 13),
            Block.makeCuboidShape(4.399999999999999, 0, 2, 5, 16, 13),
            Block.makeCuboidShape(11, 0, 2, 11.600000000000001, 16, 13),
            Block.makeCuboidShape(4.4, 0, 13, 11.6, 16, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(3, 0, 8, 13, 16, 11),
            Block.makeCuboidShape(3, 0, 5, 13, 16, 8),
            Block.makeCuboidShape(3, 0, 4.399999999999999, 14, 16, 5),
            Block.makeCuboidShape(3, 0, 11, 14, 16, 11.600000000000001),
            Block.makeCuboidShape(2, 0, 4.4, 3, 16, 11.6)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    //</editor-fold>

    public Empty_Tome(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;

        }
    }
}
