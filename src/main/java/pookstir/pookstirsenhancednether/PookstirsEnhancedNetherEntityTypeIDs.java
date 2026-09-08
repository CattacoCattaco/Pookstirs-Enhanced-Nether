package pookstir.pookstirsenhancednether;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class PookstirsEnhancedNetherEntityTypeIDs {
    public static final ResourceKey<EntityType<?>> VOLATILE_CHARGE = create("volatile_charge");

    private static ResourceKey<EntityType<?>> create(final String name) {
        Identifier id = Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name);
        return ResourceKey.create(Registries.ENTITY_TYPE, id);
    }
}
