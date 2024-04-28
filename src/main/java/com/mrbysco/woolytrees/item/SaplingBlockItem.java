package com.mrbysco.woolytrees.item;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SaplingBlockItem extends BlockItem {
	public SaplingBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof Player player && stack.getHoverName().getString().equals("jeb_")) {
			ItemStack copyStack = stack.copy();
			ItemStack newStack = new ItemStack(WoolyRegistry.JEB_SAPLING_ITEM, copyStack.getCount(), copyStack.getComponentsPatch());
			player.getInventory().setItem(itemSlot, newStack);
		}
		super.inventoryTick(stack, level, entityIn, itemSlot, isSelected);
	}
}
