package pookstir.pookstirsenhancednether.client.datagen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;

public class HugeFungusCodecForDatagen {
    public static final Codec<HugeFungusCodecForDatagen> CODEC = RecordCodecBuilder.create(
            (i) -> i.group(
                    Codec.STRING.fieldOf("type").forGetter((c) -> c.type),
                    HugeFungusConfiguration.CODEC.fieldOf("config")
                            .forGetter((c) -> c.config)
            ).apply(i, HugeFungusCodecForDatagen::new));

    public final String type;
    public final HugeFungusConfiguration config;

    public HugeFungusCodecForDatagen(final HugeFungusConfiguration config) {
        this.type = "minecraft:huge_fungus";
        this.config = config;
    }

    public HugeFungusCodecForDatagen(final String type, final HugeFungusConfiguration config) {
        this.type = type;
        this.config = config;
    }
}
