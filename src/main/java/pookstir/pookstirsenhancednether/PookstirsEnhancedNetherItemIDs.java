package pookstir.pookstirsenhancednether;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class PookstirsEnhancedNetherItemIDs {
    public static final ResourceKey<Item> VOLATILE_CHARGE = create("volatile_charge");

    private static ResourceKey<Item> create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name);
        return ResourceKey.create(Registries.ITEM, id);
    }
}
