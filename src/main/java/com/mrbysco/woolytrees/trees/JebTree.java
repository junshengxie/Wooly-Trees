package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public class JebTree extends AbstractTreeGrower {

	@Nullable
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
		return random.nextInt(10) == 0 ?
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getFancyJebWithBeehives() : WoolyFeatureConfig.getFancyJebConfiguration()) :
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getJebWithBeehives() : WoolyFeatureConfig.getJebConfiguration());
	}
}
