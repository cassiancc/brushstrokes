package com.davigj.brushstrokes.core.events;

import com.davigj.brushstrokes.core.BrushStrokes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

public class BSClientEvents implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (isGameActive()) {
                BrushStrokes.SELECTION_HANDLER.tick();
            }
        });
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            BrushStrokes.clientSetup();
        });
    }

    protected static boolean isGameActive() {
        return Minecraft.getInstance().level != null && Minecraft.getInstance().player != null;
    }
}