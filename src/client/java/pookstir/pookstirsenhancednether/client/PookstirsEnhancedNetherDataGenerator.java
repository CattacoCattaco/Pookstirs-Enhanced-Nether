package pookstir.pookstirsenhancednether.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import pookstir.pookstirsenhancednether.client.datagen.PookstirsEnhancedNetherBlockLootTableProvider;
import pookstir.pookstirsenhancednether.client.datagen.PookstirsEnhancedNetherBlockTagsProvider;
import pookstir.pookstirsenhancednether.client.datagen.PookstirsEnhancedNetherLangProvider;
import pookstir.pookstirsenhancednether.client.datagen.PookstirsEnhancedNetherModelProvider;

public class PookstirsEnhancedNetherDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(PookstirsEnhancedNetherLangProvider::new);
		pack.addProvider(PookstirsEnhancedNetherModelProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockLootTableProvider::new);
		pack.addProvider(PookstirsEnhancedNetherBlockTagsProvider::new);
	}
}
