package net.mango.desertoverhaul;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class DesertOverhaulClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModBlocks.colorPalmLeaves();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING, RenderLayer.getCutout());
    }
}
