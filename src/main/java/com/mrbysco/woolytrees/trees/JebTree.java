package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class JebTree extends AbstractTreeGrower {

	@Nullable
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
		return random.nextInt(10) == 0 ?
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getFancyJebWithBeehives() : WoolyFeatureConfig.getFancyJebConfiguration()) :
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getJebWithBeehives() : WoolyFeatureConfig.getJebConfiguration());
	}
}
