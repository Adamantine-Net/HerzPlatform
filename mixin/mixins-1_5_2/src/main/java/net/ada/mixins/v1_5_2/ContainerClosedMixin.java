package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ContainerClosedEvent;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
@Mixin(Container.class)
public class ContainerClosedMixin {
    @Inject(method = "onCraftGuiClosed", at = At.HEAD)
    private void herz$onCraftGuiClosed(EntityPlayer playerIn) {
        EventBus.INSTANCE.post(new ContainerClosedEvent((Container) (Object) this, playerIn));
    }
}
