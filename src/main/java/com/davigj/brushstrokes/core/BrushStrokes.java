package com.davigj.brushstrokes.core;

import com.davigj.brushstrokes.client.SelectionHandler;
import com.davigj.brushstrokes.core.registry.BSComponents;
import com.davigj.brushstrokes.core.registry.BSCreativePlacements;
import com.davigj.brushstrokes.core.registry.BSItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@Mod(BrushStrokes.MOD_ID)
public class BrushStrokes {
    public static final String MOD_ID = "brushstrokes";
    public static SelectionHandler SELECTION_HANDLER;

    public BrushStrokes(IEventBus bus, ModContainer modContainer) {
        BSComponents.DATA_COMPONENTS.register(bus);
        BSItems.ITEMS.register(bus);
        bus.addListener(BSCreativePlacements::set);

        bus.addListener(this::addOverridePacks);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, BSConfig.COMMON_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            SELECTION_HANDLER = new SelectionHandler();
        });
    }

    private void dataSetup(GatherDataEvent event) {

    }

    private void addOverridePacks(AddPackFindersEvent event) {
        event.addPackFinders(BrushStrokes.asResource("overrides"), PackType.CLIENT_RESOURCES, Component.literal("Brush Strokes Overrides"), PackSource.BUILT_IN, false, Pack.Position.TOP);
        event.addPackFinders(BrushStrokes.asResource("data_overrides"), PackType.SERVER_DATA, Component.literal("Brush Strokes Data Overrides"), PackSource.BUILT_IN, false, Pack.Position.TOP);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}