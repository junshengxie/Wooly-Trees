package com.mrbysco.woolytrees.generator;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.TableBonus;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;

public class WoolyBlockLootTables extends BlockLootTables {
    private final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        this.registerLootTable(WoolyRegistry.WHITE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.WHITE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.ORANGE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.ORANGE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.MAGENTA_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.MAGENTA_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.LIGHT_BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_BLUE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.YELLOW_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.YELLOW_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.LIME_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIME_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.PINK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PINK_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GRAY_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.LIGHT_GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_GRAY_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.CYAN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.CYAN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.PURPLE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PURPLE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLUE_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.BROWN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BROWN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.GREEN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GREEN_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.RED_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.RED_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.registerLootTable(WoolyRegistry.BLACK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLACK_WOOL, WoolyRegistry.WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

        this.registerLootTable(WoolyRegistry.WOOLY_BEE_NEST.get(), BlockLootTables::func_229436_h_);

        this.registerDropSelfLootTable(WoolyRegistry.WOOLY_SAPLING.get());
        this.registerDropSelfLootTable(WoolyRegistry.JEB_SAPLING.get());
    }

    protected static LootTable.Builder dropWoolWithStringAndChance(Block wool, Block sapling, float... p_218540_2_) {
        return droppingWithSilkTouchOrShears(wool, withSurvivesExplosion(wool, ItemLootEntry.builder(sapling)).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, p_218540_2_))).addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(NOT_SILK_TOUCH_OR_SHEARS).addEntry(withExplosionDecay(wool, ItemLootEntry.builder(Items.STRING).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>)WoolyRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
