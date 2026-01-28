package com.davigj.brushstrokes.core.events;

import com.davigj.brushstrokes.core.BrushStrokes;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber({Dist.CLIENT})
public class BSClientEvents {
    @SubscribeEvent
    public static void onTick(ClientTickEvent.Post event) {
        if (isGameActive()) {
            BrushStrokes.SELECTION_HANDLER.tick();
        }
    }

    protected static boolean isGameActive() {
        return Minecraft.getInstance().level != null && Minecraft.getInstance().player != null;
    }
}