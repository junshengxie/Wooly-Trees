package com.mrbysco.woolytrees.item;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class SaplingBlock extends BlockItem {
    public SaplingBlock(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity && stack.getHoverName().getContents().equals("jeb_")) {
            PlayerEntity player = (PlayerEntity)entityIn ;
            ItemStack copyStack = stack.copy();
            ItemStack newStack = new ItemStack(WoolyRegistry.JEB_SAPLING_ITEM.get(), copyStack.getCount(), copyStack.getTag());
            player.inventory.setItem(itemSlot, newStack);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
