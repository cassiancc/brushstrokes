package com.davigj.brushstrokes.client;

import com.davigj.brushstrokes.core.BrushStrokes;
import net.createmod.catnip.api.client.render.BindableTexture;
import net.minecraft.resources.Identifier;

public enum OverlayTextures implements BindableTexture {
    DYE("dye.png"),
    WAX("wax.png");

    public static final String ASSET_PATH = "textures/special/";
    private final Identifier location;

    OverlayTextures(String filename) {
        this.location = BrushStrokes.asResource(ASSET_PATH + filename);
    }

    @Override
    public Identifier getId() {
        return this.location;
    }
}
