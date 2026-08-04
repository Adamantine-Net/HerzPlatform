package net.ada.v1_5_2.loot;

import net.minecraft.src.EntityLiving;

public interface EntityLootModifier {
    void drop(EntityLiving entity, boolean recentlyHit, int looting);
}
