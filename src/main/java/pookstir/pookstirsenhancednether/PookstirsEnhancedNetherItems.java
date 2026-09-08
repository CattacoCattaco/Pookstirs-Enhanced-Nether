package pookstir.pookstirsenhancednether;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import pookstir.pookstirsenhancednether.specialitems.VolatileChargeItem;

public class PookstirsEnhancedNetherItems {
    public static final Item VOLATILE_CHARGE = register(
            PookstirsEnhancedNetherItemIDs.VOLATILE_CHARGE,
            VolatileChargeItem::new,
            (new Item.Properties()).useCooldown(0.5f)
    );

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory,
                                Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        DispenserBlock.registerProjectileBehavior(VOLATILE_CHARGE);
    }
}
