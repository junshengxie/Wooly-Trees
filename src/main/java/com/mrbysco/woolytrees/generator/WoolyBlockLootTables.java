package com.mrbysco.woolytrees.generator;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import static com.mrbysco.woolytrees.registry.WoolyRegistry.*;

public class WoolyBlockLootTables extends BlockLoot {
    private static final LootItemCondition.Builder HAS_SILK_TOUCH_ENCHANT = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_SHEARS_TAG = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_TAG.or(HAS_SILK_TOUCH_ENCHANT);
    public static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

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

        this.add(WOOLY_BEE_NEST.get(), BlockLoot::createBeeNestDrop);

        this.dropSelf(WOOLY_SAPLING.get());
        this.dropSelf(JEB_SAPLING.get());
    }
    protected static LootTable.Builder createSilkTouchOrShearsDispatchTable(Block p_124284_, LootPoolEntryContainer.Builder<?> p_124285_) {
        return createSelfDropDispatchTable(p_124284_, HAS_SHEARS_OR_SILK_TOUCH, p_124285_);
    }

    protected static LootTable.Builder dropWoolWithStringAndChance(Block wool, Block sapling, float... p_218540_2_) {
        return createSilkTouchOrShearsDispatchTable(wool, applyExplosionCondition(wool, LootItem.lootTableItem(sapling))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, p_218540_2_))).withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionDecay(wool, LootItem.lootTableItem(Items.STRING)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>)BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
