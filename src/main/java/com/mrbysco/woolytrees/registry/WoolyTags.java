package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class WoolyTags {
    public static final ITag.INamedTag<Block> WOOLY_LEAVES = BlockTags.makeWrapperTag(Reference.MOD_PREFIX + "wooly_leaves");
    public static final ITag.INamedTag<Block> WOOLY_LOGS = BlockTags.makeWrapperTag(Reference.MOD_PREFIX + "wooly_logs");
    public static final ITag.INamedTag<Item> CONVERTING_SAPLING = ItemTags.makeWrapperTag(Reference.MOD_PREFIX + "converting_saplings");
}
