package com.mrbysco.woolytrees.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.Random;

public class WoolyFeatureConfig {
    public static final Random rand = new Random();

    private static final BlockState WHITE_WOOL_LOG = Blocks.WHITE_WOOL.getDefaultState();
    private static final BlockState GREEN_WOOL_LEAVES = WoolyRegistry.GREEN_WOOL_LEAVES.get().getDefaultState();

    public static final BaseTreeFeatureConfig FANCY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new FancyFoliagePlacer(2, 0, 4, 0, 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
    public static final BaseTreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(DefaultBiomeFeatures.MANY_BEEHIVES));

    public static final BaseTreeFeatureConfig WOOLY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_WOOL_LOG), new SimpleBlockStateProvider(GREEN_WOOL_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    public static final BaseTreeFeatureConfig WOOLY_TREE_WITH_MORE_BEEHIVES_CONFIG = WOOLY_TREE_CONFIG.func_236685_a_(ImmutableList.of(DefaultBiomeFeatures.MANY_BEEHIVES));


    public static BlockState getRandomleaves() {
        BlockState randomState = GREEN_WOOL_LEAVES;
        if(!WoolyTags.WOOLY_LEAVES.getAllElements().isEmpty()) {
            randomState = WoolyTags.WOOLY_LEAVES.getRandomElement(rand).getDefaultState();
        }
        return randomState;
    }

    public static BlockState getRandomLog() {
        BlockState randomState = WHITE_WOOL_LOG;
        if(!WoolyTags.WOOLY_LOGS.getAllElements().isEmpty()) {
            randomState = WoolyTags.WOOLY_LOGS.getRandomElement(rand).getDefaultState();
        }
        return randomState;
    }

    public static BaseTreeFeatureConfig getFancyJebWithBeehives() {
        return (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new FancyFoliagePlacer(2, 0, 4, 0, 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
    }
    public static BaseTreeFeatureConfig getFancyJeb() {
        return getFancyJebWithBeehives().func_236685_a_(ImmutableList.of(DefaultBiomeFeatures.MANY_BEEHIVES));
    }
    public static BaseTreeFeatureConfig getJebWithBeehives() {
        return getJeb().func_236685_a_(ImmutableList.of(DefaultBiomeFeatures.MANY_BEEHIVES));
    }
    public static BaseTreeFeatureConfig getJeb() {
        return (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(getRandomLog()), new SimpleBlockStateProvider(getRandomleaves()), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    }
}
