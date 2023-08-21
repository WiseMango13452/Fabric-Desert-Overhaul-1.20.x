package net.mango.desertoverhaul.world.tree.trunk;

import com.mojang.serialization.Codec;
import net.mango.desertoverhaul.DesertOverhaul;
import net.mango.desertoverhaul.world.tree.foliage.ModFoliagePlacerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.*;

public class ModTrunkPlacerType<P extends TrunkPlacer> {

    public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = ModTrunkPlacerType.register(
            new Identifier(DesertOverhaul.MOD_ID, "palm_trunk_placer"), PalmTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(Identifier id, Codec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, id, new TrunkPlacerType<P>(codec));
    }

    public static void init() {}
}
