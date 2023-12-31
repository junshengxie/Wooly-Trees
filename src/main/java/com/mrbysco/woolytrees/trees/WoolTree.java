package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class WoolTree {
	public static final TreeGrower WOOL = new TreeGrower(
			"woolytrees:wool",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(WoolyFeatureConfig.WOOL),
			Optional.of(WoolyFeatureConfig.FANCY_WOOL),
			Optional.of(WoolyFeatureConfig.WOOL_BEES_005),
			Optional.of(WoolyFeatureConfig.FANCY_WOOL_BEES_005)
	);
}
