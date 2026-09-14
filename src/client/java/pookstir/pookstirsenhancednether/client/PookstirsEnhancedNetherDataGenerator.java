package pookstir.pookstirsenhancednether.client;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import pookstir.pookstirsenhancednether.client.datagen.*;
import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherConfiguredFeatures;
import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherPlacedFeatures;

import java.util.concurrent.CompletableFuture;

public class PookstirsEnhancedNetherDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(PookstirsEnhancedNetherLangProvider::new);
		pack.addProvider(PookstirsEnhancedNetherModelProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockLootTableProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockTagsProvider::new);
		pack.addProvider(PookstirsEnhancedNetherWorldgenProvider::new);
		pack.addProvider(PookstirsEnhancedNetherVanillaHugeFungusProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, PookstirsEnhancedNetherConfiguredFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, PookstirsEnhancedNetherPlacedFeatures::configure);
	}
}
