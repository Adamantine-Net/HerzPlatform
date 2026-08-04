package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.EntityMountEvent;
import net.minecraft.entity.Entity;
@Mixin(Entity.class)
public class EntityMountMixin {
    @Inject(method = "mountEntity", at = At.HEAD)
    private void herz$mountEntity(Entity entity) {
        EventBus.INSTANCE.post(new EntityMountEvent((Entity) (Object) this, entity));
    }
}
