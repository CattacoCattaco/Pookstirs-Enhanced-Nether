package pookstir.pookstirsenhancednether;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import pookstir.pookstirsenhancednether.specialitems.VolatileCharge;

public class PookstirsEnhancedNetherEntityTypes {
    public static final EntityType<VolatileCharge> VOLATILE_CHARGE = register(
            PookstirsEnhancedNetherEntityTypeIDs.VOLATILE_CHARGE,
            EntityType.Builder.<VolatileCharge>of(VolatileCharge::new, MobCategory.MISC).noLootTable().sized(1.0F, 1.0F)
                    .clientTrackingRange(4).updateInterval(10)
    );

    private static <T extends Entity> EntityType<T> register(final ResourceKey<EntityType<?>> id, final EntityType.Builder<T> builder) {
        return (EntityType) Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(id));
    }

    public static void initialize() {

    }
}
