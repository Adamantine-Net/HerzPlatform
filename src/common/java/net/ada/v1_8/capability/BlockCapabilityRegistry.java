package net.ada.v1_8.capability;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public final class BlockCapabilityRegistry {

    public interface Attacher {
        void attach(World world, BlockPos pos, IBlockState state);
    }

    private static final List<Attacher> attachers = new ArrayList<>();

    public static void register(Attacher attacher) {
        attachers.add(attacher);
    }

    public static void attachAll(World world, BlockPos pos, IBlockState state) {
        for (Attacher attacher : attachers) {
            attacher.attach(world, pos, state);
        }
    }

    private BlockCapabilityRegistry() {
    }
}
