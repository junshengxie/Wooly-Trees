package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.trees.features.FancyWoolPlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class WoolyFeatureConfig {
	public static void initialize() {
	}

	public static final TrunkPlacerType<FancyTrunkPlacer> STRAIGHT_FANCY_TRUNK_PLACER = TrunkPlacerType.register(
			Reference.MOD_PREFIX + "straight_fancy_trunk_placer", FancyTrunkPlacer.CODEC);

	public static final RandomSource rand = RandomSource.create();

	private static final BlockState WHITE_WOOL_LOG = Blocks.WHITE_WOOL.defaultBlockState();
	private static final BlockState GREEN_WOOL_LEAVES = WoolyRegistry.GREEN_WOOL_LEAVES.get().defaultBlockState();
	private static final BlockState WOOLY_SAPLING = WoolyRegistry.WOOLY_SAPLING.get().defaultBlockState();
	private static final BlockState JEB_SAPLING = WoolyRegistry.JEB_SAPLING.get().defaultBlockState();

	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_WOOL =
			FeatureUtils.register("woolytrees:fancy_wool", WoolyRegistry.WOOLY_TREE.get(), createFancyWool().build());

	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_WOOL_BEES_005 =
			FeatureUtils.register("woolytrees:fancy_wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get(), createFancyWool().decorators(List.of(TreeFeatures.BEEHIVE_005)).build());

	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> WOOL =
			FeatureUtils.register("woolytrees:wool", WoolyRegistry.WOOLY_TREE.get(), createWool().build());

	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> WOOL_BEES_005 =
			FeatureUtils.register("woolytrees:wool_with_bees_005", WoolyRegistry.WOOLY_TREE.get(), createWool().decorators(List.of(TreeFeatures.BEEHIVE_005)).build());

	public static Holder<? extends ConfiguredFeature<?, ?>> createJebHolder(TreeConfiguration configuration) {
		return Holder.direct(new ConfiguredFeature<>(WoolyRegistry.JEB_TREE.get(), configuration));
	}

	private static TreeConfiguration.TreeConfigurationBuilder createFancyWool() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(WHITE_WOOL_LOG),
				new FancyWoolPlacer(3, 11, 0),
				SimpleStateProvider.simple(GREEN_WOOL_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder createWool() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(WHITE_WOOL_LOG),
				new StraightTrunkPlacer(4, 2, 0),
				SimpleStateProvider.simple(GREEN_WOOL_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}


	public static TreeConfiguration.TreeConfigurationBuilder getFancyJeb() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(getRandomLog()),
				new FancyWoolPlacer(3, 11, 0),
				SimpleStateProvider.simple(getRandomLeaves()),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	public static TreeConfiguration getFancyJebConfiguration() {
		return getFancyJeb().build();
	}

	public static TreeConfiguration getFancyJebWithBeehives() {
		return getFancyJeb().decorators(List.of(TreeFeatures.BEEHIVE_005)).build();
	}

	public static TreeConfiguration getJebConfiguration() {
		return getJeb().build();
	}

	public static TreeConfiguration getJebWithBeehives() {
		return getJeb().decorators(List.of(TreeFeatures.BEEHIVE_005)).build();
	}

	public static TreeConfiguration.TreeConfigurationBuilder getJeb() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(getRandomLog()),
				new StraightTrunkPlacer(4, 2, 0),
				SimpleStateProvider.simple(getRandomLeaves()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	public static BlockState getRandomLeaves() {
		BlockState randomState = GREEN_WOOL_LEAVES;

		boolean isEmpty = ForgeRegistries.BLOCKS.tags().getTag(WoolyTags.WOOLY_LEAVES).isEmpty();
		if (!isEmpty) {
			Optional<Block> randomBlock = ForgeRegistries.BLOCKS.tags().getTag(WoolyTags.WOOLY_LEAVES).getRandomElement(rand);
			if (randomBlock.isPresent()) {
				randomState = randomBlock.get().defaultBlockState();
			}
		}
		return randomState;
	}

	public static BlockState getRandomLog() {
		BlockState randomState = WHITE_WOOL_LOG;
		boolean isEmpty = ForgeRegistries.BLOCKS.tags().getTag(WoolyTags.WOOLY_LOGS).isEmpty();
		if (!isEmpty) {
			Optional<Block> randomBlock = ForgeRegistries.BLOCKS.tags().getTag(WoolyTags.WOOLY_LOGS).getRandomElement(rand);
			if (randomBlock.isPresent()) {
				randomState = randomBlock.get().defaultBlockState();
			}
		}
		return randomState;
	}
}