package com.mrbysco.woolytrees;

import com.mrbysco.woolytrees.client.ClientHandler;
import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.handler.InteractionHandler;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MOD_ID)
public class WoolyTrees {
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

    public WoolyTrees() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, WoolyConfig.serverSpec);
        eventBus.register(WoolyConfig.class);

        WoolyRegistry.BLOCKS.register(eventBus);
        WoolyRegistry.ITEMS.register(eventBus);
        WoolyRegistry.FEATURES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(new InteractionHandler());

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientHandler::onClientSetup);
        });
    }
}
