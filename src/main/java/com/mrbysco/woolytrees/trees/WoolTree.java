package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class WoolTree extends Tree {

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return randomIn.nextInt(10) == 0 ?
                WoolyRegistry.FANCY_TREE.get().withConfiguration(largeHive ? WoolyFeatureConfig.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG : WoolyFeatureConfig.FANCY_TREE_CONFIG) :
                Feature.field_236291_c_.withConfiguration(largeHive ? WoolyFeatureConfig.WOOLY_TREE_WITH_MORE_BEEHIVES_CONFIG : WoolyFeatureConfig.WOOLY_TREE_CONFIG);
    }
}
