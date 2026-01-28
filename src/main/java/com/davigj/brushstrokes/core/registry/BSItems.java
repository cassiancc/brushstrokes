package com.davigj.brushstrokes.core.registry;

import com.davigj.brushstrokes.common.item.WaxBrushItem;
import com.davigj.brushstrokes.core.BrushStrokes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class BSItems {
    public static final Item WAX_BRUSH;

    static {
        WAX_BRUSH = register("wax_brush", new WaxBrushItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, BrushStrokes.asResource("wax_brush"))).stacksTo(1).durability(99)));
    }

    public BSItems() {
    }

    public static Item register(String name, Item supplier) {
        return Registry.register(BuiltInRegistries.ITEM, BrushStrokes.asResource(name), supplier);
    }

	public static void register() {

	}
}
