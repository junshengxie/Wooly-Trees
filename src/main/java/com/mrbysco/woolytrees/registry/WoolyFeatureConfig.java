package com.mrbysco.woolytrees.registry;

import com.google.common.collect.ImmutableList;
import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.trees.features.FancyWoolPlacer;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.Random;

public class WoolyFeatureConfig {
    public static final Random rand = new Random();

    private static final BlockState WHITE_WOOL_LOG = Blocks.WHITE_WOOL.defaultBlockState();
    private static final BlockState GREEN_WOOL_LEAVES = WoolyRegistry.GREEN_WOOL_LEAVES.get().defaultBlockState();
    private static final BlockState WOOLY_SAPLING = WoolyRegistry.WOOLY_SAPLING.get().defaultBlockState();
    private static final BlockState JEB_SAPLING = WoolyRegistry.JEB_SAPLING.get().defaultBlockState();

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_WOOL = register("fancy_wool", WoolyRegistry.WOOLY_TREE.get().configured(
            (new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(WHITE_WOOL_LOG),
                    new FancyTrunkPlacer(3, 11, 0),
                    new SimpleStateProvider(GREEN_WOOL_LEAVES),
                    new SimpleStateProvider(WOOLY_SAPLING),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                    new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));

    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_WOOL_BEES_005 = register("fancy_wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get().configured(
            FANCY_WOOL.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

    public static final ConfiguredFeature<TreeConfiguration, ?> WOOL = register("wool", WoolyRegistry.WOOLY_TREE.get().configured(
            (new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(WHITE_WOOL_LOG),
                    new StraightTrunkPlacer(4, 2, 0),
                    new SimpleStateProvider(GREEN_WOOL_LEAVES),
                    new SimpleStateProvider(WOOLY_SAPLING),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));


    public static final ConfiguredFeature<TreeConfiguration, ?> WOOL_BEES_005 = register("fancy_wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get().configured(
            WOOL.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

    public static BlockState getRandomleaves() {
        BlockState randomState = GREEN_WOOL_LEAVES;
        if(!WoolyTags.WOOLY_LEAVES.getValues().isEmpty()) {
            randomState = WoolyTags.WOOLY_LEAVES.getRandomElement(rand).defaultBlockState();
        }
        return randomState;
    }

    public static BlockState getRandomLog() {
        BlockState randomState = WHITE_WOOL_LOG;
        if(!WoolyTags.WOOLY_LOGS.getValues().isEmpty()) {
            randomState = WoolyTags.WOOLY_LOGS.getRandomElement(rand).defaultBlockState();
        }
        return randomState;
    }

    public static TreeConfiguration getFancyJeb() {
        return getFancyJebWithBeehives().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005));
    }

    public static TreeConfiguration getFancyJebWithBeehives() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(getRandomLog()),
                new FancyWoolPlacer(3, 11, 0),
                new SimpleStateProvider(getRandomleaves()),
                new SimpleStateProvider(JEB_SAPLING),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build();
    }

    public static TreeConfiguration getJebWithBeehives() {
        return getJeb().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005));
    }
    public static TreeConfiguration getJeb() {
        return (new TreeConfiguration.TreeConfigurationBuilder
                (new SimpleStateProvider(getRandomLog()),
                        new StraightTrunkPlacer(4, 2, 0),
                        new SimpleStateProvider(getRandomleaves()),
                        new SimpleStateProvider(JEB_SAPLING),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
    }

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, key), feature);
    }
}
