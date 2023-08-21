package net.mango.desertoverhaul.world.tree.foliage;

import com.mojang.serialization.Codec;
import net.mango.desertoverhaul.DesertOverhaul;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerType<P extends FoliagePlacer> {
    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = ModFoliagePlacerType.register(
            new Identifier(DesertOverhaul.MOD_ID, "palm_foliage_placer"), PalmFoliagePlacer.CODEC);

    private static <P extends FoliagePlacer> FoliagePlacerType<P> register(Identifier id, Codec<P> codec) {
        return Registry.register(Registries.FOLIAGE_PLACER_TYPE, id, new FoliagePlacerType<P>(codec));
    }

    public static void init() {}
}
