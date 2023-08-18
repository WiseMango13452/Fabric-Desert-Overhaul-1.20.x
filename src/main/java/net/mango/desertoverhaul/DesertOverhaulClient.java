package net.mango.desertoverhaul;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.world.BlockRenderView;

public class DesertOverhaulClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockColors blockColors = new BlockColors();
        /*ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getDefaultColor();
            }
            return BiomeColors.getFoliageColor(world, pos);
        }. DesertOverhaul.PALM_LEAVES);*/
    }
}
