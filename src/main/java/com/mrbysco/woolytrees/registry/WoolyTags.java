package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class WoolyTags {
    public static final ITag<Block> WOOLY_LEAVES = BlockTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "wooly_leaves"));
    public static final ITag<Block> WOOLY_LOGS = BlockTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "wooly_logs"));
    public static final ITag<Item> CONVERTING_SAPLING = ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "converting_saplings"));
}
