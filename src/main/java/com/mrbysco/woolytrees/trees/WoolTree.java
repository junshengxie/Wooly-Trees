package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatures;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class WoolTree extends Tree {

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean hasBeehives) {
        return randomIn.nextInt(10) == 0 ?
                WoolyRegistry.FANCY_TREE.get().withConfiguration(hasBeehives ? WoolyFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG : WoolyFeatures.FANCY_TREE_CONFIG) :
                Feature.NORMAL_TREE.withConfiguration(hasBeehives ? WoolyFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG : WoolyFeatures.OAK_TREE_CONFIG);
    }
}
