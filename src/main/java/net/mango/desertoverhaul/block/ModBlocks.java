package net.mango.desertoverhaul.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mango.desertoverhaul.DesertOverhaul;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PALM_LOG = registerBlock("palm_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LOG)));

    public static final Block PALM_LEAVES = Blocks.register("palm_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LEAVES)));

    private static void addBlockToBuildingBlockGroup(FabricItemGroupEntries entries) {
        entries.add(PALM_LOG);
    }

    private static void addBlockToNaturalsGroup(FabricItemGroupEntries entries) {
        entries.add(new ItemStack(PALM_LOG));
        entries.add(new ItemStack(PALM_LEAVES));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DesertOverhaul.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DesertOverhaul.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        DesertOverhaul.LOGGER.info("Registering mod blocks for " + DesertOverhaul.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlockToBuildingBlockGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlockToNaturalsGroup);
    }
}
