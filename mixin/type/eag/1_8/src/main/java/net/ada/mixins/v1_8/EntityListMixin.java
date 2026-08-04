package net.ada.mixins.v1_8;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_8.entity.EntityRegistry;

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
