package com.mrbysco.woolytrees.handler;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.SaplingGrowTreeEvent;

public class TreeHandler {
	@SubscribeEvent
	public void onGrowTree(SaplingGrowTreeEvent event) {
		if (event.getLevel().getBlockState(event.getPos()).is(WoolyRegistry.JEB_SAPLING.get())) {
			// Make the jeb sapling use the WOOL TreeGrower and replace them with the jeb equivalent
			if (event.getFeature().is(WoolyFeatureConfig.WOOL)) {
				event.setFeature(WoolyFeatureConfig.createJebHolder(WoolyFeatureConfig.getJebConfiguration()));
			} else if (event.getFeature().is(WoolyFeatureConfig.FANCY_WOOL)) {
				event.setFeature(WoolyFeatureConfig.createJebHolder(WoolyFeatureConfig.getFancyJebConfiguration()));
			} else if (event.getFeature().is(WoolyFeatureConfig.WOOL_BEES_005)) {
				event.setFeature(WoolyFeatureConfig.createJebHolder(WoolyFeatureConfig.getJebWithBeehives()));
			} else if (event.getFeature().is(WoolyFeatureConfig.FANCY_WOOL_BEES_005)) {
				event.setFeature(WoolyFeatureConfig.createJebHolder(WoolyFeatureConfig.getFancyJebWithBeehives()));
			}
		}
	}
}
