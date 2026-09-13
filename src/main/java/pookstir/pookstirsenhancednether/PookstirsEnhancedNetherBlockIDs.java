package pookstir.pookstirsenhancednether;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class PookstirsEnhancedNetherBlockIDs {
    public static final BlockItemId STAGNANT_WART_BLOCK = create("stagnant_wart_block");
    public static final BlockItemId STAGNANT_STEM = create("stagnant_stem");
    public static final BlockItemId STAGNANT_NYLIUM = create("stagnant_nylium");
    public static final BlockItemId STAGNANT_FUNGUS = create("stagnant_fungus");

    private static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name);
        return BlockItemId.create(id, id);
    }
}
