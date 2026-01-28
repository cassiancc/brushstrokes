package com.davigj.brushstrokes.core.registry;

import com.davigj.brushstrokes.common.item.WaxBrushItem;
import com.davigj.brushstrokes.core.BrushStrokes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class BSItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final DeferredHolder<Item, Item> WAX_BRUSH;

    static {
        ITEMS = DeferredRegister.create(Registries.ITEM, BrushStrokes.MOD_ID);
        WAX_BRUSH = register("wax_brush", () -> new WaxBrushItem(new Item.Properties().stacksTo(1).durability(99)));
    }

    public BSItems() {
    }

    public static DeferredHolder<Item, Item> register(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

}
