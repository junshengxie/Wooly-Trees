package com.mrbysco.woolytrees.trees;

import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;

public class JebTree extends AbstractTreeGrower {

	@Nullable
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
		return null;
	}

	@Override
	public boolean growTree(ServerLevel serverLevel, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, RandomSource randomSource) {
		boolean largeHive = this.hasFlowers(serverLevel, pos);
		Holder<ConfiguredFeature<?, ?>> holder = randomSource.nextInt(10) == 0 ?
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getFancyJebWithBeehives() : WoolyFeatureConfig.getFancyJebConfiguration()) :
				WoolyFeatureConfig.createJebHolder(largeHive ? WoolyFeatureConfig.getJebWithBeehives() : WoolyFeatureConfig.getJebConfiguration());
		if (holder != null) {
			var event = EventHooks.blockGrowFeature(serverLevel, randomSource, pos, holder);
			holder = event.getFeature();
			if (event.getResult() == Event.Result.DENY) return false;
			if (holder == null) {
				return false;
			} else {
				ConfiguredFeature<?, ?> configuredfeature = holder.value();
				BlockState blockstate = serverLevel.getFluidState(pos).createLegacyBlock();
				serverLevel.setBlock(pos, blockstate, 4);
				if (configuredfeature.place(serverLevel, chunkGenerator, randomSource, pos)) {
					if (serverLevel.getBlockState(pos) == blockstate) {
						serverLevel.sendBlockUpdated(pos, state, blockstate, 2);
					}

					return true;
				} else {
					serverLevel.setBlock(pos, state, 4);
					return false;
				}
			}
		}
		return false;
	}

	private boolean hasFlowers(LevelAccessor levelAccessor, BlockPos pos) {
		for (BlockPos blockpos : BlockPos.MutableBlockPos.betweenClosed(pos.below().north(2).west(2), pos.above().south(2).east(2))) {
			if (levelAccessor.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
				return true;
			}
		}

		return false;
	}
}
