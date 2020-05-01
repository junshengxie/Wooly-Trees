package com.mrbysco.woolytrees.config;

import com.mrbysco.woolytrees.WoolyTrees;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class WoolyConfig {
    public static class Server {
        public final BooleanValue saplingFromSheep;
        public final DoubleValue saplingPercentage;

        Server(ForgeConfigSpec.Builder builder) {
            builder.comment("Server settings")
                    .push("Server");

            String[] containers = new String[]
                    {
                            "ShulkerBoxTileEntity"
                    };

            saplingFromSheep = builder
                    .comment("When enabled you get the wooly sapling from right-clicking a sheep (default: true)")
                    .define("saplingFromSheep", true);

            saplingPercentage = builder
                    .comment("The percentage in which you get the sapling [0.1 = 10%] (default: 0.1)")
                    .defineInRange("saplingPercentage", 0.1D, 0.0D, 1.0D);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec serverSpec;
    public static final WoolyConfig.Server SERVER;

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(WoolyConfig.Server::new);
        serverSpec = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        WoolyTrees.LOGGER.debug("Loaded Wooly Trees' config file {}", configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent) {
        WoolyTrees.LOGGER.debug("Wooly Trees' config just got changed on the file system!");
    }
}
