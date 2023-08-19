package net.mango.desertoverhaul.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public static final float[] SAPLING_DROP_CHANCE = new float[]{0.05f, 0.0625f, 0.083333336f, 0.1f};

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PALM_LOG);
        addDrop(ModBlocks.PALM_WOOD);
        addDrop(ModBlocks.STRIPPED_PALM_LOG);
        addDrop(ModBlocks.STRIPPED_PALM_WOOD);
        addDrop(ModBlocks.PALM_PLANKS);

        addDrop(ModBlocks.PALM_LEAVES, (Block block) -> this.leavesDrops(block, ModBlocks.PALM_SAPLING, SAPLING_DROP_CHANCE));

    }
}
