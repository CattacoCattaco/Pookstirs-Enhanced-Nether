package pookstir.pookstirsenhancednether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PookstirsEnhancedNetherBlockTags {
    public static final TagKey<Block> SUPPORTS_STAGNANT_FUNGUS = create("supports_stagnant_fungus");
    public static final TagKey<Block> STAGNANT_STEMS = create("stagnant_stems");

    private static TagKey<Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name));
    }
}
