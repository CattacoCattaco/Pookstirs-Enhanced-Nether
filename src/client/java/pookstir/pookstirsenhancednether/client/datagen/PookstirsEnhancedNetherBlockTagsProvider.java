package pookstir.pookstirsenhancednether.client.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlockIDs;

public class PookstirsEnhancedNetherBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public PookstirsEnhancedNetherBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(BlockTags.WART_BLOCKS)
                .add(PookstirsEnhancedNetherBlockIDs.STAGNANT_WART_BLOCK);
        builder(BlockTags.MINEABLE_WITH_HOE)
                .addOptionalTag(BlockTags.WART_BLOCKS);
    }
}
