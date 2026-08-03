package dev.notanorange.mixins.v1_8;

import dev.notanorange.mixin.annotation.At;
import dev.notanorange.mixin.annotation.Inject;
import dev.notanorange.mixin.annotation.Mixin;
import dev.notanorange.mixin.annotation.Shadow;
import dev.notanorange.v1_8.entity.EntityRegistry;

import net.lax1dude.eaglercraft.v1_8.minecraft.EntityConstructor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

@Mixin(EntityList.class)
public class EntityListMixin {

    @Shadow
    private static void addMapping(Class<? extends Entity> entityClass,
                                    EntityConstructor<? extends Entity> entityConstructor, String entityName, int id) {
    }

    @Inject(method = "<clinit>", at = At.TAIL)
    private static void herz$afterClinit() {
        for (EntityRegistry.Pending pending : EntityRegistry.flush()) {
            addMapping(pending.entityClass, pending.constructor, pending.name, pending.id);
        }
    }
}
