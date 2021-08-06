package com.mrbysco.woolytrees.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class WoolyLeavesBlock extends LeavesBlock {

    public WoolyLeavesBlock(Properties properties) {
        super(properties.noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isViewBlocking(Blocks::never));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);
    }

    private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

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
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true)), context.getLevel(), context.getClickedPos());
    }
}
