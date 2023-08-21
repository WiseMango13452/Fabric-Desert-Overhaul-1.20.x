package net.mango.desertoverhaul.world.tree.trunk;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.mango.desertoverhaul.world.tree.foliage.PalmFoliagePlacer;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    private final int minHeightForLeaves;
    private final IntProvider bendLength;

    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> PalmTrunkPlacer.fillTrunkPlacerFields(instance).apply(instance, (i, j, k) -> new PalmTrunkPlacer
                    (i, j, k, 1, UniformIntProvider.create(1, 2))));

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, int minHeightForLeaves, IntProvider bendLength) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.minHeightForLeaves = minHeightForLeaves;
        this.bendLength = bendLength;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerType.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int j;
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        int i = height - 1;
        BlockPos.Mutable mutable = startPos.mutableCopy();
        Vec3i blockPos = mutable.down();
        BendingTrunkPlacer.setToDirt(world, replacer, random, (BlockPos)blockPos, config);
        ArrayList<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        int trunkBase = random.nextBetween(1,2);

        j = this.bendLength.get(random);
        for (int k = 0; k <= j; ++k) {
            if(k < trunkBase) {
                if (TreeFeature.canReplace(world, mutable)) {
                    this.getAndSetState(world, replacer, random, mutable, config);
                }
                mutable.move(direction);
            }
        }
        mutable.move(Direction.UP);
        for (j = 0; j <= i; ++j) {
            if (j + 1 >= i + random.nextInt(2)) {
                mutable.move(direction);
            }
            if (TreeFeature.canReplace(world, mutable)) {
                this.getAndSetState(world, replacer, random, mutable, config);
            }
            mutable.move(Direction.UP);
        }
        new PalmFoliagePlacer(UniformIntProvider.create(1,1), UniformIntProvider.create(1,1));
        return list;
    }
}
