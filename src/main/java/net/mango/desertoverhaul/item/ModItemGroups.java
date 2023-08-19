package net.mango.desertoverhaul.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mango.desertoverhaul.DesertOverhaul;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier("mod_group", DesertOverhaul.MOD_ID),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.mod"))
                    .icon(() -> new ItemStack(ModBlocks.PALM_LOG))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PALM_LOG);
                        entries.add(ModBlocks.PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_PALM_WOOD);

                        entries.add(ModBlocks.PALM_PLANKS);
                        entries.add(ModBlocks.PALM_LEAVES);

                        entries.add(ModBlocks.PALM_SAPLING);

                    }).build());

    public static void registerItemGroups() {
        DesertOverhaul.LOGGER.info("Registering mod item groups for " + DesertOverhaul.MOD_ID);
    }
}
