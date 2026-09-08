package pookstir.pookstirsenhancednether.client;

import net.fabricmc.api.ClientModInitializer;

public class PookstirsEnhancedNetherClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		PookstirsEnhancedNetherEntityRenderers.initialize();
	}
}