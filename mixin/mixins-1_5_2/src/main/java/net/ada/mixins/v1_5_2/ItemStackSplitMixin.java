package net.ada.mixins.v1_5_2;
import net.ada.api.event.EventBus;
import net.ada.mixin.annotation.At;
import net.ada.mixin.annotation.Inject;
import net.ada.mixin.annotation.Mixin;
import net.ada.v1_5_2.event.ItemStackSplitEvent;
import net.minecraft.src.ItemStack;
@Mixin(ItemStack.class)
public class ItemStackSplitMixin {
    @Inject(method = "splitStack", at = At.HEAD)
    private void herz$splitStack(int amount) {
        EventBus.INSTANCE.post(new ItemStackSplitEvent((ItemStack) (Object) this, amount));
    }
}
