package net.mango.desertoverhaul;

import net.fabricmc.api.ModInitializer;

import net.mango.desertoverhaul.block.ModBlocks;
import net.mango.desertoverhaul.block.ModFlammableBlockRegistry;
import net.mango.desertoverhaul.block.ModStrippableBlockRegistry;
import net.mango.desertoverhaul.item.ModItemGroups;
import net.mango.desertoverhaul.item.ModItems;
import net.mango.desertoverhaul.world.tree.foliage.ModFoliagePlacerType;
import net.mango.desertoverhaul.world.tree.trunk.ModTrunkPlacerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesertOverhaul implements ModInitializer {
	public static final String MOD_ID = "desertoverhaul";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		ModStrippableBlockRegistry.registerStrippableBlocks();

		ModTrunkPlacerType.init();
		ModFoliagePlacerType.init();
	}
}