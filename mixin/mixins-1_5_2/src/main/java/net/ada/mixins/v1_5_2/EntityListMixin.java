package net.ada.mixins.v1_5_2;

import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.mixin.annotation.Shadow;
import net.ada.v1_5_2.entity.EntityRegistry;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.World;

import java.util.function.Function;

@Mixin(EntityList.class)
public class EntityListMixin {

    @Shadow
    private static void addMapping(Class entityClass, Function<World, Entity> constructor, String name, int id) {
    }

    @Inject(method = "<clinit>", at = At.TAIL)
    private static void herz$afterClinit() {
        for (EntityRegistry.Pending pending : EntityRegistry.flush()) {
            addMapping(pending.entityClass, pending.constructor, pending.name, pending.id);
        }
    }
}
