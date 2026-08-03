package net.ada.v1_8.loot;

import net.minecraft.entity.EntityLivingBase;

public interface EntityLootModifier {
    void drop(EntityLivingBase entity, boolean recentlyHit, int looting);
}
