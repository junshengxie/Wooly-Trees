package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import com.mrbysco.woolytrees.blocks.WoolyLeavesBlock;
import com.mrbysco.woolytrees.blocks.WoolySaplingBlock;
import com.mrbysco.woolytrees.item.SaplingBlock;
import com.mrbysco.woolytrees.trees.JebTree;
import com.mrbysco.woolytrees.trees.WoolTree;
import com.mrbysco.woolytrees.trees.features.FancyWoolyTreeFeature;
import com.mrbysco.woolytrees.trees.features.JebTreeFeature;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WoolyRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Reference.MOD_ID);

    public static final RegistryObject<Feature<TreeFeatureConfig>> FANCY_TREE = FEATURES.register("fancy_wooly_tree", () -> new FancyWoolyTreeFeature(TreeFeatureConfig::func_227338_a_));;

    public static final RegistryObject<Feature<TreeFeatureConfig>> FANCY_JEB_TREE = FEATURES.register("fancy_jeb_tree", () -> new FancyWoolyTreeFeature(TreeFeatureConfig::func_227338_a_));;
    public static final RegistryObject<Feature<TreeFeatureConfig>> JEB_TREE = FEATURES.register("jeb_tree", () -> new JebTreeFeature(TreeFeatureConfig::func_227338_a_));;


    public static final RegistryObject<Block> WHITE_WOOL_LEAVES = BLOCKS.register("white_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.SNOW).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> ORANGE_WOOL_LEAVES = BLOCKS.register("orange_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.ADOBE).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> MAGENTA_WOOL_LEAVES = BLOCKS.register("magenta_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.MAGENTA).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_LEAVES = BLOCKS.register("light_blue_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> YELLOW_WOOL_LEAVES = BLOCKS.register("yellow_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.YELLOW).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> LIME_WOOL_LEAVES = BLOCKS.register("lime_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.LIME).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> PINK_WOOL_LEAVES = BLOCKS.register("pink_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.PINK).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> GRAY_WOOL_LEAVES = BLOCKS.register("gray_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.GRAY).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_LEAVES = BLOCKS.register("light_gray_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.LIGHT_GRAY).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> CYAN_WOOL_LEAVES = BLOCKS.register("cyan_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.CYAN).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> PURPLE_WOOL_LEAVES = BLOCKS.register("purple_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.PURPLE).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> BLUE_WOOL_LEAVES = BLOCKS.register("blue_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.BLUE).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> BROWN_WOOL_LEAVES = BLOCKS.register("brown_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.BROWN).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> GREEN_WOOL_LEAVES = BLOCKS.register("green_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.GREEN).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> RED_WOOL_LEAVES = BLOCKS.register("red_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.RED).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));
    public static final RegistryObject<Block> BLACK_WOOL_LEAVES = BLOCKS.register("black_wool_leaves", () -> new WoolyLeavesBlock(Block.Properties.create(Material.WOOL, MaterialColor.BLACK).hardnessAndResistance(0.8F).tickRandomly().sound(SoundType.CLOTH).notSolid()));

    public static final RegistryObject<Block> WOOLY_BEE_NEST = BLOCKS.register("wooly_bee_nest", () -> new BeehiveBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WOOLY_SAPLING = BLOCKS.register("wooly_sapling", () -> new WoolySaplingBlock(() -> new WoolTree(), Block.Properties.create(Material.WOOL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> JEB_SAPLING = BLOCKS.register("jeb_sapling", () -> new WoolySaplingBlock(() -> new JebTree(), Block.Properties.create(Material.WOOL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));

    // Items
    public static final RegistryObject<Item> WHITE_WOOL_LEAVES_ITEM = ITEMS.register("white_wool_leaves", () -> new BlockItem(WHITE_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> ORANGE_WOOL_LEAVES_ITEM = ITEMS.register("orange_wool_leaves", () -> new BlockItem(ORANGE_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> MAGENTA_WOOL_LEAVES_ITEM = ITEMS.register("magenta_wool_leaves", () -> new BlockItem(MAGENTA_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIGHT_BLUE_WOOL_LEAVES_ITEM = ITEMS.register("light_blue_wool_leaves", () -> new BlockItem(LIGHT_BLUE_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> YELLOW_WOOL_LEAVES_ITEM = ITEMS.register("yellow_wool_leaves", () -> new BlockItem(YELLOW_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIME_WOOL_LEAVES_ITEM = ITEMS.register("lime_wool_leaves", () -> new BlockItem(LIME_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> PINK_WOOL_LEAVES_ITEM = ITEMS.register("pink_wool_leaves", () -> new BlockItem(PINK_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> GRAY_WOOL_LEAVES_ITEM = ITEMS.register("gray_wool_leaves", () -> new BlockItem(GRAY_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> LIGHT_GRAY_WOOL_LEAVES_ITEM = ITEMS.register("light_gray_wool_leaves", () -> new BlockItem(LIGHT_GRAY_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> CYAN_WOOL_LEAVES_ITEM = ITEMS.register("cyan_wool_leaves", () -> new BlockItem(CYAN_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> PURPLE_WOOL_LEAVES_ITEM = ITEMS.register("purple_wool_leaves", () -> new BlockItem(PURPLE_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BLUE_WOOL_LEAVES_ITEM = ITEMS.register("blue_wool_leaves", () -> new BlockItem(BLUE_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BROWN_WOOL_LEAVES_ITEM = ITEMS.register("brown_wool_leaves", () -> new BlockItem(BROWN_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> GREEN_WOOL_LEAVES_ITEM = ITEMS.register("green_wool_leaves", () -> new BlockItem(GREEN_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> RED_WOOL_LEAVES_ITEM = ITEMS.register("red_wool_leaves", () -> new BlockItem(RED_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> BLACK_WOOL_LEAVES_ITEM = ITEMS.register("black_wool_leaves", () -> new BlockItem(BLACK_WOOL_LEAVES.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));

    public static final RegistryObject<Item> WOOLY_SAPLING_ITEM = ITEMS.register("wooly_sapling", () -> new SaplingBlock(WOOLY_SAPLING.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
    public static final RegistryObject<Item> JEB_SAPLING_ITEM = ITEMS.register("jeb_sapling", () -> new BlockItem(JEB_SAPLING.get(), new Item.Properties().group(WoolyGroup.WOOLY_TAB)));
}
