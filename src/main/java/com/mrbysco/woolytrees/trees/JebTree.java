package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class JebTree extends Tree {

    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean hasBeehives) {
        return randomIn.nextInt(10) == 0 ?
                WoolyRegistry.FANCY_JEB_TREE.get().withConfiguration(hasBeehives ? WoolyFeatureConfig.getFancyJebWithBeehives() : WoolyFeatureConfig.getFancyJeb()) :
                WoolyRegistry.JEB_TREE.get().withConfiguration(hasBeehives ? WoolyFeatureConfig.getJebWithBeehives() : WoolyFeatureConfig.getJeb());
    }
}
