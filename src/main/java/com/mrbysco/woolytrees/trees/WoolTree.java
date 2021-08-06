package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class WoolTree extends AbstractTreeGrower {

    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return largeHive ? WoolyFeatureConfig.FANCY_WOOL_BEES_005 : WoolyFeatureConfig.FANCY_WOOL;
        } else {
            return largeHive ? WoolyFeatureConfig.WOOL_BEES_005 : WoolyFeatureConfig.WOOL;
        }
    }
}
