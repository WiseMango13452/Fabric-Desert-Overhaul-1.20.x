package net.mango.desertoverhaul;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.item.BlockItem;

public class DesertOverhaulClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            }
            return BiomeColors.getFoliageColor(world, pos);
        }, ModBlocks.PALM_LEAVES);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x6f9c30, ModBlocks.PALM_LEAVES);
    }
}
