package net.mango.desertoverhaul.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mango.desertoverhaul.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> PALM_PLANKS_CRAFTABLE = List.of(ModBlocks.PALM_LOG, ModBlocks.PALM_WOOD,
            ModBlocks.STRIPPED_PALM_LOG, ModBlocks.STRIPPED_PALM_WOOD);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerShapelessRecipe(exporter, ModBlocks.PALM_PLANKS, ModBlocks.PALM_LOG,null, 4);
    }
}
