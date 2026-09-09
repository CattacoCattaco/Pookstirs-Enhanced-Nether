package pookstir.pookstirsenhancednether;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

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
