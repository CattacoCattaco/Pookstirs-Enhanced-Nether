package pookstir.pookstirsenhancednether;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PookstirsEnhancedNether implements ModInitializer {
	public static final String MOD_ID = "pookstirs-enhanced-nether";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		PookstirsEnhancedNetherBlocks.initialize();
		PookstirsEnhancedNetherItems.initialize();
		PookstirsEnhancedNetherEntityTypes.initialize();

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(
				(creativeTab) -> {
					creativeTab.accept(PookstirsEnhancedNetherBlocks.STAGNANT_WART_BLOCK.asItem());
				});

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(
				(creativeTab) -> {
					creativeTab.accept(PookstirsEnhancedNetherItems.VOLATILE_CHARGE);
				});
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
