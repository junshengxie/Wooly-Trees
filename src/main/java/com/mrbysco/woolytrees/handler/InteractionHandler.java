package com.mrbysco.woolytrees.handler;

import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class InteractionHandler {
    public static final Random rand = new Random();

    @SubscribeEvent
    public void onWorldTick(EntityInteract event) {
        if(event.getSide().isServer() && WoolyConfig.SERVER.saplingFromSheep.get() && event.getTarget() instanceof SheepEntity) {
            SheepEntity sheep = (SheepEntity) event.getTarget();
            PlayerEntity player = event.getPlayer();
            if(rand.nextDouble() <= WoolyConfig.SERVER.saplingPercentage.get() && !sheep.getSheared() && WoolyTags.CONVERTING_SAPLING.contains(event.getItemStack().getItem())) {
                if(!player.abilities.isCreativeMode) {
                    ItemStack interactStack = event.getItemStack();
                    interactStack.shrink(1);
                }
                ItemStack woolySapling = new ItemStack(WoolyRegistry.WOOLY_SAPLING_ITEM.get());
                if(sheep.getDisplayName().getUnformattedComponentText().equals("jeb_")) {
                    woolySapling = new ItemStack(WoolyRegistry.JEB_SAPLING.get());
                }
                //Drop item
                sheep.entityDropItem(woolySapling, 0.5F);

                sheep.setSheared(true);
                sheep.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
            } else {
                player.swingArm(event.getHand());
            }
        }
    }
}
