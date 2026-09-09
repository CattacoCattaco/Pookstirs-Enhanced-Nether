package pookstir.pookstirsenhancednether.client.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlocks;

public class PookstirsEnhancedNetherBlockLootTableProvider extends FabricBlockLootSubProvider {
    public PookstirsEnhancedNetherBlockLootTableProvider(FabricPackOutput dataOutput,
                                                            CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(PookstirsEnhancedNetherBlocks.STAGNANT_WART_BLOCK);
        dropSelf(PookstirsEnhancedNetherBlocks.STAGNANT_STEM);
    }
}