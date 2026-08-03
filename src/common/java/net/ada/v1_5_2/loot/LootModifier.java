package net.ada.v1_5_2.loot;

import net.minecraft.src.World;

public interface LootModifier {
    void drop(World world, int x, int y, int z, int metadata, float chance, int fortune);
}
