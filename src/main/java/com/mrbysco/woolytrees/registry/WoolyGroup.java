package com.mrbysco.woolytrees.registry;

import com.mrbysco.woolytrees.Reference;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class WoolyGroup {
    public static final CreativeModeTab WOOLY_TAB = new CreativeModeTab(Reference.MOD_ID + ".tab") {
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.WHITE_WOOL);
        }
    };
}
