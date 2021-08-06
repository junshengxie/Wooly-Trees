package com.mrbysco.woolytrees.client;

import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(WoolyRegistry.WOOLY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WoolyRegistry.JEB_SAPLING.get(), RenderType.cutout());;
    }
}
