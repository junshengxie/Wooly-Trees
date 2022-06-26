package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class WoolTree extends AbstractTreeGrower {
	@Nullable
	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
		if (random.nextInt(10) == 0) {
			return largeHive ? WoolyFeatureConfig.FANCY_WOOL_BEES_005 : WoolyFeatureConfig.FANCY_WOOL;
		} else {
			return largeHive ? WoolyFeatureConfig.WOOL_BEES_005 : WoolyFeatureConfig.WOOL;
		}
	}
}
