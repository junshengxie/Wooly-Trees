package com.mrbysco.woolytrees.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class WoolySaplingBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Supplier<Tree> tree;

    public WoolySaplingBlock(Supplier<Tree> treeIn, Block.Properties properties) {
        super(properties);
        this.tree = treeIn;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9 && rand.nextInt(7) == 0) {
            this.placeTree(worldIn, pos, state, rand);
        }

    }

    public void placeTree(ServerWorld p_226942_1_, BlockPos p_226942_2_, BlockState p_226942_3_, Random p_226942_4_) {
        if (p_226942_3_.getValue(STAGE) == 0) {
            p_226942_1_.setBlock(p_226942_2_, p_226942_3_.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(p_226942_1_, p_226942_4_, p_226942_2_)) return;
            this.tree.get().growTree(p_226942_1_, p_226942_1_.getChunkSource().getGenerator(), p_226942_2_, p_226942_3_, p_226942_4_);
        }

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)worldIn.random.nextFloat() < 0.45D;
    }

    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.placeTree(worldIn, pos, state, rand);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
