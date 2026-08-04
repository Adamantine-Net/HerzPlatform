package net.ada.mixins.v1_8;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_8.event.ContainerClosedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
@Mixin(Container.class)
public class ContainerClosedMixin {
    @Inject(method = "onContainerClosed", at = At.HEAD)
    private void herz$onContainerClosed(EntityPlayer playerIn) {
        EventBus.INSTANCE.post(new ContainerClosedEvent((Container) (Object) this, playerIn));
    }
}
