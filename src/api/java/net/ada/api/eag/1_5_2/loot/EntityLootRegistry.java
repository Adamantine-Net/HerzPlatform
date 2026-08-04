package net.ada.v1_5_2.loot;

import net.minecraft.src.EntityLiving;

import java.util.HashMap;
import java.util.Map;

public final class EntityLootRegistry {

    private static final Map<Class<? extends EntityLiving>, EntityLootModifier> byClass = new HashMap<>();

    public static void register(Class<? extends EntityLiving> entityClass, EntityLootModifier modifier) {
        byClass.put(entityClass, modifier);
    }

    public static EntityLootModifier get(Class<? extends EntityLiving> entityClass) {
        return byClass.get(entityClass);
    }

    private EntityLootRegistry() {
    }
}
