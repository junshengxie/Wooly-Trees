package com.mrbysco.woolytrees.generator;

import static com.mrbysco.woolytrees.registry.WoolyRegistry.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;

import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;

public class WoolyBlockLootTables extends BlockLootTables {
    private final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        this.registerLootTable(WHITE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.WHITE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(ORANGE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.ORANGE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(MAGENTA_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.MAGENTA_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(LIGHT_BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(YELLOW_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.YELLOW_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(LIME_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIME_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(PINK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PINK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(LIGHT_GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(CYAN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.CYAN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(PURPLE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PURPLE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(BROWN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BROWN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(GREEN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GREEN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(RED_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.RED_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(BLACK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLACK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

        this.registerLootTable(WOOLY_BEE_NEST.get(), BlockLootTables::droppingAndBees);

        this.registerDropSelfLootTable(WOOLY_SAPLING.get());
        this.registerDropSelfLootTable(JEB_SAPLING.get());
    }

    protected static LootTable.Builder dropWoolWithStringAndChance(Block wool, Block sapling, float... p_218540_2_) {
        return droppingWithSilkTouchOrShears(wool, withSurvivesExplosion(wool, ItemLootEntry.builder(sapling)).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, p_218540_2_))).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withExplosionDecay(wool, ItemLootEntry.builder(Items.STRING).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>)BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
