package pookstir.pookstirsenhancednether;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import pookstir.pookstirsenhancednether.features.PookstirsEnhancedNetherFeatures;

public class PookstirsEnhancedNetherBlocks {
    public static final Block STAGNANT_WART_BLOCK = register(
            PookstirsEnhancedNetherBlockIDs.STAGNANT_WART_BLOCK,
            Block::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F)
                    .sound(SoundType.WART_BLOCK)
    );
    public static final Block STAGNANT_STEM = register(
            PookstirsEnhancedNetherBlockIDs.STAGNANT_STEM,
            RotatedPillarBlock::new,
            Blocks.netherStemProperties(MapColor.COLOR_BLUE)
    );
    public static final Block STAGNANT_NYLIUM = register(
            PookstirsEnhancedNetherBlockIDs.STAGNANT_NYLIUM,
            NyliumBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()
    );
    public static final Block STAGNANT_FUNGUS = register(
            PookstirsEnhancedNetherBlockIDs.STAGNANT_FUNGUS,
            (p) -> new NetherFungusBlock(PookstirsEnhancedNetherFeatures.STAGNANT_FUNGUS_PLANTED,
                    STAGNANT_NYLIUM, PookstirsEnhancedNetherBlockTags.SUPPORTS_STAGNANT_FUNGUS, p),
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instabreak().noCollision()
                    .sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY)
    );

    public static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory,
                                 BlockBehaviour.Properties properties) {
        Block block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory,
                                  BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    public static void initialize() {
    }
}
