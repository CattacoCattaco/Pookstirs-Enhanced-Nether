package pookstir.pookstirsenhancednether.client;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import pookstir.pookstirsenhancednether.client.datagen.*;
import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherConfiguredFeatures;
import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherPlacedFeatures;

public class PookstirsEnhancedNetherDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(PookstirsEnhancedNetherLangProvider::new);
		pack.addProvider(PookstirsEnhancedNetherModelProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockLootTableProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockTagsProvider::new);
		pack.addProvider(PookstirsEnhancedNetherWorldgenProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, PookstirsEnhancedNetherConfiguredFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, PookstirsEnhancedNetherPlacedFeatures::configure);
	}
}
