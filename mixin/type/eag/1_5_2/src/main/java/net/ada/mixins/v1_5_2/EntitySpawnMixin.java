package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.capability.EntityCapabilityRegistry;
import net.ada.v1_5_2.event.EntitySpawnEvent;
import net.minecraft.src.Entity;
import net.minecraft.src.World;
@Mixin(World.class)
public class EntitySpawnMixin {
    @Inject(method = "spawnEntityInWorld", at = At.HEAD)
    private void herz$spawnEntityInWorld(Entity entityIn) {
        EntityCapabilityRegistry.attachAll(entityIn);
        EventBus.INSTANCE.post(new EntitySpawnEvent(entityIn));
    }
}
