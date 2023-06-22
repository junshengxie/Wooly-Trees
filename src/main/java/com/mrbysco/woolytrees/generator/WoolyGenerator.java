package com.mrbysco.woolytrees.generator;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WoolyGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
				packOutput, CompletableFuture.supplyAsync(WoolyGenerator::getProvider), Set.of(Reference.MOD_ID)));

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new Loots(packOutput));
			WoolyBlockTags blockTags = new WoolyBlockTags(packOutput, lookupProvider, helper);
			generator.addProvider(event.includeServer(), blockTags);
			generator.addProvider(event.includeServer(), new WoolyItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), helper));
		}
		if (event.includeClient()) {
			generator.addProvider(event.includeServer(), new Language(packOutput));
			generator.addProvider(event.includeServer(), new BlockStates(packOutput, helper));
			generator.addProvider(event.includeServer(), new ItemModels(packOutput, helper));
		}
	}

	private static HolderLookup.Provider getProvider() {
		final RegistrySetBuilder registryBuilder = new RegistrySetBuilder();
		registryBuilder.add(Registries.CONFIGURED_FEATURE, WoolyFeatureConfig::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, context -> {

		});
		// We need the BIOME registry to be present so we can use a biome tag, doesn't matter that it's empty
		registryBuilder.add(Registries.BIOME, context -> {
		});
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup());
	}

	private static class Loots extends LootTableProvider {
		public Loots(PackOutput packOutput) {
			super(packOutput, Set.of(), List.of(
					new SubProviderEntry(WoolyBlockLootTables::new, LootContextParamSets.BLOCK))
			);
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationresults) {
			map.forEach((name, table) -> table.validate(validationresults));
		}
	}

	private static class Language extends LanguageProvider {
		public Language(PackOutput output) {
			super(output, Reference.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			add("itemGroup.woolytrees.tab", "Wooly Trees");

			add(WoolyRegistry.WHITE_WOOL_LEAVES.get(), "White Wool Leaves");
			add(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), "Orange Wool Leaves");
			add(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), "Magenta Wool Leaves");
			add(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), "Light Blue Wool Leaves");
			add(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), "Yellow Wool Leaves");
			add(WoolyRegistry.LIME_WOOL_LEAVES.get(), "Lime Wool Leaves");
			add(WoolyRegistry.PINK_WOOL_LEAVES.get(), "Pink Wool Leaves");
			add(WoolyRegistry.GRAY_WOOL_LEAVES.get(), "Gray Wool Leaves");
			add(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), "Light Gray Wool Leaves");
			add(WoolyRegistry.CYAN_WOOL_LEAVES.get(), "Cyan Wool Leaves");
			add(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), "Purple Wool Leaves");
			add(WoolyRegistry.BLUE_WOOL_LEAVES.get(), "Blue Wool Leaves");
			add(WoolyRegistry.BROWN_WOOL_LEAVES.get(), "Brown Wool Leaves");
			add(WoolyRegistry.GREEN_WOOL_LEAVES.get(), "Green Wool Leaves");
			add(WoolyRegistry.RED_WOOL_LEAVES.get(), "Red Wool Leaves");
			add(WoolyRegistry.BLACK_WOOL_LEAVES.get(), "Black Wool Leaves");

			add(WoolyRegistry.WOOLY_BEE_NEST.get(), "Wooly Bee Nest");

			add(WoolyRegistry.WOOLY_SAPLING.get(), "Wooly Sapling");
			add(WoolyRegistry.JEB_SAPLING.get(), "Jeb_ Sapling");
		}
	}

	private static class ItemModels extends ItemModelProvider {
		public ItemModels(PackOutput packOutput, ExistingFileHelper helper) {
			super(packOutput, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerModels() {
			makeLeaves(WoolyRegistry.WHITE_WOOL_LEAVES.get(), "white_wool");
			makeLeaves(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), "orange_wool");
			makeLeaves(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), "magenta_wool");
			makeLeaves(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), "light_blue_wool");
			makeLeaves(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), "yellow_wool");
			makeLeaves(WoolyRegistry.LIME_WOOL_LEAVES.get(), "lime_wool");
			makeLeaves(WoolyRegistry.PINK_WOOL_LEAVES.get(), "pink_wool");
			makeLeaves(WoolyRegistry.GRAY_WOOL_LEAVES.get(), "gray_wool");
			makeLeaves(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), "light_gray_wool");
			makeLeaves(WoolyRegistry.CYAN_WOOL_LEAVES.get(), "cyan_wool");
			makeLeaves(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), "purple_wool");
			makeLeaves(WoolyRegistry.BLUE_WOOL_LEAVES.get(), "blue_wool");
			makeLeaves(WoolyRegistry.BROWN_WOOL_LEAVES.get(), "brown_wool");
			makeLeaves(WoolyRegistry.GREEN_WOOL_LEAVES.get(), "green_wool");
			makeLeaves(WoolyRegistry.RED_WOOL_LEAVES.get(), "red_wool");
			makeLeaves(WoolyRegistry.BLACK_WOOL_LEAVES.get(), "black_wool");

			makeBlock(WoolyRegistry.WOOLY_BEE_NEST.get());

			makeSapling(WoolyRegistry.WOOLY_SAPLING.get());
			makeSapling(WoolyRegistry.JEB_SAPLING.get());
		}

		private void makeLeaves(Block block, String originalBlock) {
			String path = ForgeRegistries.BLOCKS.getKey(block).getPath();
			getBuilder(path)
					.parent(new ModelFile.UncheckedModelFile(mcLoc("block/" + originalBlock)));
		}

		private void makeBlock(Block block) {
			String path = ForgeRegistries.BLOCKS.getKey(block).getPath();
			getBuilder(path)
					.parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
		}

		private void makeSapling(Block block) {
			String path = ForgeRegistries.BLOCKS.getKey(block).getPath();
			getBuilder(path)
					.parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
					.texture("layer0", modLoc("block/" + path));
		}

		@Override
		public String getName() {
			return "Item Models";
		}
	}

	private static class BlockStates extends BlockStateProvider {

		public BlockStates(PackOutput packOutput, ExistingFileHelper helper) {
			super(packOutput, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			makeLeaves(WoolyRegistry.WHITE_WOOL_LEAVES.get(), mcLoc("block/white_wool"));
			makeLeaves(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), mcLoc("block/orange_wool"));
			makeLeaves(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), mcLoc("block/magenta_wool"));
			makeLeaves(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), mcLoc("block/light_blue_wool"));
			makeLeaves(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), mcLoc("block/yellow_wool"));
			makeLeaves(WoolyRegistry.LIME_WOOL_LEAVES.get(), mcLoc("block/lime_wool"));
			makeLeaves(WoolyRegistry.PINK_WOOL_LEAVES.get(), mcLoc("block/pink_wool"));
			makeLeaves(WoolyRegistry.GRAY_WOOL_LEAVES.get(), mcLoc("block/gray_wool"));
			makeLeaves(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), mcLoc("block/light_gray_wool"));
			makeLeaves(WoolyRegistry.CYAN_WOOL_LEAVES.get(), mcLoc("block/cyan_wool"));
			makeLeaves(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), mcLoc("block/purple_wool"));
			makeLeaves(WoolyRegistry.BLUE_WOOL_LEAVES.get(), mcLoc("block/blue_wool"));
			makeLeaves(WoolyRegistry.BROWN_WOOL_LEAVES.get(), mcLoc("block/brown_wool"));
			makeLeaves(WoolyRegistry.GREEN_WOOL_LEAVES.get(), mcLoc("block/green_wool"));
			makeLeaves(WoolyRegistry.RED_WOOL_LEAVES.get(), mcLoc("block/red_wool"));
			makeLeaves(WoolyRegistry.BLACK_WOOL_LEAVES.get(), mcLoc("block/black_wool"));

			makeNest(WoolyRegistry.WOOLY_BEE_NEST.get());

			makeSapling(WoolyRegistry.WOOLY_SAPLING.get(), modLoc("block/wooly_sapling"));
			makeSapling(WoolyRegistry.JEB_SAPLING.get(), modLoc("block/jeb_sapling"));
		}

		private void makeLeaves(Block block, ResourceLocation original) {
			ModelFile model = models().getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(models().getExistingFile(original));
			getVariantBuilder(block)
					.forAllStates(state -> ConfiguredModel.builder()
							.modelFile(model).build());
		}

		private void makeNest(Block block) {
			String path = ForgeRegistries.BLOCKS.getKey(block).getPath();
			ModelFile model = models().getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(models().getExistingFile(mcLoc("block/bee_nest")))
					.texture("particle", "block/" + path + "_side")
					.texture("bottom", "block/" + path + "_bottom")
					.texture("top", "block/" + path + "_top")
					.texture("front", "block/" + path + "_front")
					.texture("side", "block/" + path + "_side");
			ModelFile model2 = models().getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_honey")
					.parent(models().getExistingFile(modLoc("block/wooly_bee_nest")))
					.texture("front", "block/" + path + "_front_honey");
			getVariantBuilder(block)
					.forAllStates(state -> {
						boolean fullOfHoney = state.getValue(BeehiveBlock.HONEY_LEVEL) == 5;
						return ConfiguredModel.builder()
								.modelFile(fullOfHoney ? model2 : model).build();
					});
		}

		private void makeSapling(Block block, ResourceLocation texture) {

			ModelFile model = models().getBuilder(ForgeRegistries.BLOCKS.getKey(block).getPath())
					.parent(models().getExistingFile(mcLoc("block/cross"))).renderType("minecraft:cutout")
					.texture("cross", texture);
			getVariantBuilder(block)
					.forAllStates(state -> ConfiguredModel.builder()
							.modelFile(model).build());
		}
	}


	public static class WoolyBlockTags extends BlockTagsProvider {
		public WoolyBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
			super(output, lookupProvider, Reference.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			this.tag(WoolyTags.WOOLY_LEAVES).add(WoolyRegistry.WHITE_WOOL_LEAVES.get(), WoolyRegistry.ORANGE_WOOL_LEAVES.get(), WoolyRegistry.MAGENTA_WOOL_LEAVES.get(),
					WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), WoolyRegistry.YELLOW_WOOL_LEAVES.get(), WoolyRegistry.LIME_WOOL_LEAVES.get(), WoolyRegistry.PINK_WOOL_LEAVES.get(),
					WoolyRegistry.GRAY_WOOL_LEAVES.get(), WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), WoolyRegistry.CYAN_WOOL_LEAVES.get(), WoolyRegistry.PURPLE_WOOL_LEAVES.get(),
					WoolyRegistry.BLUE_WOOL_LEAVES.get(), WoolyRegistry.BROWN_WOOL_LEAVES.get(), WoolyRegistry.GREEN_WOOL_LEAVES.get(), WoolyRegistry.RED_WOOL_LEAVES.get(),
					WoolyRegistry.BLACK_WOOL_LEAVES.get());

			this.tag(WoolyTags.WOOLY_LOGS).addTag(BlockTags.WOOL);

			this.tag(BlockTags.LEAVES).addTag(WoolyTags.WOOLY_LEAVES);
		}
	}

	public static class WoolyItemTags extends ItemTagsProvider {
		public WoolyItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
							 CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, @Nullable ExistingFileHelper existingFileHelper) {
			super(output, lookupProvider, tagLookup, Reference.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			this.tag(WoolyTags.CONVERTING_SAPLING).add(Items.OAK_SAPLING);
		}
	}
}
