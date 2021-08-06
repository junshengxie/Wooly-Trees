package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class WoolyTags {
    public static final ITag.INamedTag<Block> WOOLY_LEAVES = BlockTags.bind(Reference.MOD_PREFIX + "wooly_leaves");
    public static final ITag.INamedTag<Block> WOOLY_LOGS = BlockTags.bind(Reference.MOD_PREFIX + "wooly_logs");
    public static final ITag.INamedTag<Item> CONVERTING_SAPLING = ItemTags.bind(Reference.MOD_PREFIX + "converting_saplings");
}
