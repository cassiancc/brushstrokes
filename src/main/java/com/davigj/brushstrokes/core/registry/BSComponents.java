package com.davigj.brushstrokes.core.registry;

import com.davigj.brushstrokes.core.BrushStrokes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.UnaryOperator;


public class BSComponents {
    public static final DataComponentType<BlockPos> START_POS = register("start_pos", (builder) -> builder.persistent(BlockPos.CODEC).networkSynchronized(BlockPos.STREAM_CODEC));

	public static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
		return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, BrushStrokes.asResource(name), builderOperator.apply(DataComponentType.builder()).build());
	}

	public static void register() {

	}
}
