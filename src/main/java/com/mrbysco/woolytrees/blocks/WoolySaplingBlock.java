package com.mrbysco.woolytrees.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class WoolySaplingBlock extends BushBlock implements BonemealableBlock {
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final Supplier<AbstractTreeGrower> tree;

	public WoolySaplingBlock(Supplier<AbstractTreeGrower> treeIn, Block.Properties properties) {
		super(properties);
		this.tree = treeIn;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9 && rand.nextInt(7) == 0) {
			this.placeTree(worldIn, pos, state, rand);
		}

	}

	public void placeTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
		if (state.getValue(STAGE) == 0) {
			level.setBlock(pos, state.cycle(STAGE), 4);
		} else {
			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(level, random, pos))
				return;
			this.tree.get().growTree(level, level.getChunkSource().getGenerator(), pos, state, random);
		}

	}

	/**
	 * Whether this IGrowable can grow
	 */
	public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean isBonemealSuccess(Level worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		return (double) worldIn.random.nextFloat() < 0.45D;
	}

	public void performBonemeal(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		this.placeTree(worldIn, pos, state, rand);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
}
