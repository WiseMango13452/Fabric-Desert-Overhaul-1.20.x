package net.mango.desertoverhaul.world.tree;

import com.mojang.serialization.Codec;
import net.mango.desertoverhaul.DesertOverhaul;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.*;

public class ModTrunkPlacerType<P extends TrunkPlacer> {
    private final Codec<P> codec;

    public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = ModTrunkPlacerType.register(
            new Identifier(DesertOverhaul.MOD_ID, "palm_trunk_placer"), PalmTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(Identifier id, Codec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, id, new TrunkPlacerType<P>(codec));
    }

    public ModTrunkPlacerType(Codec<P> codec) {
        this.codec = codec;
    }

    public Codec<P> getCodec() {
        return this.codec;
    }

    public static void init() {}
}
