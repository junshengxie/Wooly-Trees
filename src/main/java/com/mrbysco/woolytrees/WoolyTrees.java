package com.mrbysco.woolytrees;

import com.mojang.logging.LogUtils;
import com.mrbysco.woolytrees.config.WoolyConfig;
import com.mrbysco.woolytrees.handler.InteractionHandler;
import com.mrbysco.woolytrees.registry.WoolyFeatureConfig;
import com.mrbysco.woolytrees.registry.WoolyRegistry;
import com.mrbysco.woolytrees.registry.WoolyTags;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.List;

@Mod(Reference.MOD_ID)
public class WoolyTrees {
	public static final Logger LOGGER = LogUtils.getLogger();

	public WoolyTrees() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, WoolyConfig.serverSpec);
		eventBus.register(WoolyConfig.class);

		eventBus.addListener(this::setup);
		eventBus.addListener(this::registerCreativeTabs);

		WoolyRegistry.BLOCKS.register(eventBus);
		WoolyRegistry.ITEMS.register(eventBus);
		WoolyRegistry.FEATURES.register(eventBus);

		MinecraftForge.EVENT_BUS.register(new InteractionHandler());
	}

	private void setup(final FMLCommonSetupEvent event) {
		WoolyTags.initialize();
		WoolyFeatureConfig.initialize();
	}

	private static CreativeModeTab WOOLY_TAB;

	private void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
		WOOLY_TAB = event.registerCreativeModeTab(new ResourceLocation(Reference.MOD_ID, "tab"), builder ->
				builder.icon(() -> new ItemStack(Blocks.WHITE_WOOL))
						.title(Component.translatable("itemGroup.woolytrees.tab"))
						.displayItems((features, output, hasPermissions) -> {
							List<ItemStack> stacks = WoolyRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
							output.acceptAll(stacks);
						}));
	}
}
