package pookstir.pookstirsenhancednether.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import pookstir.pookstirsenhancednether.PookstirsEnhancedNether;

public class PookstirsEnhancedNetherFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STAGNANT_FUNGUS_PLANTED =
            createKey("stagnant_fungus_planted");

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(final String name) {
        Identifier id = Identifier.fromNamespaceAndPath(PookstirsEnhancedNether.MOD_ID, name);
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, id);
    }
}
