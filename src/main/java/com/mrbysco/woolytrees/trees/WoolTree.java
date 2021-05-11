package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class WoolTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0) {
            return largeHive ? WoolyFeatureConfig.FANCY_WOOL_BEES_005 : WoolyFeatureConfig.FANCY_WOOL;
        } else {
            return largeHive ? WoolyFeatureConfig.WOOL_BEES_005 : WoolyFeatureConfig.WOOL;
        }
    }
}
