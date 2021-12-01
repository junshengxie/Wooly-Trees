package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.blocks.WoolyLeavesBlock;
import com.mrbysco.woolytrees.blocks.WoolySaplingBlock;
import com.mrbysco.woolytrees.item.SaplingBlockItem;
import com.mrbysco.woolytrees.trees.JebTree;
import com.mrbysco.woolytrees.trees.WoolTree;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WoolyRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MOD_ID);

    public static final RegistryObject<Feature<TreeConfiguration>> WOOLY_TREE = FEATURES.register("fancy_wooly_tree", () -> new TreeFeature(TreeConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeConfiguration>> JEB_TREE = FEATURES.register("fancy_jeb_tree", () -> new TreeFeature(TreeConfiguration.CODEC));

    public static final RegistryObject<Block> WHITE_WOOL_LEAVES = BLOCKS.register("white_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.SNOW).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_WOOL_LEAVES = BLOCKS.register("orange_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_ORANGE).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> MAGENTA_WOOL_LEAVES = BLOCKS.register("magenta_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_MAGENTA).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_LEAVES = BLOCKS.register("light_blue_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_BLUE).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> YELLOW_WOOL_LEAVES = BLOCKS.register("yellow_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_YELLOW).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> LIME_WOOL_LEAVES = BLOCKS.register("lime_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_GREEN).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> PINK_WOOL_LEAVES = BLOCKS.register("pink_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> GRAY_WOOL_LEAVES = BLOCKS.register("gray_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_GRAY).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_LEAVES = BLOCKS.register("light_gray_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_GRAY).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> CYAN_WOOL_LEAVES = BLOCKS.register("cyan_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_CYAN).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> PURPLE_WOOL_LEAVES = BLOCKS.register("purple_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_PURPLE).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> BLUE_WOOL_LEAVES = BLOCKS.register("blue_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BLUE).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> BROWN_WOOL_LEAVES = BLOCKS.register("brown_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> GREEN_WOOL_LEAVES = BLOCKS.register("green_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_GREEN).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> RED_WOOL_LEAVES = BLOCKS.register("red_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_RED).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));
    public static final RegistryObject<Block> BLACK_WOOL_LEAVES = BLOCKS.register("black_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BLACK).strength(0.8F).randomTicks().sound(SoundType.WOOL).noOcclusion()));

    public static final RegistryObject<Block> WOOLY_BEE_NEST = BLOCKS.register("wooly_bee_nest", () -> new BeehiveBlock(Block.Properties.of(Material.WOOL).strength(0.8F).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> WOOLY_SAPLING = BLOCKS.register("wooly_sapling", () -> new WoolySaplingBlock(() -> new WoolTree(), Block.Properties.of(Material.WOOL).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> JEB_SAPLING = BLOCKS.register("jeb_sapling", () -> new WoolySaplingBlock(() -> new JebTree(), Block.Properties.of(Material.WOOL).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));

    // Items
    public static final RegistryObject<Item> WHITE_WOOL_LEAVES_ITEM = ITEMS.register("white_wool_leaves", () -> new BlockItem(WHITE_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> ORANGE_WOOL_LEAVES_ITEM = ITEMS.register("orange_wool_leaves", () -> new BlockItem(ORANGE_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> MAGENTA_WOOL_LEAVES_ITEM = ITEMS.register("magenta_wool_leaves", () -> new BlockItem(MAGENTA_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIGHT_BLUE_WOOL_LEAVES_ITEM = ITEMS.register("light_blue_wool_leaves", () -> new BlockItem(LIGHT_BLUE_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> YELLOW_WOOL_LEAVES_ITEM = ITEMS.register("yellow_wool_leaves", () -> new BlockItem(YELLOW_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIME_WOOL_LEAVES_ITEM = ITEMS.register("lime_wool_leaves", () -> new BlockItem(LIME_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> PINK_WOOL_LEAVES_ITEM = ITEMS.register("pink_wool_leaves", () -> new BlockItem(PINK_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> GRAY_WOOL_LEAVES_ITEM = ITEMS.register("gray_wool_leaves", () -> new BlockItem(GRAY_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIGHT_GRAY_WOOL_LEAVES_ITEM = ITEMS.register("light_gray_wool_leaves", () -> new BlockItem(LIGHT_GRAY_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> CYAN_WOOL_LEAVES_ITEM = ITEMS.register("cyan_wool_leaves", () -> new BlockItem(CYAN_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> PURPLE_WOOL_LEAVES_ITEM = ITEMS.register("purple_wool_leaves", () -> new BlockItem(PURPLE_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BLUE_WOOL_LEAVES_ITEM = ITEMS.register("blue_wool_leaves", () -> new BlockItem(BLUE_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BROWN_WOOL_LEAVES_ITEM = ITEMS.register("brown_wool_leaves", () -> new BlockItem(BROWN_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> GREEN_WOOL_LEAVES_ITEM = ITEMS.register("green_wool_leaves", () -> new BlockItem(GREEN_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> RED_WOOL_LEAVES_ITEM = ITEMS.register("red_wool_leaves", () -> new BlockItem(RED_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BLACK_WOOL_LEAVES_ITEM = ITEMS.register("black_wool_leaves", () -> new BlockItem(BLACK_WOOL_LEAVES.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));

    public static final RegistryObject<Item> WOOLY_BEE_NEST_ITEM = ITEMS.register("wooly_bee_nest", () -> new BlockItem(WOOLY_BEE_NEST.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));

    public static final RegistryObject<Item> WOOLY_SAPLING_ITEM = ITEMS.register("wooly_sapling", () -> new SaplingBlockItem(WOOLY_SAPLING.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> JEB_SAPLING_ITEM = ITEMS.register("jeb_sapling", () -> new BlockItem(JEB_SAPLING.get(), new Item.Properties().tab(WoolyGroup.WOOLY_TAB)));
}
