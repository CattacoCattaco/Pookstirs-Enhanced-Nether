package pookstir.pookstirsenhancednether.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import pookstir.pookstirsenhancednether.PookstirsEnhancedNetherEntityTypes;

public class PookstirsEnhancedNetherEntityRenderers {
    public static void initialize() {
        EntityRenderers.register(PookstirsEnhancedNetherEntityTypes.VOLATILE_CHARGE,
                (context) -> new ThrownItemRenderer<>(context, 3.0F, true));
    }
}
