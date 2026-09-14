package pookstir.pookstirsenhancednether.features;

import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;

import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlocks;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class PookstirsEnhancedNetherConfiguredFeatures {
    public static final BlockPredicate STEM_REPLACEABLE_BLOCKS = BlockPredicate.matchesBlocks(new Block[]{Blocks.OAK_SAPLING,
            Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING,
            Blocks.CHERRY_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.PALE_OAK_SAPLING, Blocks.MANGROVE_PROPAGULE,
            Blocks.DANDELION, Blocks.TORCHFLOWER, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM,
            Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP,
            Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.WITHER_ROSE, Blocks.LILY_OF_THE_VALLEY,
            Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.WHEAT, Blocks.SUGAR_CANE,
            Blocks.ATTACHED_PUMPKIN_STEM, Blocks.ATTACHED_MELON_STEM, Blocks.PUMPKIN_STEM, Blocks.MELON_STEM,
            Blocks.LILY_PAD, Blocks.NETHER_WART, Blocks.COCOA, Blocks.CARROTS, Blocks.POTATOES, Blocks.CHORUS_PLANT,
            Blocks.CHORUS_FLOWER, Blocks.TORCHFLOWER_CROP, Blocks.PITCHER_CROP, Blocks.BEETROOTS,
            Blocks.SWEET_BERRY_BUSH, Blocks.WARPED_FUNGUS, Blocks.CRIMSON_FUNGUS, Blocks.WEEPING_VINES,
            Blocks.WEEPING_VINES_PLANT, Blocks.TWISTING_VINES, Blocks.TWISTING_VINES_PLANT, Blocks.CAVE_VINES,
            Blocks.CAVE_VINES_PLANT, Blocks.SPORE_BLOSSOM, Blocks.AZALEA, Blocks.FLOWERING_AZALEA,
            Blocks.MOSS_CARPET, Blocks.PINK_PETALS, Blocks.WILDFLOWERS, Blocks.BIG_DRIPLEAF,
            Blocks.BIG_DRIPLEAF_STEM, Blocks.SMALL_DRIPLEAF, PookstirsEnhancedNetherBlocks.STAGNANT_FUNGUS});

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) throws Error {
        HugeFungusConfiguration stagnantFungusPlanted = new HugeFungusConfiguration(
                PookstirsEnhancedNetherBlocks.STAGNANT_NYLIUM.defaultBlockState(),
                PookstirsEnhancedNetherBlocks.STAGNANT_STEM.defaultBlockState(),
                PookstirsEnhancedNetherBlocks.STAGNANT_WART_BLOCK.defaultBlockState(),
                Blocks.SHROOMLIGHT.defaultBlockState(), STEM_REPLACEABLE_BLOCKS, true);

        context.register(PookstirsEnhancedNetherFeatures.STAGNANT_FUNGUS_PLANTED,
                new ConfiguredFeature<>(Feature.HUGE_FUNGUS, stagnantFungusPlanted));
    }
}
