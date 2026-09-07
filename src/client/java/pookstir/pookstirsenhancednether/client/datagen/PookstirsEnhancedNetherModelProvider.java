package pookstir.pookstirsenhancednether.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlocks;

public class PookstirsEnhancedNetherModelProvider extends FabricModelProvider {
    public PookstirsEnhancedNetherModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(PookstirsEnhancedNetherBlocks.STAGNANT_WART_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "PookstirsEnhancedNetherModelProvider";
    }
}
