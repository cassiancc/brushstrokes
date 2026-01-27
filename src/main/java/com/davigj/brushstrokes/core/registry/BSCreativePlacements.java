package com.davigj.brushstrokes.core.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class BSCreativePlacements {
    public static void set() {
        CreativeModeTabEvents.modifyOutputEvent((CreativeModeTabs.TOOLS_AND_UTILITIES)).register(event -> {
            event.accept(BSItems.WAX_BRUSH);
        });
    }
}
