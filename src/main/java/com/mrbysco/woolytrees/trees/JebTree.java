package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public class JebTree extends AbstractTreeGrower {

    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random randomIn, boolean hasBeehives) {
        return randomIn.nextInt(10) == 0 ?
                WoolyRegistry.JEB_TREE.get().configured(hasBeehives ? WoolyFeatureConfig.getFancyJebWithBeehives() : WoolyFeatureConfig.getFancyJeb()) :
                WoolyRegistry.JEB_TREE.get().configured(hasBeehives ? WoolyFeatureConfig.getJebWithBeehives() : WoolyFeatureConfig.getJeb());
    }
}
