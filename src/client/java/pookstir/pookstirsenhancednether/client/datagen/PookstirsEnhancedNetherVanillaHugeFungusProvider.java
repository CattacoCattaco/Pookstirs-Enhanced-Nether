package pookstir.pookstirsenhancednether.client.datagen;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;

import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherConfiguredFeatures;

public class PookstirsEnhancedNetherVanillaHugeFungusProvider
        extends FabricCodecDataProvider<HugeFungusCodecForDatagen> {
    public PookstirsEnhancedNetherVanillaHugeFungusProvider(FabricPackOutput packOutput,
                                                            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture, PackOutput.Target.DATA_PACK, "worldgen/configured_feature",
                HugeFungusCodecForDatagen.CODEC);
    }

    @Override
    protected void configure(BiConsumer<Identifier, HugeFungusCodecForDatagen> provider,
                             HolderLookup.Provider registryLookup) {
        HugeFungusCodecForDatagen crimsonFungus = new HugeFungusCodecForDatagen(new HugeFungusConfiguration(
                Blocks.CRIMSON_NYLIUM.defaultBlockState(), Blocks.CRIMSON_STEM.defaultBlockState(),
                Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(),
                PookstirsEnhancedNetherConfiguredFeatures.STEM_REPLACEABLE_BLOCKS, false));
        HugeFungusCodecForDatagen crimsonFungusPlanted = new HugeFungusCodecForDatagen(new HugeFungusConfiguration(
                Blocks.CRIMSON_NYLIUM.defaultBlockState(), Blocks.CRIMSON_STEM.defaultBlockState(),
                Blocks.NETHER_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(),
                PookstirsEnhancedNetherConfiguredFeatures.STEM_REPLACEABLE_BLOCKS, true));
        HugeFungusCodecForDatagen warpedFungus = new HugeFungusCodecForDatagen(new HugeFungusConfiguration(
                Blocks.WARPED_NYLIUM.defaultBlockState(), Blocks.WARPED_STEM.defaultBlockState(),
                Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(),
                PookstirsEnhancedNetherConfiguredFeatures.STEM_REPLACEABLE_BLOCKS, false));
        HugeFungusCodecForDatagen warpedFungusPlanted = new HugeFungusCodecForDatagen(new HugeFungusConfiguration(
                Blocks.WARPED_NYLIUM.defaultBlockState(), Blocks.WARPED_STEM.defaultBlockState(),
                Blocks.WARPED_WART_BLOCK.defaultBlockState(), Blocks.SHROOMLIGHT.defaultBlockState(),
                PookstirsEnhancedNetherConfiguredFeatures.STEM_REPLACEABLE_BLOCKS, true));

        provider.accept(TreeFeatures.CRIMSON_FUNGUS.identifier(), crimsonFungus);
        provider.accept(TreeFeatures.CRIMSON_FUNGUS_PLANTED.identifier(), crimsonFungusPlanted);
        provider.accept(TreeFeatures.WARPED_FUNGUS.identifier(), warpedFungus);
        provider.accept(TreeFeatures.WARPED_FUNGUS_PLANTED.identifier(), warpedFungusPlanted);
    }

    @Override
    public String getName() {
        return "Vanilla Huge Fungus Provider";
    }
}
