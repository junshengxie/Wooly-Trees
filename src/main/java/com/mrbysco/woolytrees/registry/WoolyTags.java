package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WoolyTags {
    public static void initialize() {}

    public static final Tag.Named<Block> WOOLY_LEAVES = BlockTags.bind(Reference.MOD_PREFIX + "wooly_leaves");
    public static final Tag.Named<Block> WOOLY_LOGS = BlockTags.bind(Reference.MOD_PREFIX + "wooly_logs");
    public static final Tag.Named<Item> CONVERTING_SAPLING = ItemTags.bind(Reference.MOD_PREFIX + "converting_saplings");
}
