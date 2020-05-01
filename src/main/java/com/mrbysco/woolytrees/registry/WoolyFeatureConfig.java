package com.mrbysco.woolytrees.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import java.util.Random;

public class WoolyFeatureConfig {
    public static final Random rand = new Random();

    private static final BlockState WHITE_WOOL_LOG = Blocks.WHITE_WOOL.getDefaultState();
    private static final BlockState GREEN_WOOL_LEAVES = WoolyRegistry.GREEN_WOOL_LEAVES.get().getDefaultState();

    public static final TreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new BlobFoliagePlacer(0, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable) WoolyRegistry.WOOLY_SAPLING.get()).build();
    public static final TreeFeatureConfig FANCY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();

    public static final TreeFeatureConfig WOOLY_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();
    public static final TreeFeatureConfig WOOLY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();

    public static BlockState getRandomleaves() {
        BlockState randomState = GREEN_WOOL_LEAVES;
        if(!WoolyTags.WOOLY_LEAVES.getEntries().isEmpty()) {
            randomState = WoolyTags.WOOLY_LEAVES.getRandomElement(rand).getDefaultState();
        }
        return randomState;
    }

    public static BlockState getRandomLog() {
        BlockState randomState = WHITE_WOOL_LOG;
        if(!WoolyTags.WOOLY_LOGS.getEntries().isEmpty()) {
            randomState = WoolyTags.WOOLY_LOGS.getRandomElement(rand).getDefaultState();
        }
        return randomState;
    }

    public static TreeFeatureConfig getFancyJebWithBeehives() {
        return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new BlobFoliagePlacer(0, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable) WoolyRegistry.WOOLY_SAPLING.get()).build();
    }
    public static TreeFeatureConfig getFancyJeb() {
        return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();
    }
    public static TreeFeatureConfig getJebWithBeehives() {
        return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();
    }
    public static TreeFeatureConfig getJeb() {
        return (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)WoolyRegistry.WOOLY_SAPLING.get()).build();
    }
}
