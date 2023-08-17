package net.mango.desertoverhaul;

import net.fabricmc.api.ModInitializer;

import net.mango.desertoverhaul.block.ModBlocks;
import net.mango.desertoverhaul.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesertOverhaul implements ModInitializer {
	public static final String MOD_ID = "desertoverhaul";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}