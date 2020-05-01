package com.mrbysco.woolytrees.handlers;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenameHandler {
    @SubscribeEvent
    public void AnvilEvent(AnvilUpdateEvent event) {
        ItemStack originalLeft = event.getLeft();
        System.out.println("hey");
        boolean leftIsSapling = originalLeft.getItem() == WoolyRegistry.WOOLY_SAPLING_ITEM.get();
        boolean nameIsCorrect = event.getName().equals("jeb_");
        if(leftIsSapling && nameIsCorrect && event.getRight().isEmpty()) {
            ItemStack newOutput = new ItemStack(WoolyRegistry.JEB_SAPLING_ITEM.get(), originalLeft.getCount(), originalLeft.getTag());
            event.setOutput(newOutput);
        }
    }
}
