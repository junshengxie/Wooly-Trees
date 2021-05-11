package com.mrbysco.woolytrees.registry;

import com.google.common.collect.ImmutableList;
import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.trees.features.FancyWoolPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
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

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_WOOL = register("fancy_wool", WoolyRegistry.WOOLY_TREE.get().withConfiguration(
            (new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(WHITE_WOOL_LOG),
                    new SimpleBlockStateProvider(GREEN_WOOL_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_WOOL_BEES_005 = register("fancy_wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get().withConfiguration(
            FANCY_WOOL.getConfig().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT))));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WOOL = register("wool", WoolyRegistry.WOOLY_TREE.get().withConfiguration(
            (new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(WHITE_WOOL_LOG),
                    new SimpleBlockStateProvider(GREEN_WOOL_LEAVES),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));


    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WOOL_BEES_005 = register("fancy_wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get().withConfiguration(
            WOOL.getConfig().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT))));

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

    public static BaseTreeFeatureConfig getFancyJeb() {
        return getFancyJebWithBeehives().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT));
    }

    public static BaseTreeFeatureConfig getFancyJebWithBeehives() {
        return (new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(getRandomLog()),
                new SimpleBlockStateProvider(getRandomleaves()),
                new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                new FancyWoolPlacer(3, 11, 0),
                new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build();
    }

    public static BaseTreeFeatureConfig getJebWithBeehives() {
        return getJeb().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT));
    }
    public static BaseTreeFeatureConfig getJeb() {
        return (new BaseTreeFeatureConfig.Builder
                (new SimpleBlockStateProvider(getRandomLog()),
                        new SimpleBlockStateProvider(getRandomleaves()),
                        new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                        new StraightTrunkPlacer(4, 2, 0),
                        new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, key), feature);
    }
}
