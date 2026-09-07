package pookstir.pookstirsenhancednether.client.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class PookstirsEnhancedNetherLangProvider extends FabricLanguageProvider {
    public PookstirsEnhancedNetherLangProvider(FabricPackOutput dataOutput,
                                                  CompletableFuture<HolderLookup.Provider> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    private static String getKey(String category, String name) {
        return category + ".pookstirs-enhanced-nether." + name;
    }

    @Override
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(getKey("block", "stagnant_wart_block"), "Stagnant Wart Block");
    }
}
