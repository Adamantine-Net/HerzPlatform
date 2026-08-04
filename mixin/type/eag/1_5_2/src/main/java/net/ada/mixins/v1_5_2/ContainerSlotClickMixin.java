package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ContainerSlotClickEvent;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
@Mixin(Container.class)
public class ContainerSlotClickMixin {
    @Inject(method = "slotClick", at = At.HEAD)
    private void herz$slotClick(int slotId, int clickedButton, int mode, EntityPlayer playerIn) {
        EventBus.INSTANCE.post(new ContainerSlotClickEvent((Container) (Object) this, slotId, playerIn));
    }
}
