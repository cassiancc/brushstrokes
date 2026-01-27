package com.davigj.brushstrokes.core;

import com.davigj.brushstrokes.client.SelectionHandler;
import com.davigj.brushstrokes.core.registry.BSComponents;
import com.davigj.brushstrokes.core.registry.BSCreativePlacements;
import com.davigj.brushstrokes.core.registry.BSItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class BrushStrokes implements ModInitializer {
    public static final String MOD_ID = "brushstrokes";
    public static SelectionHandler SELECTION_HANDLER;


    @Override
    public void onInitialize() {

        BSComponents.register();
        BSItems.register();
        BSCreativePlacements.set();

        addOverridePacks();
    }

    public static void clientSetup() {
        SELECTION_HANDLER = new SelectionHandler();
    }

    private void addOverridePacks() {
        var packTitle = Component.literal("Brush Strokes Overrides");
        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.fromNamespaceAndPath(MOD_ID, "overrides"), container, packTitle, ResourcePackActivationType.NORMAL);
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.fromNamespaceAndPath(MOD_ID, "data_overrides"), container, packTitle, ResourcePackActivationType.NORMAL);
    }

    public static Identifier asResource(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}