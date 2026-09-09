package pookstir.pookstirsenhancednether.client.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

import net.minecraft.client.data.models.model.TexturedModel;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlocks;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherItems;

public class PookstirsEnhancedNetherModelProvider extends FabricModelProvider {
    public PookstirsEnhancedNetherModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(PookstirsEnhancedNetherBlocks.STAGNANT_WART_BLOCK);
        blockStateModelGenerator.createAxisAlignedPillarBlock(PookstirsEnhancedNetherBlocks.STAGNANT_STEM,
                TexturedModel.COLUMN_ALT);
        blockStateModelGenerator.createNyliumBlock(PookstirsEnhancedNetherBlocks.STAGNANT_NYLIUM);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(PookstirsEnhancedNetherItems.VOLATILE_CHARGE, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName() {
        return "PookstirsEnhancedNetherModelProvider";
    }
}
