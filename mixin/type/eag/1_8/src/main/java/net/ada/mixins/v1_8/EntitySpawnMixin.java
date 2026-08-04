package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.capability.EntityCapabilityRegistry;
import net.ada.v1_8.event.EntitySpawnEvent;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
@Mixin(World.class)
public class EntitySpawnMixin {
    @Inject(method = "spawnEntityInWorld", at = At.HEAD)
    private void herz$spawnEntityInWorld(Entity entityIn) {
        EntityCapabilityRegistry.attachAll(entityIn);
        EventBus.INSTANCE.post(new EntitySpawnEvent(entityIn));
    }
}
