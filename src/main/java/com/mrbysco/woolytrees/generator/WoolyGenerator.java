package com.mrbysco.woolytrees.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.woolytrees.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mrbysco.woolytrees.registry.WoolyRegistry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WoolyGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(new Loots(generator));
        }
        if (event.includeClient()) {
//            generator.addProvider(new Language(generator));
//            generator.addProvider(new BlockStates(generator, helper));
//            generator.addProvider(new ItemModels(generator, helper));
        }
    }

    private static class Loots extends LootTableProvider {
        public Loots(DataGenerator gen) {
            super(gen);
        }

        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
            return ImmutableList.of(
                    Pair.of(WoolyBlockLootTables::new, LootContextParamSets.BLOCK)
            );
        }

        @Override
        protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationresults) {
            map.forEach((name, table) -> LootTables.validate(validationresults, name, table));
        }
    }

    private static class Language extends LanguageProvider {
        public Language(DataGenerator gen) {
            super(gen, Reference.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup.woolytrees.tab", "Wooly Trees");

            add(WHITE_WOOL_LEAVES.get(), "White Wool Leaves");
            add(ORANGE_WOOL_LEAVES.get(), "Orange Wool Leaves");
            add(MAGENTA_WOOL_LEAVES.get(), "Magenta Wool Leaves");
            add(LIGHT_BLUE_WOOL_LEAVES.get(), "Light Blue Wool Leaves");
            add(YELLOW_WOOL_LEAVES.get(), "Yellow Wool Leaves");
            add(LIME_WOOL_LEAVES.get(), "Lime Wool Leaves");
            add(PINK_WOOL_LEAVES.get(), "Pink Wool Leaves");
            add(GRAY_WOOL_LEAVES.get(), "Gray Wool Leaves");
            add(LIGHT_GRAY_WOOL_LEAVES.get(), "Light Gray Wool Leaves");
            add(CYAN_WOOL_LEAVES.get(), "Cyan Wool Leaves");
            add(PURPLE_WOOL_LEAVES.get(), "Purple Wool Leaves");
            add(BLUE_WOOL_LEAVES.get(), "Blue Wool Leaves");
            add(BROWN_WOOL_LEAVES.get(), "Brown Wool Leaves");
            add(GREEN_WOOL_LEAVES.get(), "Green Wool Leaves");
            add(RED_WOOL_LEAVES.get(), "Red Wool Leaves");
            add(BLACK_WOOL_LEAVES.get(), "Black Wool Leaves");

            add(WOOLY_BEE_NEST.get(), "Wooly Bee Nest");

            add(WOOLY_SAPLING.get(), "Wooly Sapling");
            add(JEB_SAPLING.get(), "Jeb_ Sapling");
        }
    }

    private static class ItemModels extends ItemModelProvider {
        public ItemModels(DataGenerator gen, ExistingFileHelper helper) {
            super(gen, Reference.MOD_ID, helper);
        }

        @Override
        protected void registerModels() {
            makeLeaves(WHITE_WOOL_LEAVES.get(), "white_wool");
            makeLeaves(ORANGE_WOOL_LEAVES.get(), "orange_wool");
            makeLeaves(MAGENTA_WOOL_LEAVES.get(), "magenta_wool");
            makeLeaves(LIGHT_BLUE_WOOL_LEAVES.get(), "light_blue_wool");
            makeLeaves(YELLOW_WOOL_LEAVES.get(), "yellow_wool");
            makeLeaves(LIME_WOOL_LEAVES.get(), "lime_wool");
            makeLeaves(PINK_WOOL_LEAVES.get(), "pink_wool");
            makeLeaves(GRAY_WOOL_LEAVES.get(), "gray_wool");
            makeLeaves(LIGHT_GRAY_WOOL_LEAVES.get(), "light_gray_wool");
            makeLeaves(CYAN_WOOL_LEAVES.get(), "cyan_wool");
            makeLeaves(PURPLE_WOOL_LEAVES.get(), "purple_wool");
            makeLeaves(BLUE_WOOL_LEAVES.get(), "blue_wool");
            makeLeaves(BROWN_WOOL_LEAVES.get(), "brown_wool");
            makeLeaves(GREEN_WOOL_LEAVES.get(), "green_wool");
            makeLeaves(RED_WOOL_LEAVES.get(), "red_wool");
            makeLeaves(BLACK_WOOL_LEAVES.get(), "black_wool");

            makeBlock(WOOLY_BEE_NEST.get());

            makeSapling(WOOLY_SAPLING.get());
            makeSapling(JEB_SAPLING.get());
        }

        private void makeLeaves(Block block, String originalBlock) {
            String path = block.getRegistryName().getPath();
            getBuilder(path)
                    .parent(new ModelFile.UncheckedModelFile(mcLoc("block/" + originalBlock)));
        }

        private void makeBlock(Block block) {
            String path = block.getRegistryName().getPath();
            getBuilder(path)
                    .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
        }

        private void makeSapling(Block block) {
            String path = block.getRegistryName().getPath();
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

        public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
            super(gen, Reference.MOD_ID, helper);
        }

        @Override
        protected void registerStatesAndModels() {
            makeLeaves(WHITE_WOOL_LEAVES.get(), mcLoc("block/white_wool"));
            makeLeaves(ORANGE_WOOL_LEAVES.get(), mcLoc("block/orange_wool"));
            makeLeaves(MAGENTA_WOOL_LEAVES.get(), mcLoc("block/magenta_wool"));
            makeLeaves(LIGHT_BLUE_WOOL_LEAVES.get(), mcLoc("block/light_blue_wool"));
            makeLeaves(YELLOW_WOOL_LEAVES.get(), mcLoc("block/yellow_wool"));
            makeLeaves(LIME_WOOL_LEAVES.get(), mcLoc("block/lime_wool"));
            makeLeaves(PINK_WOOL_LEAVES.get(), mcLoc("block/pink_wool"));
            makeLeaves(GRAY_WOOL_LEAVES.get(), mcLoc("block/gray_wool"));
            makeLeaves(LIGHT_GRAY_WOOL_LEAVES.get(), mcLoc("block/light_gray_wool"));
            makeLeaves(CYAN_WOOL_LEAVES.get(), mcLoc("block/cyan_wool"));
            makeLeaves(PURPLE_WOOL_LEAVES.get(), mcLoc("block/purple_wool"));
            makeLeaves(BLUE_WOOL_LEAVES.get(), mcLoc("block/blue_wool"));
            makeLeaves(BROWN_WOOL_LEAVES.get(), mcLoc("block/brown_wool"));
            makeLeaves(GREEN_WOOL_LEAVES.get(), mcLoc("block/green_wool"));
            makeLeaves(RED_WOOL_LEAVES.get(), mcLoc("block/red_wool"));
            makeLeaves(BLACK_WOOL_LEAVES.get(), mcLoc("block/black_wool"));

            makeNest(WOOLY_BEE_NEST.get());

            makeSapling(WOOLY_SAPLING.get(), modLoc("block/wooly_sapling"));
            makeSapling(JEB_SAPLING.get(), modLoc("block/jeb_sapling"));
        }

        private void makeLeaves(Block block, ResourceLocation original) {
            ModelFile model = models().getBuilder(block.getRegistryName().getPath())
                    .parent(models().getExistingFile(original));
            getVariantBuilder(block)
                    .forAllStates(state -> ConfiguredModel.builder()
                    .modelFile(model).build());
        }

        private void makeNest(Block block) {
            String path = block.getRegistryName().getPath();
            ModelFile model = models().getBuilder(block.getRegistryName().getPath())
                    .parent(models().getExistingFile(mcLoc("block/bee_nest")))
                    .texture("particle", "block/" + path + "_side")
                    .texture("bottom", "block/" + path + "_bottom")
                    .texture("top", "block/" + path + "_top")
                    .texture("front", "block/" + path + "_front")
                    .texture("side", "block/" + path + "_side");
            ModelFile model2 = models().getBuilder(block.getRegistryName().getPath() + "_honey")
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
            ModelFile model = models().getBuilder(block.getRegistryName().getPath())
                    .parent(models().getExistingFile(mcLoc("block/cross")))
                    .texture("cross", texture);
            getVariantBuilder(block)
                    .forAllStates(state -> ConfiguredModel.builder()
                            .modelFile(model).build());
        }
    }
}
