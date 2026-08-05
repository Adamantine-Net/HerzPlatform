package net.ada.v1_8.loot;

import net.minecraft.entity.EntityLivingBase;

import java.util.HashMap;
import java.util.Map;

public final class EntityLootRegistry {

    private static final Map<Class<? extends EntityLivingBase>, EntityLootModifier> byClass = new HashMap<>();

    public static void register(Class<? extends EntityLivingBase> entityClass, EntityLootModifier modifier) {
        byClass.put(entityClass, modifier);
    }

    public static EntityLootModifier get(Class<? extends EntityLivingBase> entityClass) {
        return byClass.get(entityClass);
    }

    private EntityLootRegistry() {
    }
}
