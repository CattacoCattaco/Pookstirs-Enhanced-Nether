package pookstir.pookstirsenhancednether.client.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNether;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherBlockIDs;

public class PookstirsEnhancedNetherBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public static final TagKey<Block> STAGNANT_STEMS = create("stagnant_stems");

    public PookstirsEnhancedNetherBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private static TagKey<Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name));
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(BlockTags.WART_BLOCKS)
                .add(PookstirsEnhancedNetherBlockIDs.STAGNANT_WART_BLOCK);
        builder(BlockTags.MINEABLE_WITH_HOE)
                .addOptionalTag(BlockTags.WART_BLOCKS);

        builder(STAGNANT_STEMS)
                .add(PookstirsEnhancedNetherBlockIDs.STAGNANT_STEM);
        builder(ConventionalBlockTags.NETHER_NATURAL_LOGS)
                .add(PookstirsEnhancedNetherBlockIDs.STAGNANT_STEM);
        builder(BlockTags.LOGS)
                .addOptionalTag(ConventionalBlockTags.NETHER_NATURAL_LOGS);
        builder(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(ConventionalBlockTags.NETHER_NATURAL_LOGS);

        builder(BlockTags.NYLIUM)
                .add(PookstirsEnhancedNetherBlockIDs.STAGNANT_NYLIUM);
        builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addOptionalTag(BlockTags.NYLIUM);
        builder(BlockTags.ENDERMAN_HOLDABLE)
                .addOptionalTag(BlockTags.NYLIUM);
        builder(BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON)
                .addOptionalTag(BlockTags.NYLIUM);
        builder(BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON)
                .addOptionalTag(BlockTags.NYLIUM);
        builder(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT)
                .addOptionalTag(BlockTags.NYLIUM);
    }
}
