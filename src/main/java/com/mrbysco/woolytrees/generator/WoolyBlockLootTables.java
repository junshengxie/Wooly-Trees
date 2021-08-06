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
        this.add(WHITE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.WHITE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(ORANGE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.ORANGE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(MAGENTA_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.MAGENTA_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(LIGHT_BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(YELLOW_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.YELLOW_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(LIME_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIME_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(PINK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PINK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(LIGHT_GRAY_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.LIGHT_GRAY_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(CYAN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.CYAN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(PURPLE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.PURPLE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(BLUE_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLUE_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(BROWN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BROWN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(GREEN_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.GREEN_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(RED_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.RED_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));
        this.add(BLACK_WOOL_LEAVES.get(), dropWoolWithStringAndChance(Blocks.BLACK_WOOL, WOOLY_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES));

        this.add(WOOLY_BEE_NEST.get(), BlockLootTables::createBeeNestDrop);

        this.dropSelf(WOOLY_SAPLING.get());
        this.dropSelf(JEB_SAPLING.get());
    }

    protected static LootTable.Builder dropWoolWithStringAndChance(Block wool, Block sapling, float... p_218540_2_) {
        return createSilkTouchOrShearsDispatchTable(wool, applyExplosionCondition(wool, ItemLootEntry.lootTableItem(sapling)).when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, p_218540_2_))).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionDecay(wool, ItemLootEntry.lootTableItem(Items.STRING).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F)))).when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>)BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
