package com.mrbysco.woolytrees.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WoolyLeavesBlock extends LeavesBlock {

    public WoolyLeavesBlock(Properties properties) {
        super(properties.noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isViewBlocking(Blocks::never));
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor worldIn, BlockPos pos) {
        int i = 7;
        BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            blockpos$mutable.setWithOffset(pos, direction);
            i = Math.min(i, getDistance(worldIn.getBlockState(blockpos$mutable)) + 1);
            if (i == 1) {
                break;
            }
        }

        return state.setValue(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistance(BlockState neighbor) {
        if (BlockTags.WOOL.contains(neighbor.getBlock())) {
            return 0;
        } else {
            return neighbor.getBlock() instanceof WoolyLeavesBlock ? neighbor.getValue(DISTANCE) : 7;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true)), context.getLevel(), context.getClickedPos());
    }
}
